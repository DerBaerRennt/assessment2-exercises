package assessment2_practice.assessment;

import assessment2_practice.books.Book;
import assessment2_practice.books.Bookstore;

import assessment2_practice.books.Library;
import assessment2_practice.test.Test;


public class Exercise3 {

    public static void main(String[] args) {
         /*
            Exercise 3: Create the class Library, which contains information about
            a public library

            Follow the steps and remove the // to test your code!
         */

        /*
            (a) A books must be passed in the constructor.  There must be
            a getter method for it.
         */
        Bookstore thalio = new Bookstore();
        Library cityLibrary = new Library(thalio);
        Test.equals(thalio, cityLibrary.getStore());

        /*
            (b) The number of clients of the library (datatype int) is accessible
            by getter and setter methods. Its default value is 0.
         */
        Test.equals(0, cityLibrary.getNoOfClients());
        cityLibrary.setNoOfClients(91);
        Test.equals(91, cityLibrary.getNoOfClients());

        /*
            (c) The library stores its Books in a collection together with a boolean
            attribute to indicate whether the book is rented or not. Select an appropriate
            collection class and implement the following methods. The collection object
            must be an implementation detail invisible from the outside.

            The method addBook(Book b) must add a book to the library. If the book is already
            part of the library, it must not be added a second time! (= Collection without duplicates)
            When a book is initially added, it is not rented (= false!).

            The method getNoOfBooks must return the number of books in the library.

            The method removeBook must remove the book from the library (and from its collection). It shall return true
            if a book was really removed, otherwise false

            The method switchRentalState(Book b) shall switch the rental state of the book.
            If it was false, it shall be true now. If it was true, it shall be false now.

            HINT: All of these methods are one-liners, if you choose the right collection and use its methods!

         */
        /* Library is initially empty */
        Test.equals(0, cityLibrary.getNoOfBooks());

        Book b1 = new Book("Java ist auch eine Insel", "Christian Ullenboom", 49.90, "ISBN 978-3836287456");
        Book b2 = new Book("Getting skilled with Java", "M Rashid Raza", 28.88, "978-9-39-139249-9");
        Book b3 = new Book("Java Programmieren für Einsteiger", "Simon Flaig", 13.95, "979-866919260 0");
        Book b4 = new Book("Java Kompendium: Professionell Java programmieren lernen", "Markus Neumann", 26.99, "9783966450546");

        /* add books to the library */
        cityLibrary.addBook(b1);
        Test.equals(1, cityLibrary.getNoOfBooks());
        cityLibrary.addBook(b2);
        Test.equals(2, cityLibrary.getNoOfBooks());
        cityLibrary.addBook(b3);
        Test.equals(3, cityLibrary.getNoOfBooks());

        /* trying to add b1 again */
        cityLibrary.addBook(b1);
        Test.equals(3, cityLibrary.getNoOfBooks());
//
//        /* removing b2 */
        Test.equals(true, cityLibrary.removeBook(b2));
        Test.equals(2, cityLibrary.getNoOfBooks());

        /* removing b2 again */
        Test.equals(false, cityLibrary.removeBook(b2));
        Test.equals(2, cityLibrary.getNoOfBooks());

        /*
            (d)
            The method isRented(Book b) shall return true if the passed book is rented, false if it is not.
            When the method is called for book, which is not present in the library, it shall return false
            as well.

            The method switchRentalState(Book b) shall switch the rental state of the book.
            If it was false, it shall be true now. If it was true, it shall be false now. When a book is not
            in the library, nothing shall happen.

            HINT: These methods are probably no one-liners, but they are not big neither.
         */

        cityLibrary.addBook(b2);
        Test.equals(false,cityLibrary.isRented(b2));
        /* rent b2 */
        cityLibrary.switchRentalState(b2);
        Test.equals(true, cityLibrary.isRented(b2));
        /* return b2 */
        cityLibrary.switchRentalState(b2);
        Test.equals(false, cityLibrary.isRented(b2));

        /* test a book which is not in the library */
        Test.equals(false, cityLibrary.isRented(b4));
        cityLibrary.switchRentalState(b4);
        Test.equals(false, cityLibrary.isRented(b4));

        /*
            (e) The method checkJavaBooksAvailable() checks if there are Java books
            available for rent in our library or not. The method shall return a boolean value.

            You need to do the following within this method:
            - Check every book in the library
            - Check if you can find "Java" within the title somewhere
            - Check if the book is available for rent - if so you can directly return true
            - If you are at the end of the library without any available book, return false
         */
        Test.equals(true, cityLibrary.checkJavaBooksAvailable());
        /* set all books to "rented" */
        cityLibrary.switchRentalState(b1);
        cityLibrary.switchRentalState(b2);
        cityLibrary.switchRentalState(b3);
        cityLibrary.switchRentalState(b4);
        Test.equals(false, cityLibrary.checkJavaBooksAvailable());

    }
}
