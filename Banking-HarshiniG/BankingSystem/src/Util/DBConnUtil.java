package Util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnUtil {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/school";
    private static final String USER = "root";
    private static final String PASSWORD = "xyz123";
    private static Connection con;

    public static Connection getConnection() {
        try {
            if (con == null || con.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Connection Established");
            }
        } catch (Exception e) {
            System.out.println("Connection Failed: " + e.getMessage());
        }
        return con;
    }
}