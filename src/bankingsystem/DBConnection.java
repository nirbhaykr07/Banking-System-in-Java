package bankingsystem;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    static Connection con = null;

    public static Connection getConnection() {
        if (con != null) {
            return con;
        }
        return getConnectionDB();
    }

    private static Connection getConnectionDB() {
        try {
            String url = "jdbc:sqlite:C:/sqlite/BMS.db";
            con = DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}
