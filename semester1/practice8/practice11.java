package practice8;

public class practice11 {
    public static void main(String[] args) {
        System.out.println("---- Завдання 11 ----");
        PassengerCar car = new PassengerCar(
                "Toyota", 220, 50, 5
        );
        CargoTruck truck = new CargoTruck(
                "Volvo", 120, 300, 20
        );
        System.out.println(car);
        System.out.println();
        System.out.println(truck);
    }
}
//Батьківський клас
class Vehicle {
    protected String brand;
    protected int maxSpeed;
    protected double fuelTankCapacity;
    public Vehicle(String brand, int maxSpeed, double fuelTankCapacity) {
        this.brand = brand;
        this.maxSpeed = maxSpeed;
        this.fuelTankCapacity = fuelTankCapacity;
    }
    @Override
    public String toString() {
        return "Марка: " + brand +
                ", максимальна швидкість: " + maxSpeed + " км/год" +
                ", об'єм паливного бака: " + fuelTankCapacity + " л";
    }
}

// Клас легковогоавтомобіля
class PassengerCar extends Vehicle {
    private int passengerSeats;
    public PassengerCar(String brand, int maxSpeed,
                        double fuelTankCapacity, int passengerSeats) {

        super(brand, maxSpeed, fuelTankCapacity);
        this.passengerSeats = passengerSeats;
    }
    @Override
    public String toString() {
        return "Легковий автомобіль: " + super.toString() +
                ", кількість пасажирських місць: " + passengerSeats;
    }
}
// Клас вантажівки
class CargoTruck extends Vehicle {
    private double maxLoadTons;

    public CargoTruck(String brand, int maxSpeed,
                      double fuelTankCapacity, double maxLoadTons) {

        super(brand, maxSpeed, fuelTankCapacity);
        this.maxLoadTons = maxLoadTons;
    }
    public double calculateFuelConsumption() {
        return 20 + maxLoadTons * 2;
    }
    @Override
    public String toString() {
        return "Вантажівка: " + super.toString() +
                ", вантажопідйомність: " + maxLoadTons + " тонн" +
                ", витрата пального: " +
                calculateFuelConsumption() + " л/100 км";
    }
}


