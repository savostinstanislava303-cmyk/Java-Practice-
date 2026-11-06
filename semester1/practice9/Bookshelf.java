package practice9;

public class Bookshelf {
    private final String genre;
    private final BookItem[] books;
    private int bookCount;
    public Bookshelf(String genre, int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Місткість має бути додатною");
        }
        this.genre = genre;
        this.books = new BookItem[capacity];
        this.bookCount = 0;
    }
    public String getGenre() {
        return genre;
    }
    public int getBookCount() {
        return bookCount;
    }
    public boolean putBook(BookItem book) {
        if (book == null || bookCount >= books.length) {
            return false;
        }
        books[bookCount++] = book;
        return true;
    }
    public BookItem findLongestBook() {
        if (bookCount == 0) {
            return null;
        }
        BookItem longest = books[0];
        for (int i = 1; i < bookCount; i++) {
            if (books[i].getPages() > longest.getPages()) {
                longest = books[i];
            }
        }
        return longest;
    }
    public int getTotalPagesOnShelf() {
        int total = 0;
        for (int i = 0; i < bookCount; i++) {
            total += books[i].getPages();
        }
        return total;
    }
}

