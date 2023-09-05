package org.example;
import com.github.curiousoddman.rgxgen.RgxGen;
import com.github.curiousoddman.rgxgen.iterators.StringIterator;
import java.math.BigInteger;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        /**
         * Ask user for their first and last name, department they were hired for, mail capacity, and
         * their desired password. Generated password if none is selected.
         */
        try {

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

            System.out.println("Your work email is : " + newHire.constructEmail());
            System.out.println(newHire.getPassword());



        } catch (Exception e) {
            throw new IllegalArgumentException("Wrong data input.");
        }
        scanner.close();
    }
}