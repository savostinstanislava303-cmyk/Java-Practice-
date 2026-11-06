package practice9;

public class BookItem {
    private final String title;
    private final String author;
    private final int pages;
    public BookItem(String title, String author, int pages) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Назва книги не може бути порожньою");
        }
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Автор не може бути порожнім");
        }
        if (pages <= 0) {
            throw new IllegalArgumentException("Кількість сторінок має бути додатною");
        }
        this.title = title;
        this.author = author;
        this.pages = pages;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public int getPages() {
        return pages;
    }
    @Override
    public String toString() {
        return "«" + title + "», " + author + ", " + pages + " стор.";
    }
}

