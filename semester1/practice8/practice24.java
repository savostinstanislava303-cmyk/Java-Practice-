package practice8;

class Coffee {
    private String roastType;
    private int volumeMl;
    private double basePrice;
    public Coffee(String roastType, int volumeMl, double basePrice) {
        this.roastType = roastType;
        this.volumeMl = volumeMl;
        this.basePrice = basePrice;
    }
    public int calculateCalories() {
        return volumeMl * 2;
    }
    public double calculatePrice() {
        return basePrice;
    }
    public String getRoastType() {
        return roastType;
    }
    public int getVolumeMl() {
        return volumeMl;
    }
    @Override
    public String toString() {
        return "Кава: " + roastType +
                "\nОб'єм: " + volumeMl + " мл" +
                "\nЦіна: " + calculatePrice() + " грн";
    }
}
class LatteWithAddons extends Coffee {
    private String milkType;
    private int syrupPumps;
    public LatteWithAddons(String roastType, int volumeMl,
                           double basePrice, String milkType,
                           int syrupPumps) {
        super(roastType, volumeMl, basePrice);
        this.milkType = milkType;
        this.syrupPumps = syrupPumps;
    }
    @Override
    public int calculateCalories() {
        int calories = super.calculateCalories();
        calories += 50; // Калорійність молока
        if (milkType.equalsIgnoreCase("рослинне")) {
            calories += 30;
        }
        calories += syrupPumps * 20;
        return calories;
    }
    @Override
    public double calculatePrice() {
        double price = super.calculatePrice();
        if (milkType.equalsIgnoreCase("рослинне")) {
            price += 20;
        }
        price += syrupPumps * 12;
        return price;
    }
    @Override
    public String toString() {
        return "========== ЧЕК КАВ'ЯРНІ ==========" +
                "\nНапій: Лате" +
                "\nТип обсмаження: " + getRoastType() +
                "\nОб'єм: " + getVolumeMl() + " мл" +
                "\nМолоко: " + milkType +
                "\nКількість сиропу: " + syrupPumps +
                "\nКалорійність: " + calculateCalories() + " ккал" +
                "\nДо сплати: " + calculatePrice() + " грн" +
                "\n=================================";
    }
}
public class practice24 {
    public static void main(String[] args) {
        LatteWithAddons latte = new LatteWithAddons(
                "Середнє",
                350,
                80,
                "рослинне",
                2
        );
        System.out.println(latte);
    }
}