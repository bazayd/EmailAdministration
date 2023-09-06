package org.example;
import java.sql.*;

public class databaseConnect {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String username = System.getenv("db_user");
    private static String password = System.getenv("db_password");
    private static String url = "jdbc:mysql://localhost:3306/hire_info";

    public static Connection databaseConnect() {
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url,username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM hire_data");
            while (resultSet.next()) {
                int columnIndex = 0;
                System.out.println(resultSet.getString(columnIndex));
                connection.close();
            }
            System.out.println("Connected to database.");
        }catch (Exception e) {
            new IllegalArgumentException("Connection error");
        }
        return null;
    }
}
