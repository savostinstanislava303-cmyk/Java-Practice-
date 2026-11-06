package practice9;

import java.util.Locale;
public class Main22 {
    public static void main(String[] args) {
        UniversityCourse course = new UniversityCourse("Програмування Java", 4);
        course.addModule(new CourseModule("Основи ООП", 16, 16, 30.0));
        course.addModule(new CourseModule("Колекції та масиви", 20, 22, 40.0));
        course.addModule(new CourseModule("Тестування", 14, 12, 30.0));
        printInfo(course);
        course.addModule(new CourseModule("Додатковий модуль", 10, 10, 5.0));
        System.out.println();
        printInfo(course);
    }
    private static void printInfo(UniversityCourse course) {
        System.out.println("Курс: " + course.getCourseTitle());
        System.out.println("Модулів: " + course.getModuleCount());
        System.out.println("Годин: " + course.getTotalHours());
        System.out.println(String.format(Locale.US, "Кредитів ЄКТС: %.2f", course.getTotalEctsCredits()));
        System.out.println("Сума балів: " + course.getTotalMaxScore());
        System.out.println("Сума дорівнює 100: " + course.isScoreSumValid());
    }
}

