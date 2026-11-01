package practice8;

public class practice9 {
     public static void main(String[] args) {
         System.out.println("---- Завдання 9 ----");
         Employee employee = new Employee("Олег", 25000);

        Developer developer = new Developer(
                "Микита", 40000, "Java"
        );
        System.out.println(employee);
        System.out.println(developer);
    }
}
// Батьківський клас
class Employee {
    private String name;
    protected double salary;
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "Працівник: " + name +
                ", зарплата: " + salary + " грн";
    }
}
class Developer extends Employee {
    private String programmingLanguage;
    public Developer(String name, double salary, String programmingLanguage) {
        super(name, salary);
        this.programmingLanguage = programmingLanguage;
    }
    @Override
    public String toString() {
        return "Розробник: " + getName() +
                ", зарплата: " + salary + " грн" +
                ", мова програмування: " + programmingLanguage;
    }

}
