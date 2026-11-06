package practice9;


import java.util.Arrays;
public class practice2 {
    public static void main(String[] args) {
        double[] externalSamples = {10.5, 20.3, 30.7};
        LabMeasurement measurement =
                new LabMeasurement("Температурний експеримент", externalSamples);
        System.out.println("Назва експерименту: "
                + measurement.getExperimentName());
        System.out.println("Початкові результати: "
                + Arrays.toString(measurement.getSamples()));
        externalSamples[0] = 999.9;
        System.out.println("Після зміни зовнішнього масиву:");
        System.out.println("Зовнішній масив: "
                + Arrays.toString(externalSamples));
        System.out.println("Масив LabMeasurement: "
                + Arrays.toString(measurement.getSamples()));
        double[] getterSamples = measurement.getSamples();
        getterSamples[1] = 888.8;
        System.out.println("Після зміни масиву з геттера:");
        System.out.println("Масив з геттера: "
                + Arrays.toString(getterSamples));
        System.out.println("Масив LabMeasurement: "
                + Arrays.toString(measurement.getSamples()));
    }
}
