package assessment2_practice.assessment;


import assessment2_practice.books.Book;
import assessment2_practice.books.Bookstore;
import assessment2_practice.test.Test;

import java.util.Set;

public class Exercise2 {

    public static void main(String[] args) {
        /*
            Books are sold by a bookstore. A bookstore keeps track of the
            books and the available capacity of each book to ensure that only books in-stock
            are sold.

            Please check the implementation of the class Bookstore and use the given methods there
            before starting! Look at the JavaDoc comments and understand the structure of the two Maps
            which are used there:
            1. Map stock: contains pairs of ISBNs and amounts of the books (= number of pieces per book)
            2. Map bookDatabase: contains of pairs of ISBNs and book objects

            You do not have to check the validity of the books ISBNs in the following tasks!
         */
        /*
            Exercise 2a: Head to the Bookstore class and implement the method addBook(Book b) there.
            This method shall add a book to the stock of the store as well as to the bookDatabase. It has
            to deal with both maps at the same time!
            The method shall do three things:
            1. If a book is not present in stock, it shall be added with the amount of "1"
            2. If a book is not present in the database, it shall be added.
            3. If a book is present (= ISBN already exists), its amount in stock shall be increased by 1
         */

        // create Book objects
        Book b1 = new Book("Java ist auch eine Insel", "Christian Ullenboom", 49.90, "ISBN 978-3836287456");
        Book b2 = new Book("Getting skilled with Java", "M Rashid Raza", 28.88, "978-9-39-139249-9");
        Book b3 = new Book("Java Programmieren für Einsteiger", "Simon Flaig", 13.95, "979-866919260 0");
        Book b4 = new Book("Java Kompendium: Professionell Java programmieren lernen", "Markus Neumann", 26.99, "9783966450546");

        // create a bookstore and add the books to the store
        Bookstore amazing = new Bookstore();
        // check if the bookstore is empty
        Test.equals(false, amazing.getStock().containsKey("9789391392499"));
        Test.equals(true, amazing.getBookDatabase().isEmpty());

        // add books
        amazing.addBook(b1,12);
        amazing.addBook(b2);
        amazing.addBook(b3,42);
        amazing.addBook(b4,20);

        // check if books are in the bookDatabase
        Test.equals(true ,amazing.getBookDatabase().containsValue(b1));
        Test.equals(true ,amazing.getBookDatabase().containsValue(b2));
        Test.equals(true ,amazing.getBookDatabase().containsValue(b3));
        Test.equals(true ,amazing.getBookDatabase().containsValue(b4));

        // check if books are in stock
        Test.equals(true, amazing.getStock().containsKey("9783836287456"));
        Test.equals(true, amazing.getStock().containsKey("9789391392499"));
        Test.equals(true, amazing.getStock().containsKey("9798669192600"));
        Test.equals(true, amazing.getStock().containsKey("9783966450546"));

        // check the amount of books
        Test.equals(12, amazing.getStock().get("9783836287456"));
        Test.equals(1, amazing.getStock().get("9789391392499"));
        Test.equals(42, amazing.getStock().get("9798669192600"));
        Test.equals(20, amazing.getStock().get("9783966450546"));

        /*
            Exercise 2b: Implement the method filterBooksByPrice(double price) in the Bookstore
            which returns a list of books from the bookstore which are cheaper or equal to the
            value of the parameter.
         */
        Test.equals(Set.of(b3,b4), amazing.filterBooksByPrice(26.99));
        Test.equals(Set.of(), amazing.filterBooksByPrice(9.99));
        Test.equals(true, Set.of(b1,b2,b3,b4).equals(amazing.filterBooksByPrice(49.90)));

        /*
            Exercise 2c:  Implement the method averageStockAmount() in the Bookstore which returns
            a double value indicating the average amount of available books for the full stock.

            Example: If there are three books in stock, the average is calculated as follows:
            Book 1: amount = 13
            Book 2: amount = 11
            Book 3: amount = 6
            averageStockAmount: (13 + 11 + 6) / 3 = 30 / 3 = 10
         */
        Test.equals(18.75, amazing.averageStockAmount());


    }

}
