package practice8;

import java.util.Arrays;
class WeatherDayTask6 {
    private String date;
    private double[] hourlyTemps;
    // Конструктор
    public WeatherDayTask6(String date, double[] hourlyTemps) {
        this.date = date;
        // копія масиву
        this.hourlyTemps = new double[hourlyTemps.length];
        for (int i = 0; i < hourlyTemps.length; i++) {
            this.hourlyTemps[i] = hourlyTemps[i];
        }
    }
    public double getMinTemp() {
        double min = hourlyTemps[0];

        for (int i = 1; i < hourlyTemps.length; i++) {
            if (hourlyTemps[i] < min) {
                min = hourlyTemps[i];
            }
        }
        return min;
    }
    public double getMaxTemp() {
        double max = hourlyTemps[0];

        for (int i = 1; i < hourlyTemps.length; i++) {
            if (hourlyTemps[i] > max) {
                max = hourlyTemps[i];
            }
        }
        return max;
    }
    public double getAverageTemp() {
        double sum = 0;
        for (int i = 0; i < hourlyTemps.length; i++) {
            sum += hourlyTemps[i];
        }
        return sum / hourlyTemps.length;
    }
    @Override
    public String toString() {
        return String.format(
                java.util.Locale.US,
                "WeatherDay{date='%s', temperatures=%s, average=%.2f}",
                date, Arrays.toString(hourlyTemps), getAverageTemp()
        );
    }
}
class WeatherMainTask6 {
    public static void main(String[] args) {
        double[] temperatures = {
                12.5, 14.0, 16.5, 18.0, 20.5,
                19.0, 17.5, 15.0
        };
        WeatherDayTask6 day = new WeatherDayTask6(
                "01.11.2026", temperatures
        );
        temperatures[0] = 100.0;
        System.out.println(day);
        System.out.println("Мінімальна температура: " + day.getMinTemp());
        System.out.println("Максимальна температура: " + day.getMaxTemp());
        System.out.println("Середня температура: " + day.getAverageTemp());
    }
}