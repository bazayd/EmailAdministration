package org.example;

import com.github.curiousoddman.rgxgen.RgxGen;
import com.github.curiousoddman.rgxgen.iterators.StringIterator;

import java.math.BigInteger;
import java.util.Optional;

/**
 * User class creating user email/account.
 * Ex: firstname.lastname@department.company.com
 */
public class User {

    String firstName;
    String lastName;
    String department;
    int capacity;
    String password;


    public User(String firstName, String lastName, String department, String password, int capacity) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.password = password;
        this.capacity = capacity;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public int getCapacity() {

        return capacity;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    /**
     * Generate randomvpassword for user if a password is not manually created.
     * @return password
     */
    public String generatePassword() {

        RgxGen rgxGen = RgxGen.parse("[^A-Z]*[a-z]?[0-9]");
        String password = rgxGen.generate();
        Optional<BigInteger> estimation = rgxGen.getUniqueEstimation();      // The estimation (not accurate, see Limitations) how much unique values can be generated with that pattern.
        StringIterator uniqueStrings = rgxGen.iterateUnique();               // Iterate over unique values (not accurate, see Limitations)
        String notMatching = rgxGen.generateNotMatching();                   // Generate not matching string

        return password;
    }

    public String constructEmail(String firstName, String lastName, String department) {
        String email = firstName + "." + lastName + "@" + department + ".company.com";

        return email;
    }



}
