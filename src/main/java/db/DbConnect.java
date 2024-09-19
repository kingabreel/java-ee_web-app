package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {
    private static Connection connection;

    private DbConnect(){}

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        try {
            if (connection == null) {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/spotifi", "postgres", "postgres");
            }
            return connection;
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: "+ e.getSQLState());
            System.out.println("Error: " + e.getErrorCode());
        }
        return null;
    }
}
