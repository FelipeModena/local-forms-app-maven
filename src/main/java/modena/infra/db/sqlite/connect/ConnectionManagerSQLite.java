package modena.infra.db.sqlite.connect;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManagerSQLite {

    public static Connection connection;

    private final static String DB_NAME = "sqlite_db.db";

    public static Connection getDbConnection() {
        try {
            Class.forName("org.sqlite.JDBC");

            // delete file sqlite_db.db
            File file = new File(DB_NAME);
            file.delete();

            connection = DriverManager.getConnection("jdbc:sqlite:" + DB_NAME);
            checkDatabase();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return connection;

    }

    private static void checkDatabase() {
        try {
            Statement stmt = connection.createStatement();

            dbConfig(stmt);

            adminTableMigration(stmt);

            userTableMigration(stmt);

            projectsTableMigration(stmt);

            userDependentTableMigration(stmt);

            nrTableMigration(stmt);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void dbConfig(Statement stmt) throws SQLException {

        String sqlCreateUserTable = "PRAGMA foreign_keys = ON;";

        try {
            stmt.executeUpdate(sqlCreateUserTable);
            stmt.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

    private static void nrTableMigration(Statement stmt) throws SQLException {

        String sqlCreateUserTable = "CREATE TABLE IF NOT EXISTS nr ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "name TEXT NOT NULL,"
                + "user_id INTEGER NOT NULL,"
                + "created_at DATETIME DEFAULT CURRENT_TIMESTAMP,"
                + "updated_at DATETIME DEFAULT CURRENT_TIMESTAMP,"
                + "FOREIGN KEY(user_id) REFERENCES user (id) ON DELETE CASCADE"
                + ");";

        try {
            stmt.executeUpdate(sqlCreateUserTable);
            stmt.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

    private static void userTableMigration(Statement stmt) throws SQLException {

        String sqlCreateUserTable = "CREATE TABLE IF NOT EXISTS user ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "name TEXT NOT NULL,"
                + "email TEXT ,"
                + "cpf TEXT NOT NULL,"
                + "rg TEXT NOT NULL,"
                + "address TEXT NOT NULL,"
                + "salary REAL NOT NULL,"
                + "pis TEXT NOT NULL,"
                + "work_permit TEXT NOT NULL,"
                + "military_reservist TEXT NOT NULL,"
                + "heiring_date DATETIME NOT NULL,"
                + "operation_state TEXT NOT NULL,"
                + "status BOOLEAN NOT NULL,"
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

    private static void userDependentTableMigration(Statement stmt) throws SQLException {

        String sqlCreateUserTable = "CREATE TABLE IF NOT EXISTS userDependent ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "name TEXT NOT NULL,"
                + "age INTEGER NOT NULL,"
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
                + "start_date TEXT NOT NULL,"
                + "end_date TEXT NOT NULL,"
                + "status BOOLEAN NOT NULL,"
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
                + "username TEXT NOT NULL,"
                + "email TEXT NOT NULL,"
                + "role TEXT NOT NULL,"
                + "status TEXT NOT NULL,"
                + "logged BOOLEAN ,"
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
