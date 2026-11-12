package practice10;

interface EnergyConvertible {
    double SPEED_OF_LIGHT = 299_792_458.0;
    double JOULES_PER_KWH = 3_600_000.0;
    double getEnergyJoules();
    default double getEnergyKwh() {
        return getEnergyJoules() / JOULES_PER_KWH;
    }
}
class KineticBody implements EnergyConvertible {
    private double mass;
    private double velocity;
    public KineticBody(double mass, double velocity) {
        this.mass = mass;
        this.velocity = velocity;
    }
    @Override
    public double getEnergyJoules() {
        return 0.5 * mass * Math.pow(velocity, 2);
    }
}
class BatteryCell implements EnergyConvertible {
    private double capacityWh;
    public BatteryCell(double capacityWh) {
        this.capacityWh = capacityWh;
    }
    @Override
    public double getEnergyJoules() {
        return capacityWh * 3600;
    }
}
public class task10EnergyConvertible {
    public static void main(String[] args) {
        KineticBody body = new KineticBody(1000, 20);
        BatteryCell battery = new BatteryCell(500);
        EnergyConvertible[] devices = {body, battery};
        System.out.println("Фізична конвертація енергії");
        System.out.println("--------------------------------");
        for (EnergyConvertible device : devices) {
            System.out.printf("Енергія: %.2f Дж%n",
                    device.getEnergyJoules());
            System.out.printf("Енергія: %.6f кВт·год%n",
                    device.getEnergyKwh());
            System.out.println("--------------------------------");
        }
        System.out.println("Швидкість світла: "
                + EnergyConvertible.SPEED_OF_LIGHT + " м/с");
    }
}
