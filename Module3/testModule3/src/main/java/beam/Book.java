package beam;

public class Book {
    private int id_book;
    private String code_book;
    private String name_book;
    private String author;
    private String description;
    private int quantity;

    public Book() {
    }

    public Book(int id_book, String code_book, String name_book, String author, String description, int quantity) {
        this.id_book = id_book;
        this.code_book = code_book;
        this.name_book = name_book;
        this.author = author;
        this.description = description;
        this.quantity = quantity;
    }

    public int getId_book() {
        return id_book;
    }

    public void setId_book(int id_book) {
        this.id_book = id_book;
    }

    public String getCode_book() {
        return code_book;
    }

    public void setCode_book(String code_book) {
        this.code_book = code_book;
    }

    public String getName_book() {
        return name_book;
    }

    public void setName_book(String name_book) {
        this.name_book = name_book;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id_book=" + id_book +
                ", code_book='" + code_book + '\'' +
                ", name_book='" + name_book + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
