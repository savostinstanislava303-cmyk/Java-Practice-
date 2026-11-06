package practice9;

class Engine {
    private final String fuelType;
    private final int volumeCc;
    private int rpm;
    private boolean started;
    public Engine(String fuelType, int volumeCc) {
        this.fuelType = fuelType;
        this.volumeCc = volumeCc;
        this.rpm = 0;
        this.started = false;
    }
    public void start() {
        started = true;
        rpm = 800;
    }
    public void stop() {
        started = false;
        rpm = 0;
    }
    public void setRpm(int rpm) {
        if (started && rpm >= 0) {
            this.rpm = rpm;
        }
    }
    public boolean isStarted() {
        return started;
    }
    @Override
    public String toString() {
        return "Двигун: паливо = " + fuelType +
                ", об'єм = " + volumeCc + " см³" +
                ", оберти = " + rpm + " об/хв" +
                ", заведений = " + started;
    }
}
public class Automobile {
    private final String model;
    private double speed;
    private final Engine engine;
    public Automobile(String model, String fuelType, int volumeCc) {
        this.model = model;
        this.speed = 0;
        this.engine = new Engine(fuelType, volumeCc);
    }
    public void accelerate(double deltaSpeed) {
        if (!engine.isStarted()) {
            System.out.println("Неможливо розігнати автомобіль! Двигун не заведений.");
            return;
        }
        if (deltaSpeed <= 0) {
            System.out.println("Швидкість розгону повинна бути більшою за 0.");
            return;
        }
        speed += deltaSpeed;
        engine.setRpm(800 + (int) (speed * 50));
    }
    public void startEngine() {
        engine.start();
    }
    public void stopEngine() {
        engine.stop();
    }
    @Override
    public String toString() {
        return "Автомобіль: " + model +
                "\nШвидкість: " + speed + " км/год" +
                "\n" + engine;
    }
    public static void main(String[] args) {
        Automobile car = new Automobile("BMW", "Бензин", 2000);
        System.out.println("Початковий стан:");
        System.out.println(car);
        System.out.println("\nСпроба розгону:");
        car.accelerate(30);
        System.out.println("\nЗапускаємо двигун:");
        car.startEngine();
        car.accelerate(30);
        System.out.println("\nПісля розгону:");
        System.out.println(car);
        car.accelerate(20);
        System.out.println("\nПісля другого розгону:");
        System.out.println(car);
        System.out.println("\nЗупиняємо двигун:");
        car.stopEngine();
        System.out.println(car);
    }
}

