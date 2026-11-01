package practice8;

class Parcel {
    private String trackingCode;
    private double weightKg;
    public Parcel(String trackingCode, double weightKg) {
        this.trackingCode = trackingCode;
        this.weightKg = weightKg;
    }
    public double calculateShippingCost() {
        return 50.0 + weightKg * 12.0;
    }
    @Override
    public String toString() {
        return "Трек-номер: " + trackingCode +
                ", вага посилки: " + weightKg + " кг" +
                ", вартість доставки: " + calculateShippingCost() + " грн";
    }
}
class FragileParcel extends Parcel {
    private boolean requiresWoodenBox;
    private double insuranceValue;
    public FragileParcel(String trackingCode, double weightKg,
                         boolean requiresWoodenBox, double insuranceValue) {
        super(trackingCode, weightKg);
        this.requiresWoodenBox = requiresWoodenBox;
        this.insuranceValue = insuranceValue;
    }
    @Override
    public double calculateShippingCost() {
        double cost = super.calculateShippingCost();
        cost += insuranceValue * 0.015;
        if (requiresWoodenBox) {
            cost += 120.0;
        }
        return cost;
    }
    @Override
    public String toString() {
        return super.toString() +
                ", страхова вартість: " + insuranceValue + " грн" +
                ", дерев'яна обрешітка: " + requiresWoodenBox +
                ", підсумкова вартість: " + calculateShippingCost() + " грн";
    }
}
public class practice21 {
    public static void main(String[] args) {
        Parcel parcel = new Parcel("UA123456789", 5.0);
        FragileParcel fragileParcel = new FragileParcel(
                "UA987654321",
                5.0,
                true,
                10000.0
        );
        System.out.println(parcel);
        System.out.println();
        System.out.println("Накладна крихкої посилки:");
        System.out.println(fragileParcel);
    }
}