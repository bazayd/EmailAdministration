package org.example;
import com.github.curiousoddman.rgxgen.RgxGen;
import com.github.curiousoddman.rgxgen.iterators.StringIterator;

import javax.swing.plaf.nimbus.State;
import java.math.BigInteger;
import java.sql.*;
import java.util.Date;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static String driver = "com.mysql.jdbc.Driver";
    private static String username = System.getenv("db_user");
    private static String password = System.getenv("db_password");
    private static String url = "jdbc:mysql://localhost:3306/new_hires";
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        /**
         * Ask user for their first and last name, department they were hired for, mail capacity, and
         * their desired password. Generated password if none is selected.
         */


        /*
        Connection to
         */
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");

        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }

        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM hire_info;");
            if (resultSet.next()) {
                String name = resultSet.getString("firstName");
                System.out.println(name);
            }else {
                System.out.println("Empty column values for new hire.");
            }
            statement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        try {



//            System.out.println("Enter your first name: ");
//            String firstName = scanner.next();
//
//            System.out.println("Enter last name: ");
//            String lastName = scanner.next();
//
//            System.out.println("Department: ");
//            String department = scanner.next();
//
//            System.out.println("Mail capacity: ");
//            int capacity = scanner.nextInt();
//
//            User newHire = new User(firstName, lastName, department, "", capacity);
//
//            System.out.println("Enter Password (Enter 'g' for generated password):");
//            String password = scanner.next();
//            if (password.equals("g")) {
//                newHire.setPassword(newHire.generatePassword());
//            }else {
//                newHire.setPassword(password);
//            }
//
//            System.out.println("Your work email is : " + newHire.constructEmail());
//            System.out.println(newHire.getPassword());



        } catch (Exception e) {
            throw new IllegalArgumentException("Wrong data input.");
        }
        scanner.close();
    }
}