package practice9;

abstract class AbstractPowerPlant {
    private final String stationName;
    protected double baseCapacityMw;
    public AbstractPowerPlant(String stationName, double baseCapacityMw) {
        if (stationName == null || stationName.isBlank()) {
            throw new IllegalArgumentException("Назва станції не може бути порожньою");
        }
        if (baseCapacityMw < 0) {
            throw new IllegalArgumentException("Базова потужність не може бути від'ємною");
        }
        this.stationName = stationName;
        this.baseCapacityMw = baseCapacityMw;
    }
    public String getStationName() {
        return stationName;
    }
    public double getBaseCapacityMw() {
        return baseCapacityMw;
    }
    public abstract double generateMegawatts();
    public double calculateDailyProfit(double tariffPerMwh) {
        return generateMegawatts() * 24 * tariffPerMwh;
    }
    @Override
    public String toString() {
        return stationName + " (базова потужність: " + baseCapacityMw + " МВт)";
    }
}
class SolarPowerPlant extends AbstractPowerPlant {
    private double sunIntensityFactor; // 0.0 .. 1.0
    public SolarPowerPlant(String stationName, double baseCapacityMw, double sunIntensityFactor) {
        super(stationName, baseCapacityMw);
        setSunIntensityFactor(sunIntensityFactor);
    }
    public double getSunIntensityFactor() {
        return sunIntensityFactor;
    }
    public void setSunIntensityFactor(double sunIntensityFactor) {
        if (sunIntensityFactor < 0.0 || sunIntensityFactor > 1.0) {
            throw new IllegalArgumentException("Інтенсивність сонця має бути в межах [0.0; 1.0]");
        }
        this.sunIntensityFactor = sunIntensityFactor;
    }
    @Override
    public double generateMegawatts() {
        return baseCapacityMw * sunIntensityFactor;
    }
}

class WindPowerPlant extends AbstractPowerPlant {
    private static final double MIN_WIND_MS = 3.0;
    private static final double MAX_WIND_MS = 25.0;
    private double windSpeedMs;
    public WindPowerPlant(String stationName, double baseCapacityMw, double windSpeedMs) {
        super(stationName, baseCapacityMw);
        setWindSpeedMs(windSpeedMs);
    }
    public double getWindSpeedMs() {
        return windSpeedMs;
    }
    public void setWindSpeedMs(double windSpeedMs) {
        if (windSpeedMs < 0) {
            throw new IllegalArgumentException("Швидкість вітру не може бути від'ємною");
        }
        this.windSpeedMs = windSpeedMs;
    }
    @Override
    public double generateMegawatts() {
        // Занадто слабкий або занадто сильний вітер — турбіна стоїть
        if (windSpeedMs < MIN_WIND_MS || windSpeedMs > MAX_WIND_MS) {
            return 0.0;
        }
        return baseCapacityMw;
    }
}

public class Main26 {
    public static void main(String[] args) {
        double tariff = 50.0; // за МВт·год
        AbstractPowerPlant[] plants = {
            new SolarPowerPlant("Сонячна станція «Південь»", 100, 0.75),
            new SolarPowerPlant("Сонячна станція «Хмарна»", 100, 0.0),
            new WindPowerPlant("Вітрова станція «Узбережжя»", 80, 12),
            new WindPowerPlant("Вітрова станція «Штиль»", 80, 2),
            new WindPowerPlant("Вітрова станція «Шторм»", 80, 30)
        };
        for (AbstractPowerPlant p : plants) {
            System.out.printf("%s -> %.2f МВт, прибуток за добу: %.2f%n",
                    p, p.generateMegawatts(), p.calculateDailyProfit(tariff));
        }
    }
}

