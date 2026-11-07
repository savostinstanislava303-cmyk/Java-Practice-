package practice9;

abstract class AbstractEmployee {
    private final int id;
    private final String name;
    protected double taxRate; // наприклад 0.195
    public AbstractEmployee(int id, String name, double taxRate) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Ім'я не може бути порожнім");
        }
        if (taxRate < 0.0 || taxRate >= 1.0) {
            throw new IllegalArgumentException("Ставка податку має бути в межах [0.0; 1.0)");
        }
        this.id = id;
        this.name = name;
        this.taxRate = taxRate;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getTaxRate() {
        return taxRate;
    }
    public abstract double calculateGrossSalary();
    public final double calculateNetSalary() {
        return calculateGrossSalary() * (1.0 - taxRate);
    }
    @Override
    public String toString() {
        return "#" + id + " " + name;
    }
}

class SalariedEmployee extends AbstractEmployee {
    private double monthlySalary;
    private double bonus;
    public SalariedEmployee(int id, String name, double taxRate, double monthlySalary, double bonus) {
        super(id, name, taxRate);
        if (monthlySalary < 0 || bonus < 0) {
            throw new IllegalArgumentException("Оклад і премія не можуть бути від'ємними");
        }
        this.monthlySalary = monthlySalary;
        this.bonus = bonus;
    }
    @Override
    public double calculateGrossSalary() {
        return monthlySalary + bonus;
    }
}

class HourlyContractor extends AbstractEmployee {
    private static final int NORMAL_HOURS = 160;
    private static final double OVERTIME_COEFFICIENT = 1.5;
    private int hoursWorked;
    private double hourlyRate;
    public HourlyContractor(int id, String name, double taxRate, int hoursWorked, double hourlyRate) {
        super(id, name, taxRate);
        if (hoursWorked < 0 || hourlyRate < 0) {
            throw new IllegalArgumentException("Години і ставка не можуть бути від'ємними");
        }
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }
    @Override
    public double calculateGrossSalary() {
        int regularHours = Math.min(hoursWorked, NORMAL_HOURS);
        int overtimeHours = Math.max(0, hoursWorked - NORMAL_HOURS);
        return regularHours * hourlyRate + overtimeHours * hourlyRate * OVERTIME_COEFFICIENT;
    }
}
public class EmployeeDemo {
    public static void main(String[] args) {
        double tax = 0.195;

        AbstractEmployee[] employees = {
            new SalariedEmployee(1, "Іван Петренко", tax, 30000, 5000),
            new HourlyContractor(2, "Олена Коваль", tax, 120, 200),
            new HourlyContractor(3, "Максим Шевченко", tax, 180, 200)
        };
        for (AbstractEmployee e : employees) {
            System.out.printf("%s -> брутто: %.2f, нетто: %.2f%n",
                    e, e.calculateGrossSalary(), e.calculateNetSalary());
        }
    }
}

