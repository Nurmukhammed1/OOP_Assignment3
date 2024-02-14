public class Book {

    public String bookName;
    public String author;
    public int yearOfPublication;

    public Book() {};

    public Book(String bookName , String author , int yearOfPublication) {
        this.bookName = bookName;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYearOfPublication(String yearOfPublication) {
        this.author = yearOfPublication;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

}
