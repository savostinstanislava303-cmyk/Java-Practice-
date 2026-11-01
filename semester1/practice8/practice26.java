package practice8;

class BaseVehicle {
    private String brand;
    private int year;
    public BaseVehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }
    public String getBrand() {
        return brand;
    }
    public int getYear() {
        return year;
    }
    @Override
    public String toString() {
        return "Марка: " + brand +
                "\nРік випуску: " + year;
    }
}
class MotorCar extends BaseVehicle {
    private int horsePower;
    private int doorsCount;
    public MotorCar(String brand, int year,
                    int horsePower, int doorsCount) {
        super(brand, year);
        this.horsePower = horsePower;
        this.doorsCount = doorsCount;
    }
    public int getHorsePower() {
        return horsePower;
    }
    public int getDoorsCount() {
        return doorsCount;
    }
    @Override
    public String toString() {
        return super.toString() +
                "\nПотужність двигуна: " + horsePower + " к.с." +
                "\nКількість дверей: " + doorsCount;
    }
}
class ElectricCar extends MotorCar {
    private double batteryCapacityKWh;
    private int rangeKm;
    public ElectricCar(String brand, int year,
                       int horsePower, int doorsCount,
                       double batteryCapacityKWh, int rangeKm) {
        super(brand, year, horsePower, doorsCount);
        this.batteryCapacityKWh = batteryCapacityKWh;
        this.rangeKm = rangeKm;
    }
    @Override
    public String toString() {
        return super.toString() +
                "\nЄмність батареї: " + batteryCapacityKWh + " кВт·год" +
                "\nЗапас ходу: " + rangeKm + " км";
    }
}
public class practice26 {
    public static void main(String[] args) {
        ElectricCar electricCar = new ElectricCar(
                "Tesla",
                2024,
                450,
                4,
                75.0,
                500
        );
        System.out.println("===== ІНФОРМАЦІЯ ПРО АВТОМОБІЛЬ =====");
        System.out.println(electricCar);
    }
}