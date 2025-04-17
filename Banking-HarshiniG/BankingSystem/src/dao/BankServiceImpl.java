package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import Entity.Account;
import Entity.CurrentAccount;
import Entity.Customer;
import Entity.SavingsAccount;
import Entity.ZeroBalanceAccount;
import Util.DBConnUtil;

public class BankServiceImpl extends CustServiceImpl implements IBankService {

    @Override
    public Account createAccount(Customer customer, String accType, float balance) {
        Connection conn = DBConnUtil.getConnection();
        Account acc = null;

        try {
            String insertCustomer = "INSERT INTO customer VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement psCust = conn.prepareStatement(insertCustomer);
            psCust.setLong(1, customer.getCustomerId());
            psCust.setString(2, customer.getFirstName());
            psCust.setString(3, customer.getLastName());
            psCust.setString(4, customer.getEmail());
            psCust.setString(5, customer.getPhone());
            psCust.setString(6, customer.getAddress());
            psCust.executeUpdate();

            switch (accType.toLowerCase()) {
                case "savings":
                    acc = new SavingsAccount(balance, customer);
                    break;
                case "current":
                    acc = new CurrentAccount(balance, customer);
                    break;
                case "zerobalance":
                    acc = new ZeroBalanceAccount(customer);
                    break;
                default:
                    System.out.println("Invalid account type!");
                    return null;
            }

            String insertAccount = "INSERT INTO account VALUES (?, ?, ?, ?)";
            PreparedStatement psAcc = conn.prepareStatement(insertAccount);
            psAcc.setLong(1, acc.getAccountNumber());
            psAcc.setString(2, accType.toLowerCase());
            psAcc.setFloat(3, acc.getBalance());
            psAcc.setLong(4, customer.getCustomerId());
            psAcc.executeUpdate();

            System.out.println("Account created with number: " + acc.getAccountNumber());

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Customer already exists.");
        } catch (SQLException e) {
            System.out.println("DB Error: " + e.getMessage());
        }

        return acc;
    }

    @Override
    public void listAccounts() {
        Connection conn = DBConnUtil.getConnection();
        String query = "SELECT a.account_number, a.account_type, a.balance, " +
                "c.customer_id, c.first_name, c.last_name, c.email, c.phone, c.address " +
                "FROM account a JOIN customer c ON a.customer_id = c.customer_id";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Customer cust = new Customer(
                        rs.getLong("customer_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("address")
                );

                String accType = rs.getString("account_type");
                float balance = rs.getFloat("balance");
                long accNum = rs.getLong("account_number");

                Account acc;
                if (accType.equalsIgnoreCase("savings")) {
                    acc = new SavingsAccount(balance, cust);
                } else if (accType.equalsIgnoreCase("current")) {
                    acc = new CurrentAccount(balance, cust);
                } else {
                    acc = new ZeroBalanceAccount(cust);
                }
                acc.setAccountNumber(accNum);

                acc.displayAccountInfo();
                cust.displayCustomerInfo();
            }

        } catch (SQLException e) {
            System.out.println("Error fetching accounts: " + e.getMessage());
        }
    }

    @Override
    public void calculateInterest() {
        Connection conn = DBConnUtil.getConnection();
        String query = "UPDATE account SET balance = balance + (balance * 0.04) WHERE account_type = 'savings'";

        try (Statement stmt = conn.createStatement()) {
            int rows = stmt.executeUpdate(query);
            System.out.println("Interest applied to " + rows + " savings accounts.");
        } catch (SQLException e) {
            System.out.println("Interest update failed: " + e.getMessage());
        }
    }
}
