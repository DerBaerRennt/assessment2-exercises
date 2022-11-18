package assessment2_practice.books;

public class Book {
    private String title;
    private String author;
    private double price;
    private String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.price = 0.0;
        this.isbn = isbn;
    }

    public Book(String title, String author, double prize, String isbn) {
        this.title = title;
        this.author = author;
        this.price = prize;
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public double getPrice() {
        return price;
    }
    public String getTitle() {
        return title;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
