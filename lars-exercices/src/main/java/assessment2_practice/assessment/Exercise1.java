package assessment2_practice.assessment;


import assessment2_practice.books.Book;
import assessment2_practice.test.Test;

public class Exercise1 {

    public static boolean isValidISBN(String isbn) {
        // TODO: Exercise 1a
        return false;
    }

    public static boolean hasInvalidISBN(Book book) {
        // TODO: Exercise 1b
        return false;
    }

    public static void main(String[] args) {

        /*
            Exercise 1a: Implement in the method isValidISBN with the check, if a given ISBN (International
            Standard Book Number) is valid (= return true). Otherwise the method shall return false.
            When talking about an ISBN, we refer to ISBN-13 in this task.

            To understand the structure of a valid ISBN-13 you may have a look at Wikipedia:
            German:
            - @see: https://de.wikipedia.org/wiki/Internationale_Standardbuchnummer#Aufbau_der_ISBN
            English:
            - @see https://en.wikipedia.org/wiki/ISBN#Overview
            - @see: https://en.wikipedia.org/wiki/ISBN#ISBN-13_check_digit_calculation

            To check a ISBN for its validity you need to do three things:
            1. check the number of digits (shall be 13)
            2. check the prefix (= first three digits), they shall be 978 or 979
            3. calculate the checksum / checkdigit and make sure that it matches the last digit of the ISBN:
             a) multiply each subsequent digit alternately by 1 and 3 and sum up the results
             b) determine the next higher number which can be divided by 10
             c) calculate the difference between b) and a)
             d) check if the result from c) matches the last digit of the ISBN String

            Please ensure that the method returns the right result even if the String is slightly mismatching (e.g.
            unnecessary spaces, the letters "ISBN" or "-" characters).
         */

        // Examples of ISBNs, which are valid
        Test.equals(true, isValidISBN("978-9-39-139249-9"));
        Test.equals(true, isValidISBN("ISBN 978-3836287456"));
        Test.equals(true, isValidISBN("979-866919260 0"));
        Test.equals(true, isValidISBN("9783966450546"));

        // Examples of ISBNs, which are not valid
        Test.equals(false, isValidISBN("1234567890123")); // random number
        Test.equals(false, isValidISBN("978-2"));  // incorrect length
        Test.equals(false, isValidISBN("978-939103005-4")); //incorrect checksum - shall be 6
        Test.equals(false, isValidISBN("971-11 11 11 11 1-0")); // incorrect prefix


        /*
            Exercise 1b: Implement the method hasInvalidISBN, which checks a given
            Book object, whether its ISBN is invalid.

            Use the method implemented in exercise 1a for this.

            The method must return false if the ISBN is valid and true otherwise.
         */

        // Examples for books with valid ISBNs
        Test.equals(false, hasInvalidISBN(new Book("Java ist auch eine Insel", "Christian Ullenboom", "ISBN 978-3836287456")));
        Test.equals(false, hasInvalidISBN(new Book("Getting skilled with Java", "M Rashid Raza", "978-9-39-139249-9")));
        Test.equals(false, hasInvalidISBN(new Book("Java Programmieren für Einsteiger", "Simon Flaig", "979-866919260 0")));
        Test.equals(false, hasInvalidISBN(new Book("Java Kompendium: Professionell Java programmieren lernen", "Markus Neumann", "9783966450546")));

        // Examples for books with invalid ISBNs
        Test.equals(true, hasInvalidISBN(new Book("Invalid Test Book 1", "Anonymous", "1234567890123")));
        Test.equals(true, hasInvalidISBN(new Book("Invalid Test Book 2", "Anonymous", "978-2")));
        Test.equals(true, hasInvalidISBN(new Book("Invalid Test Book 3", "Anonymous", "978-939103005-4")));
        Test.equals(true, hasInvalidISBN(new Book("Invalid Test Book 3", "Anonymous", "971-11 11 11 11 1-0")));


    }
}
