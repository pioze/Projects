public class Book {
    private String book_name;
    private int isbn;
    private String author;
    private String publisher;
    private String dop;

    Book() {
        this("Dummy book", 0, "Dummy", "Dummy", "Jan 01 2000");
    }

    public Book(String book_name, int isbn, String author, String publisher, String dop) {
       this.book_name = book_name;
       this.isbn = isbn;
       this.author = author;
       this.publisher = publisher;
       this.dop = dop;
    }

    @Override
    public String toString() {
        return "Book name = " + book_name + ", isbn = " + isbn + ", author = " + author +
                ", publisher = " + publisher + ", dop = " + dop;
    }

    // getters
    public String getBook_name() {
        return book_name;
    }

    public int getIsbn() {
        return isbn;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getDop() {
        return dop;
    }

    // setters
    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setDop(String dop) {
        this.dop = dop;
    }
}

