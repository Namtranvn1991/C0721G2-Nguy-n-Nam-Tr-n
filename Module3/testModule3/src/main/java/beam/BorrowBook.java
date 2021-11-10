package beam;

public class BorrowBook {
    private int id_borrow_book;
    private String code_borrow_book;
    private Book book;
    private Student student;
    private boolean status;
    private String date_borrow;
    private String date_give_back;

    public BorrowBook() {
    }

    public BorrowBook(String code_borrow_book, Book book, Student student, String date_borrow, String date_give_back) {
        this.code_borrow_book = code_borrow_book;
        this.book = book;
        this.student = student;
        this.date_borrow = date_borrow;
        this.date_give_back = date_give_back;
    }

    public BorrowBook(int id_borrow_book, String code_borrow_book, Book book, Student student, boolean status, String date_borrow, String date_give_back) {
        this.id_borrow_book = id_borrow_book;
        this.code_borrow_book = code_borrow_book;
        this.book = book;
        this.student = student;
        this.status = status;
        this.date_borrow = date_borrow;
        this.date_give_back = date_give_back;
    }

    public int getId_borrow_book() {
        return id_borrow_book;
    }

    public void setId_borrow_book(int id_borrow_book) {
        this.id_borrow_book = id_borrow_book;
    }

    public String getCode_borrow_book() {
        return code_borrow_book;
    }

    public void setCode_borrow_book(String code_borrow_book) {
        this.code_borrow_book = code_borrow_book;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDate_borrow() {
        return date_borrow;
    }

    public void setDate_borrow(String date_borrow) {
        this.date_borrow = date_borrow;
    }

    public String getDate_give_back() {
        return date_give_back;
    }

    public void setDate_give_back(String date_give_back) {
        this.date_give_back = date_give_back;
    }

    @Override
    public String toString() {
        return "BorrowBook{" +
                "id_borrow_book=" + id_borrow_book +
                ", code_borrow_book='" + code_borrow_book + '\'' +
                ", book=" + book +
                ", student=" + student +
                ", status=" + status +
                ", date_borrow='" + date_borrow + '\'' +
                ", date_give_back='" + date_give_back + '\'' +
                '}';
    }
}
