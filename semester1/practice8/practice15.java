package practice8;

public class practice15 {
     public static void main(String[] args) {
        System.out.println("---- Завдання 15 ----");
        PrintedBook printedBook = new PrintedBook(
                "Кобзар", "Тарас Шевченко", 1840,
                320, "Тверда"
        );

        AudioBook audioBook = new AudioBook(
                "Маленький принц", "Антуан де Сент-Екзюпері", 1943,
                145, "Олександр"
        );
        System.out.println(printedBook);
        System.out.println();

        System.out.println(audioBook);
    }
}
// Базовий клас
class Publication {
    private String title;
    private String author;
    private int releaseYear;
    public Publication(String title, String author, int releaseYear) {
        this.title = title;
        this.author = author;
        this.releaseYear = releaseYear;
    }
    @Override
    public String toString() {
        return "Назва: " + title +
                ", автор: " + author +
                ", рік видання: " + releaseYear;
    }
}
// Клас друкованої книги
class PrintedBook extends Publication {
    private int pageCount;
    private String coverType;
    public PrintedBook(String title, String author, int releaseYear,
                       int pageCount, String coverType) {
        super(title, author, releaseYear);
        this.pageCount = pageCount;
        this.coverType = coverType;
    }
    @Override
    public String toString() {
        return "Друкована книга: " + super.toString() +
                ", кількість сторінок: " + pageCount +
                ", тип обкладинки: " + coverType;
    }
}
// Клас аудіокниги
class AudioBook extends Publication {
    private int durationMinutes;
    private String narrator;
    public AudioBook(String title, String author, int releaseYear,
                     int durationMinutes, String narrator) {

        super(title, author, releaseYear);
        this.durationMinutes = durationMinutes;
        this.narrator = narrator;
    }
    public String formatDuration() {
        int hours = durationMinutes / 60;
        int minutes = durationMinutes % 60;

        return hours + " год " + minutes + " хв";
    }
    @Override
    public String toString() {
        return "Аудіокнига: " + super.toString() +
                ", тривалість: " + formatDuration() +
                ", диктор: " + narrator;
    }
}
