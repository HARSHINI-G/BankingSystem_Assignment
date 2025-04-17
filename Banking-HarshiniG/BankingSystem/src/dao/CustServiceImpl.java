package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Exception.AccNotFound;
import Exception.InvalidAcc;
import Util.DBConnUtil;

public class CustServiceImpl implements ICustService {

    @Override
    public float getAccountBalance(long accountNumber) throws AccNotFound, SQLException, InvalidAcc {
        String sql = "SELECT balance FROM account WHERE account_number = ?";
        try (Connection con = DBConnUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, accountNumber);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getFloat("balance");
            } else {
                throw new InvalidAcc("Account not found");
            }
        }
    }

    @Override
    public float deposit(long accountNumber, float amount) throws Exception {
        float currentBalance = getAccountBalance(accountNumber);
        float newBalance = currentBalance + amount;

        String sql = "UPDATE account SET balance = ? WHERE account_number = ?";
        try (Connection con = DBConnUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setFloat(1, newBalance);
            ps.setLong(2, accountNumber);
            ps.executeUpdate();
        }
        return newBalance;
    }

    @Override
    public float withdraw(long accountNumber, float amount) throws Exception {
        float currentBalance = getAccountBalance(accountNumber);
        if (currentBalance < amount) {
            throw new Exception("Insufficient Balance");
        }

        float newBalance = currentBalance - amount;
        String sql = "UPDATE account SET balance = ? WHERE account_number = ?";
        try (Connection con = DBConnUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setFloat(1, newBalance);
            ps.setLong(2, accountNumber);
            ps.executeUpdate();
        }
        return newBalance;
    }

    @Override
    public void transfer(long fromAccountNumber, long toAccountNumber, float amount) throws Exception {
        withdraw(fromAccountNumber, amount);
        deposit(toAccountNumber, amount);
    }

    @Override
    public void getAccountDetails(long accountNumber) throws Exception {
        String sql = "SELECT a.account_number, a.balance, a.account_type, " +
                     "c.customer_id, c.first_name, c.last_name, c.email, c.phone, c.address " +
                     "FROM account a JOIN customer c ON a.customer_id = c.customer_id WHERE a.account_number = ?";
        try (Connection con = DBConnUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, accountNumber);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("Account Number: " + rs.getLong("account_number"));
                System.out.println("Account Type: " + rs.getString("account_type"));
                System.out.println("Balance: " + rs.getFloat("balance"));
                System.out.println("Customer Name: " + rs.getString("first_name") + " " + rs.getString("last_name"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Phone: " + rs.getString("phone"));
                System.out.println("Address: " + rs.getString("address"));
            } else {
                System.out.println("Account not found.");
            }
        }
    }
}
