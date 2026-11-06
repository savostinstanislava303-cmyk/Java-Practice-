package practice9;


class Battery {
    private int capacityMah;
    private int chargePercent;
    public Battery(int capacityMah, int chargePercent) {
        this.capacityMah = capacityMah;
        if (chargePercent < 0) {
            this.chargePercent = 0;
        } else if (chargePercent > 100) {
            this.chargePercent = 100;
        } else {
            this.chargePercent = chargePercent;
        }
    }
    public void drain(int percent) {
        chargePercent -= percent;
        if (chargePercent < 0) {
            chargePercent = 0;
        }
    }
    public void charge(int percent) {
        chargePercent += percent;
        if (chargePercent > 100) {
            chargePercent = 100;
        }
    }
    public int getChargePercent() {
        return chargePercent;
    }
    @Override
    public String toString() {
        return "Акумулятор: " + capacityMah + " мАг, заряд = "
                + chargePercent + "%";
    }
}
class Display {
    private double diagonalInches;
    private int brightnessPercent;
    public Display(double diagonalInches, int brightnessPercent) {
        this.diagonalInches = diagonalInches;

        if (brightnessPercent < 10) {
            this.brightnessPercent = 10;
        } else if (brightnessPercent > 100) {
            this.brightnessPercent = 100;
        } else {
            this.brightnessPercent = brightnessPercent;
        }
    }
    public int getBrightnessPercent() {
        return brightnessPercent;
    }
    public void setBrightnessPercent(int brightnessPercent) {
        if (brightnessPercent < 10) {
            this.brightnessPercent = 10;
        } else if (brightnessPercent > 100) {
            this.brightnessPercent = 100;
        } else {
            this.brightnessPercent = brightnessPercent;
        }
    }
    @Override
    public String toString() {
        return "Дисплей: " + diagonalInches + " дюймів, яскравість = "
                + brightnessPercent + "%";
    }
}
public class SmartDevice {
    private final Battery battery;
    private final Display display;
    private boolean poweredOn;
    public SmartDevice(int capacityMah, int chargePercent,
                       double diagonalInches, int brightnessPercent) {
        this.battery = new Battery(capacityMah, chargePercent);
        this.display = new Display(diagonalInches, brightnessPercent);
        this.poweredOn = chargePercent > 0;
    }
    public void watchVideo(int minutes) {
        if (!poweredOn) {
            System.out.println("Пристрій вимкнений!");
            return;
        }
        if (minutes <= 0) {
            System.out.println("Некоректна тривалість відео!");
            return;
        }
        int drainPercent;
        if (display.getBrightnessPercent() > 70) {
            drainPercent = 2;
        } else {
            drainPercent = 1;
        }
        int intervals = minutes / 10;
        int totalDrain = intervals * drainPercent;
        battery.drain(totalDrain);
        System.out.println("Переглянуто відео: " + minutes + " хв.");
        System.out.println("Витрачено заряду: " + totalDrain + "%");
        if (battery.getChargePercent() == 0) {
            poweredOn = false;
            System.out.println("Заряд закінчився! Пристрій вимкнувся.");
        }
    }
    @Override
    public String toString() {
        return "Смартфон:\n" +
                battery + "\n" +
                display + "\n" +
                "Стан пристрою: " +
                (poweredOn ? "Увімкнений" : "Вимкнений");
    }
    public static void main(String[] args) {
        SmartDevice phone = new SmartDevice(
                5000,
                50,
                6.5,
                80
        );
        System.out.println("Початковий стан:");
        System.out.println(phone);
        System.out.println("\nПерегляд відео:");
        phone.watchVideo(30);
        System.out.println("\nСтан після перегляду:");
        System.out.println(phone);
        System.out.println("\nЗменшуємо яскравість:");
        phone.watchVideo(20);
        System.out.println("\nКінцевий стан:");
        System.out.println(phone);
    }
}

