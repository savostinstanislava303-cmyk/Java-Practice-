package practice9;

class TemperatureSensor {
    private double currentTemp;
    public TemperatureSensor(double currentTemp) {
        this.currentTemp = currentTemp;
    }
    public double getCurrentTemp() {
        return currentTemp;
    }
    public void setCurrentTemp(double currentTemp) {
        this.currentTemp = currentTemp;
    }
}
class HeatingUnit {
    private boolean heatingOn;
    private double powerKw;
    public HeatingUnit(double powerKw) {
        this.powerKw = powerKw;
        this.heatingOn = false;
    }
    public void turnOn() {
        heatingOn = true;
    }
    public void turnOff() {
        heatingOn = false;
    }
    public boolean isHeatingOn() {
        return heatingOn;
    }
    public double getPowerKw() {
        return powerKw;
    }
    @Override
    public String toString() {
        return "Обігрівач: " + (heatingOn ? "увімкнений" : "вимкнений")
                + ", потужність: " + powerKw + " кВт";
    }
}
public class ClimateController {
    private TemperatureSensor sensor;
    private HeatingUnit heatingUnit;
    private double targetTemp;
    public ClimateController(TemperatureSensor sensor,
                             HeatingUnit heatingUnit,
                             double targetTemp) {
        this.sensor = sensor;
        this.heatingUnit = heatingUnit;
        this.targetTemp = targetTemp;
    }
    public void regulate() {
        double currentTemp = sensor.getCurrentTemp();
        if (currentTemp < targetTemp - 0.5) {
            heatingUnit.turnOn();
        } else if (currentTemp >= targetTemp) {
            heatingUnit.turnOff();
        }
    }
    @Override
    public String toString() {
        return "===== ЗВІТ КЛІМАТ-КОНТРОЛЮ =====\n"
                + "Поточна температура: " + sensor.getCurrentTemp() + " °C\n"
                + "Бажана температура: " + targetTemp + " °C\n"
                + heatingUnit.toString();
    }
    public static void main(String[] args) {
        TemperatureSensor sensor = new TemperatureSensor(18.0);
        HeatingUnit heater = new HeatingUnit(2.0);
        ClimateController controller =
                new ClimateController(sensor, heater, 22.0);
        controller.regulate();
        System.out.println(controller);
        System.out.println("\nТемпература змінилася...\n");
        sensor.setCurrentTemp(22.0);
        controller.regulate();
        System.out.println(controller);
    }
}

