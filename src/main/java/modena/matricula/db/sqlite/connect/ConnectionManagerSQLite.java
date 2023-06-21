package modena.matricula.db.sqlite.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManagerSQLite {

    private static Connection connectionDb;

    private final static String DB_NAME = "sqlite_db.db";

    public static Connection getDbConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            connectionDb = DriverManager.getConnection("jdbc:sqlite:" + DB_NAME);

            try {
                checkDatabase();
            } catch (Exception e) {
                // TODO: handle exception
            }
            System.out.println("Opened database successfully");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return connectionDb;

    }

    private static void checkDatabase() {
        try {
            Statement stmt = connectionDb.createStatement();

            // Stromg sql to check if table exists
            String sqlCreateAdminTable = "CREATE TABLE IF NOT EXISTS admin ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "name TEXT NOT NULL,"
                    + "email TEXT NOT NULL,"
                    + "password TEXT NOT NULL,"
                    + "created_at DATETIME DEFAULT CURRENT_TIMESTAMP,"
                    + "updated_at DATETIME DEFAULT CURRENT_TIMESTAMP"
                    + ");";

            stmt.executeUpdate(sqlCreateAdminTable);
            stmt.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
