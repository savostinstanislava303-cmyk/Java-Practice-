package practice8;


class Ticket {
    private String eventName;
    private double basePrice;
    public Ticket(String eventName, double basePrice) {
        this.eventName = eventName;
        this.basePrice = basePrice;
    }
    public double getFinalPrice() {
        return basePrice;
    }
    @Override
    public String toString() {
        return "Подія: " + eventName +
                ", базова ціна: " + basePrice;
    }
}
class StudentTicket extends Ticket {
    private String studentCardNumber;

    public StudentTicket(String eventName, double basePrice,
                         String studentCardNumber) {
        super(eventName, basePrice);
        this.studentCardNumber = studentCardNumber;
    }
    @Override
    public double getFinalPrice() {
        return super.getFinalPrice() * 0.5;
    }
    @Override
    public String toString() {
        return super.toString() +
                ", студентський квиток: " + studentCardNumber +
                ", фінальна ціна: " + getFinalPrice();
    }
}
class VipTicket extends Ticket {
    private boolean includesBackstage;
    private double loungeFee;
    public VipTicket(String eventName, double basePrice,
                     boolean includesBackstage, double loungeFee) {
        super(eventName, basePrice);
        this.includesBackstage = includesBackstage;
        this.loungeFee = loungeFee;
    }
    @Override
    public double getFinalPrice() {
        return super.getFinalPrice() + loungeFee;
    }
    @Override
    public String toString() {
        return super.toString() +
                ", доступ за лаштунки: " + includesBackstage +
                ", плата за лаунж: " + loungeFee +
                ", фінальна ціна: " + getFinalPrice();
    }
}
public class practice19 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket("Концерт", 1000);
        StudentTicket student = new StudentTicket(
                "Концерт",
                1000,
                "ST12345"
        );
        VipTicket vip = new VipTicket(
                "Концерт",
                1000,
                true,
                500
        );

        System.out.println(ticket);
        System.out.println();
        System.out.println(student);
        System.out.println();
        System.out.println(vip);
    }

}
