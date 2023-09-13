package org.example;
import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class databaseConnect {
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String username = System.getenv("db_user");
    private static String password = System.getenv("db_password");
    private static String url = "jdbc:mysql://localhost:3306/new_hires";


    /**
     * Initializes connection to be used throughout the rest of the program
     * @return connection
     */
    public static Connection databaseConnection() {
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (SQLException | ClassNotFoundException e) {
            throw new IllegalStateException("Cannot connect to Database.", e);
        }
    }

    /**
     * Inserts all new hire information to database table.
     * @param employeeID
     * @param firstName
     * @param lastName
     * @param department
     * @param password
     * @param capacity
     * @param email
     */
    public static void insertValues(int employeeID, String firstName, String lastName, String department, String password, int capacity, String email) {
        try {
            String sql = "INSERT INTO hire_info(employeeID, firstName, lastname, department, userpassword, capacity, employeeEmail) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement preparedStmt = databaseConnection().prepareStatement(sql);
            preparedStmt.setInt(1, employeeID);
            preparedStmt.setString(2, firstName);
            preparedStmt.setString(3, lastName);
            preparedStmt.setString(4, department);
            preparedStmt.setString(5, password);
            preparedStmt.setInt(6, capacity);
            preparedStmt.setString(7, email);


            preparedStmt.execute();
            databaseConnection().close();
        }catch (Exception e) {
            throw new IllegalStateException("Cannot add to table.");
        }
    }


}
