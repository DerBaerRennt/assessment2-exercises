package assessment2_practice.books;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private Bookstore store;
    private int noOfClients ;


    private HashMap<Book,Boolean> books;
    public Library(Bookstore store) {
        this.store=store;
        this.noOfClients = 0;
        this.books = new HashMap<>();
    }
    public void addBook(Book b){
        books.put(b, false);
    }
    public boolean removeBook(Book b){
       if(books.remove(b) == null){
           return false;
       }
        return true;
    }
    public boolean isRented(Book b){
        if (books.get(b) == null){
            return false;
        }
        return books.get(b);

    }
    public void switchRentalState(Book b){
        if(books.get(b)!=null) { // nur wenn das Buch vorhanden ist
            if (books.get(b)) {        // wenn value true ist dann ...
                books.put(b, false);  // setze ihn hier auf false
            } else {                   // ansonsten ist er auf false, ...
                books.put(b, true);    // und deshalb muss er hier auf true gesetz werden
            }
        }
    }

    public boolean checkJavaBooksAvailable(){
        for (Map.Entry<Book, Boolean> entry : books.entrySet()) {
            if (entry.getKey().getTitle().contains("Java")){
                if (!entry.getValue()){
                    return true;
                }
            }

        }
        return false;
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
}
