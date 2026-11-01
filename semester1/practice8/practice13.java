package practice8;

public class practice13 {
    public static void main(String[] args) {
        System.out.println("---- Завдання 13 ----");
        UniversityStudent student = new UniversityStudent(
                "Іван Люленов", 2007, "ST123", "Комп'ютерні науки", 2000
        );
        Professor professor = new Professor(
                "Іван Петренко", 1981, "Доцент", 25
        );
        System.out.println(student);
        System.out.println("Вік студента: " + student.getAge(2026));
        System.out.println();
        System.out.println(professor);
        System.out.println("Вік професора: " + professor.getAge(2026));
    }
}
// Базовий клас
class Person {
    private String fullName;
    private int birthYear;
    public Person(String fullName, int birthYear) {
        this.fullName = fullName;
        this.birthYear = birthYear;
    }
    public int getAge(int currentYear) {
        return currentYear - birthYear;
    }
    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return "Ім'я: " + fullName +
                ", рік народження: " + birthYear;
    }
}
// Клас студента
class UniversityStudent extends Person {
    private String studentId;
    private String major;
    private int scholarship;
    public UniversityStudent(String fullName, int birthYear,
                             String studentId, String major, int scholarship) {

        super(fullName, birthYear);
        this.studentId = studentId;
        this.major = major;
        this.scholarship = scholarship;
    }
    @Override
    public String toString() {
        return "Студент: " + super.toString() +
                ", ID: " + studentId +
                ", спеціальність: " + major +
                ", стипендія: " + scholarship + " грн";
    }
}
// Клас професора
class Professor extends Person {
    private String academicTitle;
    private int publicationsCount;

    public Professor(String fullName, int birthYear,
                     String academicTitle, int publicationsCount) {

        super(fullName, birthYear);
        this.academicTitle = academicTitle;
        this.publicationsCount = publicationsCount;
    }
    @Override
    public String toString() {
        return "Професор: " + super.toString() +
                ", наукове звання: " + academicTitle +
                ", кількість публікацій: " + publicationsCount;
    }
}
