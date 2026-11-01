package practice8;


class SensorNodeTask5 {
    private String sensorId;
    protected double calibrationOffset;
    private double rawValue;
    // Конструктор
    public SensorNodeTask5(String sensorId, double calibrationOffset, double rawValue) {
        this.sensorId = sensorId;
        this.calibrationOffset = calibrationOffset;
        this.rawValue = rawValue;
    }
    // Геттер
    public String getSensorId() {
        return sensorId;
    }
    public double getCalibratedValue() {
        return rawValue + calibrationOffset;
    }
    @Override
    public String toString() {
        return String.format(
                java.util.Locale.US,
                "SensorNode{id='%s', rawValue=%.2f, calibratedValue=%.2f}",
                sensorId, rawValue, getCalibratedValue()
        );
    }
}
class SensorMainTask5 {
    public static void main(String[] args) {
        SensorNodeTask5 sensor1 = new SensorNodeTask5("SN-101", 2.5, 25.0);
        SensorNodeTask5 sensor2 = new SensorNodeTask5("SN-205", -1.5, 30.0);
        System.out.println(sensor1);
        System.out.println(sensor2);
        System.out.println("ID першого датчика: " + sensor1.getSensorId());
        System.out.println("Відкаліброване значення: " +
                sensor1.getCalibratedValue());
    }
}