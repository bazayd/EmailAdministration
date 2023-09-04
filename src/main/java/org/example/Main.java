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

            System.out.println("Enter Password (Leave blank for random password):");
            String password = scanner.next();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }


//        User brandon = new User();


    }
}