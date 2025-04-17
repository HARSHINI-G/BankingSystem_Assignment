package Util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBPropertyUtil {
    private static final String PROPERTY_FILE = "database.properties";
    
    public static String getConnectionString() {
        Properties props = new Properties();
        try (FileInputStream input = new FileInputStream(PROPERTY_FILE)) {
            props.load(input);
            return String.format("jdbc:mysql://%s:%s/%s?user=%s&password=%s",
                props.getProperty("host", "localhost"),
                props.getProperty("port", "3306"),
                props.getProperty("dbname", "banking_system"),
                props.getProperty("user", "root"),
                props.getProperty("password", ""));
        } catch (IOException e) {
            System.err.println("Error reading database properties: " + e.getMessage());
            return "jdbc:mysql://localhost:3306/banking_system?user=root&password=Harshu@123";
        }
    }
}