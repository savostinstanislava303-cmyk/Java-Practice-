package practice8;

class Medicine {
    private String name;
    private double price;
    private boolean isExpired;
    public Medicine(String name, double price, boolean isExpired) {
        this.name = name;
        this.price = price;
        this.isExpired = isExpired;
    }
    public boolean isExpired() {
        return isExpired;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    @Override
    public String toString() {
        return "Назва препарату: " + name +
                "\nЦіна: " + price + " грн" +
                "\nПрострочений: " + (isExpired ? "Так" : "Ні");
    }
}
class PrescriptionMedicine extends Medicine {
    private String doctorLicense;
    public PrescriptionMedicine(String name, double price,
                                boolean isExpired, String doctorLicense) {
        super(name, price, isExpired);
        this.doctorLicense = doctorLicense;
    }
    public boolean canSell(boolean hasPrescription) {
        return !isExpired() && hasPrescription;
    }
    @Override
    public String toString() {
        return super.toString() +
                "\nЛіцензія лікаря: " + doctorLicense;
    }
}
class ControlledSubstance extends PrescriptionMedicine {
    private int patientAge;
    public ControlledSubstance(String name, double price,
                               boolean isExpired, String doctorLicense,
                               int patientAge) {
        super(name, price, isExpired, doctorLicense);
        this.patientAge = patientAge;
    }
    @Override
    public boolean canSell(boolean hasPrescription) {
        return super.canSell(hasPrescription) && patientAge >= 18;
    }
    @Override
    public String toString() {
        return super.toString() +
                "\nВік пацієнта: " + patientAge;
    }
}
public class practice32 {
    public static void main(String[] args) {
        ControlledSubstance medicine = new ControlledSubstance(
                "Синупрет",
                250.0,
                false,
                "DOC-12345",
                20
        );
        System.out.println("===== ІНФОРМАЦІЯ ПРО ПРЕПАРАТ =====");
        System.out.println(medicine);
        System.out.println("\n===== ПЕРЕВІРКА ПРОДАЖУ =====");
        System.out.println("1. Є рецепт, препарат не прострочений, вік 20: "
                + medicine.canSell(true));
        System.out.println("2. Немає рецепта: "
                + medicine.canSell(false));
        ControlledSubstance expiredMedicine = new ControlledSubstance(
                "Препарат Б", 300.0, true, "DOC-54321", 25
        );
        System.out.println("3. Препарат прострочений: "
                + expiredMedicine.canSell(true));
        ControlledSubstance youngPatientMedicine = new ControlledSubstance(
                "Препарат В", 180.0, false, "DOC-67890", 16
        );
        System.out.println("4. Вік пацієнта менше 18: "
                + youngPatientMedicine.canSell(true));
    }
}