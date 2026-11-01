package practice8;

class Appliance {
    private String model;
    private double powerWatts;
    public Appliance(String model, double powerWatts) {
        this.model = model;
        this.powerWatts = powerWatts;
    }
    public double getDailyConsumptionKWh(int hours) {
        return (powerWatts * hours) / 1000.0;
    }
    @Override
    public String toString() {
        return "Модель приладу: " + model +
                ", потужність: " + powerWatts + " Вт";
    }
}
class EcoHeater extends Appliance {
    private boolean ecoModeActive;
    public EcoHeater(String model, double powerWatts, boolean ecoModeActive) {
        super(model, powerWatts);
        this.ecoModeActive = ecoModeActive;
    }
    @Override
    public double getDailyConsumptionKWh(int hours) {
        double consumption = super.getDailyConsumptionKWh(hours);
        if (ecoModeActive) {
            consumption = consumption * 0.75;
        }
        return consumption;
    }
    @Override
    public String toString() {
        return super.toString() +
                ", режим економії: " + (ecoModeActive ? "увімкнений" : "вимкнений");
    }
}
public class practice22 {
    public static void main(String[] args) {
        Appliance appliance = new Appliance("Samsung", 2000);
        EcoHeater heaterEco = new EcoHeater("Xiaomi Heater", 2000, true);
        EcoHeater heaterNormal = new EcoHeater("Xiaomi Heater", 2000, false);
        System.out.println(appliance);
        System.out.println("Споживання за 5 годин: " +
                appliance.getDailyConsumptionKWh(5) + " кВт·год");
        System.out.println();
        System.out.println(heaterEco);
        System.out.println("Споживання за 5 годин: " +
                heaterEco.getDailyConsumptionKWh(5) + " кВт·год");
        System.out.println();
        System.out.println(heaterNormal);
        System.out.println("Споживання за 5 годин: " +
                heaterNormal.getDailyConsumptionKWh(5) + " кВт·год");
    }
}