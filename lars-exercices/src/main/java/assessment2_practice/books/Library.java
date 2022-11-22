package assessment2_practice.books;

import java.util.HashMap;
import java.util.Map;

public class Library {

    private Bookstore store;
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

    public void setStore(Bookstore store) {
        this.store = store;
    }

    public int getNoOfClients() {
        return noOfClients;
    }

    public void setNoOfClients(int noOfClients) {
        this.noOfClients = noOfClients;
    }

    public Map<Book, Boolean> getBooks() {
        return books;
    }

    public void setBooks(Map<Book, Boolean> books) {
        this.books = books;
    }

    public void addBook(Book b){
        if(!books.containsKey(b)){
            books.put(b,false);
        }

    }

    public int getNoOfBooks(){
        return books.size();
    }

    public Boolean removeBook(Book book){
        return books.remove(book)!=null;

    }


    public Boolean isRented(Book b){
        if (books.get(b)==null){
            return false;
        }
        return books.get(b);
    }


    public void switchRentalState(Book b){
        if (books.get(b)!=null) {
            if (books.get(b)) {
                books.put(b, false);
            } else {
                books.put(b, true);
            }
        }
    }
    public Boolean checkJavaBooksAvailable(){
        for (Book book:books.keySet()) {
            if (book.getTitle().contains("Java")){
                //wenn das Buch nicht ausgegeben ist -> true
                if (!books.get(book)){
                    return true;
                }
            }

        }return false;
    }
}

