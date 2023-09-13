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

import static org.example.databaseConnect.databaseConnection;
import static org.example.databaseConnect.insertValues;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        /**
         * Ask user for their first and last name, department they were hired for, mail capacity, and
         * their desired password. Generated password if none is selected.
         */

        databaseConnect databaseConnect = new databaseConnect();






            /**
             * Ask user for all his information, such as name, department hired to, mail capacity,
             * and desired password (randomly generated if none selected).
             * Then all that information will be inserted into the appropriate SQL column in the hires
             * database for security purposes.
             */


            System.out.println("Enter your first name: ");
            String firstName = scanner.next();


            System.out.println("Enter last name: ");
            String lastName = scanner.next();

            System.out.println("Department: ");
            String department = scanner.next();

            System.out.println("Mail capacity: ");
            int capacity = scanner.nextInt();

            User newHire = new User(firstName, lastName, department, "", capacity);

            System.out.println("Enter Password (Enter 'g' for generated password):");
            String password = scanner.next();
            if (password.equals("g")) {
                newHire.setPassword(newHire.generatePassword());
            }else {
                newHire.setPassword(password);
            }

            String employeeEmail = newHire.constructEmail();
            System.out.println("Your work email is : " + employeeEmail);
            System.out.println(newHire.getPassword());

            insertValues(3, firstName, lastName, department, password, capacity, employeeEmail);


        scanner.close();
    }
}