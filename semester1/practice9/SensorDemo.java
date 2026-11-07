package practice9;

abstract class AbstractSensor {
    private final String location;
    private final double minSafe;
    private final double maxSafe;
    public AbstractSensor(String location, double minSafe, double maxSafe) {
        if (location == null || location.isBlank()) {
            throw new IllegalArgumentException("Місце встановлення не може бути порожнім");
        }
        if (minSafe > maxSafe) {
            throw new IllegalArgumentException("minSafe не може бути більшим за maxSafe");
        }
        this.location = location;
        this.minSafe = minSafe;
        this.maxSafe = maxSafe;
    }
    public String getLocation() {
        return location;
    }
    public double getMinSafe() {
        return minSafe;
    }
    public double getMaxSafe() {
        return maxSafe;
    }
    public abstract double readValue();
    public abstract String getUnit();
    public final boolean isAlarmTriggered() {
        double value = readValue();
        return value < minSafe || value > maxSafe;
    }
    @Override
    public String toString() {
        return getClass().getSimpleName() + " [" + location + "]";
    }
}
class PressureSensor extends AbstractSensor {
    private double rawReadingBar;
    private final double calibrationFactor;
    public PressureSensor(String location, double minSafe, double maxSafe,
                          double rawReadingBar, double calibrationFactor) {
        super(location, minSafe, maxSafe);
        if (calibrationFactor <= 0) {
            throw new IllegalArgumentException("Калібрувальний множник має бути додатним");
        }
        this.rawReadingBar = rawReadingBar;
        this.calibrationFactor = calibrationFactor;
    }
    public void setRawReadingBar(double rawReadingBar) {
        this.rawReadingBar = rawReadingBar;
    }
    @Override
    public double readValue() {
        return rawReadingBar * calibrationFactor;
    }
    @Override
    public String getUnit() {
        return "бар";
    }
}
class RadiationSensor extends AbstractSensor {
    private double backgroundMicroSvPerHour;
    public RadiationSensor(String location, double minSafe, double maxSafe,
                           double backgroundMicroSvPerHour) {
        super(location, minSafe, maxSafe);
        if (backgroundMicroSvPerHour < 0) {
            throw new IllegalArgumentException("Радіаційний фон не може бути від'ємним");
        }
        this.backgroundMicroSvPerHour = backgroundMicroSvPerHour;
    }
    public void setBackground(double backgroundMicroSvPerHour) {
        if (backgroundMicroSvPerHour < 0) {
            throw new IllegalArgumentException("Радіаційний фон не може бути від'ємним");
        }
        this.backgroundMicroSvPerHour = backgroundMicroSvPerHour;
    }
    @Override
    public double readValue() {
        return backgroundMicroSvPerHour;
    }
    @Override
    public String getUnit() {
        return "мкЗв/год";
    }
}
public class SensorDemo {
    public static void main(String[] args) {
        AbstractSensor[] sensors = {
            new PressureSensor("Котельня", 1.0, 6.0, 4.8, 1.02),   // 4.896 бар — норма
            new PressureSensor("Магістраль", 1.0, 6.0, 6.2, 1.05), // 6.51 бар — тривога
            new PressureSensor("Насосна", 1.0, 6.0, 0.8, 1.0),     // 0.8 бар — тривога (низький)
            new RadiationSensor("Склад", 0.0, 0.3, 0.12),          // норма
            new RadiationSensor("Лабораторія", 0.0, 0.3, 0.85)     // тривога
        };
        for (AbstractSensor s : sensors) {
            System.out.printf("%s -> %.3f %s, безпечно: [%.2f; %.2f], тривога: %s%n",
                    s, s.readValue(), s.getUnit(), s.getMinSafe(), s.getMaxSafe(),
                    s.isAlarmTriggered() ? "ТАК" : "ні");
        }
    }
}

