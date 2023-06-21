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
            checkDatabase();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return connectionDb;

    }

    private static void checkDatabase() {
        try {
            Statement stmt = connectionDb.createStatement();

            adminTableMigration(stmt);

            userTableMigration(stmt);

            projectsTableMigration(stmt);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void userTableMigration(Statement stmt) throws SQLException {

        String sqlCreateUserTable = "CREATE TABLE IF NOT EXISTS user ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "name TEXT NOT NULL,"
                + "email TEXT NOT NULL,"
                + "cpf TEXT NOT NULL,"
                + "rg TEXT NOT NULL,"
                + "phone TEXT NOT NULL,"
                + "address TEXT NOT NULL,"
                + "salary REAL NOT NULL,"
                + ""
                + "created_at DATETIME DEFAULT CURRENT_TIMESTAMP,"
                + "updated_at DATETIME DEFAULT CURRENT_TIMESTAMP"
                + ");";

        try {
            stmt.executeUpdate(sqlCreateUserTable);
            stmt.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

    private static void projectsTableMigration(Statement stmt) throws SQLException {
        String sqlCreateProjectsTable = "CREATE TABLE IF NOT EXISTS projects ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "name TEXT NOT NULL,"
                + "description TEXT NOT NULL,"
                + "created_at DATETIME DEFAULT CURRENT_TIMESTAMP,"
                + "updated_at DATETIME DEFAULT CURRENT_TIMESTAMP"
                + ");";

        try {
            stmt.executeUpdate(sqlCreateProjectsTable);
            stmt.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    private static void adminTableMigration(Statement stmt) throws SQLException {
        String sqlCreateAdminTable = "CREATE TABLE IF NOT EXISTS admin ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "name TEXT NOT NULL,"
                + "email TEXT NOT NULL,"
                + "password TEXT NOT NULL,"
                + "created_at DATETIME DEFAULT CURRENT_TIMESTAMP,"
                + "updated_at DATETIME DEFAULT CURRENT_TIMESTAMP"
                + ");";

        try {
            stmt.executeUpdate(sqlCreateAdminTable);
            stmt.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
}
