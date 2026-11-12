package practice10;

abstract class IndustrialAsset {
    private final String name;
    protected final double initialCost;
    protected final int usefulLifeYears;
    public IndustrialAsset(String name, double initialCost, int usefulLifeYears) {
        this.name = name;
        this.initialCost = initialCost;
        this.usefulLifeYears = usefulLifeYears;
    }
    public String getName() {
        return name;
    }
    public abstract double getBookValueAfterYears(int years);
}
class LinearDepreciationAsset extends IndustrialAsset {

    public LinearDepreciationAsset(String name, double initialCost, int usefulLifeYears) {
        super(name, initialCost, usefulLifeYears);
    }
    @Override
    public double getBookValueAfterYears(int years) {
        return initialCost * (1.0 - (double) years / usefulLifeYears);
    }
}

class DecliningBalanceAsset extends IndustrialAsset {

    private final double rate;
    public DecliningBalanceAsset(String name, double initialCost,
                                 int usefulLifeYears, double rate) {
        super(name, initialCost, usefulLifeYears);
        this.rate = rate;
    }
    @Override
    public double getBookValueAfterYears(int years) {
        return initialCost * Math.pow(1.0 - rate, years);
    }
}
public class Task8IndustrialAsset {
    public static void main(String[] args) {
        IndustrialAsset[] assets = {
                new LinearDepreciationAsset("Верстат", 100000, 10),
                new LinearDepreciationAsset("Конвеєр", 200000, 20),
                new DecliningBalanceAsset("Прес", 150000, 10, 0.15),
                new DecliningBalanceAsset("Робот", 300000, 15, 0.10)
        };
        int years = 3;
        double totalValue = 0;
        System.out.println("Залишкова вартість обладнання через " + years + " роки:");
        System.out.println("------------------------------------------");
        for (IndustrialAsset asset : assets) {
            double value = asset.getBookValueAfterYears(years);
            System.out.printf("%s: %.2f грн%n", asset.getName(), value);
            totalValue += value;
        }
        System.out.println("------------------------------------------");
        System.out.printf("Сумарна залишкова вартість цеху: %.2f грн%n", totalValue);
    }
}

