package assessment2_practice.books;

import java.util.HashMap;
import java.util.Map;

public class Library {

    Bookstore store;
    int noOfClients;

    private Map<Book, Boolean> books;

    public Library(Bookstore store) {
        this.store = store;
        this.noOfClients = 0;
        this.books = new HashMap<>();
    }

    public Bookstore getStore() {
        return store;
    }

    public int getNoOfClients() {
        return noOfClients;
    }

    public void setNoOfClients(int noOfClients) {
        this.noOfClients = noOfClients;
    }

    public int getNoOfBooks() {
        return books.size();
    }

    public void addBook(Book book) {
        books.put(book, false);
    }

    public boolean removeBook(Book book) {
        if (books.remove(book) == null) {
            return false;
        }
        return true;
    }
}
