package assessment2_practice.books;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Bookstore {
    /**
     * the stock of the bookstore.
     * Keys are ISBNs, values are the amount of the book available in stock
     */
    private Map<String, Integer> stock;

    /**
     * the book database of the store.
     * Keys are ISBNs, values are Book objects
     */
    private Map<String, Book> bookDatabase;

    public Bookstore() {
        this.stock = new HashMap<>();
        this.bookDatabase = new HashMap<>();
    }

    /**
     * adds a book to the stock and the bookDatabase of the Bookstore.
     * If a book is not in stock, it is created and its amount is set to 1.
     * If a book is not in the bookDatabase, it is added there as well
     * If a book in already in stock, its amount is incremented by 1
     *
     * @param b the book to be added
     */
    public void addBook(Book b) {
      //TODO: Exercise 2a
//        //TODO: Exercise 2a
//        String normalized = normalizeISBN(b.getIsbn());
//        if (!this.stock.containsKey(normalized)) {
//            this.stock.put(normalized,1);
//        } else  {
//            this.stock.put(normalized, stock.get(normalized) + 1);
//
//        }
//        if (!this.bookDatabase.containsKey(normalized)) {
//            this.bookDatabase.put(normalized,b);
//        }
    }

    /**
     * convenience method to add more than one piece of the book
     * @param b the book to be added
     * @param amount the number of pieces to be added to the bookstore
     */
    public void addBook(Book b, Integer amount) {
        for (int i = 0; i < amount; i++) {
            addBook(b);
        }
    }

    /**
     * normalizes an ISBN by removing all characters from a String that are non-digits.
     * @param isbn
     * @return the normalized ISBN as a String
     */
    private String normalizeISBN(String isbn) {
        return isbn.replaceAll("\\D+","");
    }

    /**
     * filters the book database of the store for books which have a price lower or
     * equal than the provided parameter. The results are returned in a Set.
     * @param price the price which is used for comparison
     * @return a set containing the results of the filter
     */
    public Set<Book> filterBooksByPrice(double price) {
        // TODO: Exercise 2b
        return null;

//        // TODO: Exercise 2b
//        Set<Book> bookListe = new HashSet<>();
//        for (Book book: bookDatabase.values()) {
//            if (book.getPrice()<= price) {
//                bookListe.add(book);
//
//            }
//        }
//        return bookliste;
    }

    /**
     * calculates the average amount of available books in stock by summing up the amount of each book and
     * dividing by the size of the stock
     * @return the average amount of books
     */
    public double averageStockAmount() {
        // TODO: Exercise 2c
        return 0.0;
//        // TODO: Exercise 2c
//        double bookAmount = 0;
//        for (Integer amountOfBooks : stock.values()) {
//            bookAmount += amountOfBooks;
//        }
//
//        return bookAmount / bookDatabase.size();
    }

    public Map<String, Integer> getStock() {
        return stock;
    }

    public Map<String, Book> getBookDatabase() {
        return bookDatabase;
    }
}
