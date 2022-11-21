package assessment2_practice.assessment;


import assessment2_practice.books.Book;
import assessment2_practice.test.Test;

public class Exercise1 {

    public static boolean isValidISBN(String isbn) {
        // TODO: Exercise 1a
        // TODO: Sind genau 13 Digits enthalten ? Es können auch andere Zeichen enthalten sein!!!!
        //alle sonder Zeichen entfernt
        String onlyDigits = isbn.replaceAll("\\D+", "");

        // TODO: alle 13 Digits in ein Array schreiben
        char[] charArray = onlyDigits.toCharArray();

        // TODO: Erste 3 Dugits == 978 or 979
        //System.out.println(onlyDigits.substring(0,2)); // Test
        if (charArray.length == 13 ){

            if (onlyDigits.substring(0,3).equals("978") || onlyDigits.substring(0,3).equals("979")){
                // ToDO: Summe aller Digit bilden wobei die Digit an gerader Stelle mit 3 multipliziert werden
                int summeAllerDigits = 0;
                for (int i = 0; i < charArray.length -1 ; i++) {
                    if ((i+1) % 2 == 0){ //index gerade
                        //9                  //9                 //7*3
                        summeAllerDigits = summeAllerDigits + Character.getNumericValue(charArray[i]) * 3 ;
                    } else {
                        summeAllerDigits = summeAllerDigits + Character.getNumericValue(charArray[i]);
                    }
                }
                // TODO: letztes Digit der Summe extrahieren

                String summeAlsString = Integer.toString(summeAllerDigits);
                char lastDigitt = summeAlsString.charAt(summeAlsString.length() -1 );

                // TODO: Dieses von 10 subtrahieren

                int checkSum = 10 - Character.getNumericValue(lastDigitt);
                String chechSumAsString = Integer.toString(checkSum);
                lastDigitt = chechSumAsString.charAt(chechSumAsString.length() -1 );

                // TODO: Diese mit der 13. Stelle vergleich, wenn identisch dann true zurückgeben
                //int nimmt == nicht .equals
                if (lastDigitt == charArray[12] ){

                    return true;

                }
            }

        }
        return false;
    }
//    public static boolean isValidISBN(String isbn) {
//        // TODO: Exercise 1a
//
//        String justDigits = isbn.replaceAll("\\D+", "");
//        if (justDigits.length() != 13) {
//            return false;
//        }
////        2. check the prefix (= first three digits), they shall be 978 or 979
//        if (!justDigits.startsWith("978") && !justDigits.startsWith("979")) {
//            return false;
//        }
////        3. calculate the checksum / checkdigit and make sure that it matches the last digit of the ISBN:
////        a) multiply each subsequent digit alternately by 1 and 3 and sum up the results //DONE
////        b) determine the next higher number which can be divided by 10
////        c) calculate the difference between b) and a)
////        d) check if the result from c) matches the last digit of the ISBN String
////           9789391392499
//        int ungerade= 0;
//        int gerade = 0;
//
//        for (int i = 0; i < justDigits.length()-1; i+=2) {
//            ungerade +=  Integer.parseInt(String.valueOf(justDigits.charAt(i)));//erst char at dadurch '9'(typ char) dann String ("9") dann int (9).
//        }
//        for (int j = 1; j <justDigits.length() -1; j+=2) {
//            gerade += 3*Integer.parseInt(String.valueOf(justDigits.charAt(j)));
//        }
//
//        int ergbenis = 10-(ungerade+gerade)%10;
//        if (ergbenis == 10) {
//            ergbenis = 0;
//
//
//        }
////       justDigits.endsWith(String.valueOf(ergbenis));
////
//        return ergbenis==Integer.parseInt(String.valueOf(justDigits.charAt(12)));
//    }


    public static boolean hasInvalidISBN(Book book) {
        // TODO: Exercise 1b
        return !isValidISBN(book.getIsbn());
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
