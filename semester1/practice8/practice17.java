package practice8;

class StaffMember {
    String name;
    double baseSalary;
    public StaffMember(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }
    public double calculateMonthlyPay() {
        return baseSalary;
    }
    @Override
    public String toString() {
        return "Ім'я: " + name +
                ", базова зарплата: " + baseSalary +
                ", фінальна зарплата: " + calculateMonthlyPay();
    }
}
class Manager extends StaffMember {
    double teamBonus;
    public Manager(String name, double baseSalary, double teamBonus) {
        super(name, baseSalary);
        this.teamBonus = teamBonus;
    }
    @Override
    public double calculateMonthlyPay() {
        return super.calculateMonthlyPay() + teamBonus;
    }
    @Override
    public String toString() {
        return "Менеджер: " + name +
                ", базова зарплата: " + baseSalary +
                ", бонус команди: " + teamBonus +
                ", фінальна зарплата: " + calculateMonthlyPay();
    }
}
class SalesPerson extends StaffMember {
    double salesVolume;
    double commissionRate;
    public SalesPerson(String name, double baseSalary,
                       double salesVolume, double commissionRate) {
        super(name, baseSalary);
        this.salesVolume = salesVolume;
        this.commissionRate = commissionRate;
    }
    @Override
    public double calculateMonthlyPay() {
        return super.calculateMonthlyPay()
                + salesVolume * (commissionRate / 100.0);
    }
    @Override
    public String toString() {
        return "Продавець: " + name +
                ", базова зарплата: " + baseSalary +
                ", обсяг продажів: " + salesVolume +
                ", відсоток комісії: " + commissionRate + "%" +
                ", фінальна зарплата: " + calculateMonthlyPay();
    }
}
public class practice17 {
    public static void main(String[] args) {
        StaffMember staff = new StaffMember("Поліна", 20000);
        Manager manager = new Manager("Андрій", 30000, 5000);
        SalesPerson salesPerson = new SalesPerson(
                "Ренат",
                15000,
                100000,
                5
        );
        System.out.println(staff);
        System.out.println();
        System.out.println(manager);
        System.out.println();
        System.out.println(salesPerson);
    }
}
