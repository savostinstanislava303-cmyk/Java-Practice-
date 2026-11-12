package practice10;

interface Measurable {
    double getMeasure();
}
class BankVault implements Measurable {
    private double goldAmount;
    public BankVault(double goldAmount) {
        this.goldAmount = goldAmount;
    }
    @Override
    public double getMeasure() {
        return goldAmount;
    }
}
class HighwayRoute implements Measurable {
    private double length;
    public HighwayRoute(double length) {
        this.length = length;
    }
    @Override
    public double getMeasure() {
        return length;
    }
}
class CpuCore implements Measurable {
    private double frequency;
    public CpuCore(double frequency) {
        this.frequency = frequency;
    }
    @Override
    public double getMeasure() {
        return frequency;
    }
}
public class Task9Measurable {
    public static double computeAverage(Measurable[] items) {
        double sum = 0;
        for (Measurable item : items) {
            sum += item.getMeasure();
        }
        return sum / items.length;
    }
    public static void main(String[] args) {
        BankVault vault = new BankVault(500);
        HighwayRoute route = new HighwayRoute(250);
        CpuCore core = new CpuCore(3.5);
        Measurable[] items = {vault, route, core};
        double average = computeAverage(items);
        System.out.println("Запас золота: " + vault.getMeasure() + " кг");
        System.out.println("Довжина траси: " + route.getMeasure() + " км");
        System.out.println("Частота процесора: " + core.getMeasure() + " ГГц");
        System.out.println("--------------------------------");
        System.out.println("Середнє значення: " + average);
    }
}

