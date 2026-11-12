package practice10;


interface Flyable {
    void takeOff();
    double getMaxAltitude();
}
interface Swimmable {
    void dive(double depthMeters);
    double getMaxDepth();
}
interface GpsTrackable {
    String getCoordinates();
}
class AmphibiousRescueDrone implements Flyable, Swimmable, GpsTrackable {
    private double maxAltitude;
    private double maxDepth;
    private String coordinates;
    public AmphibiousRescueDrone(double maxAltitude, double maxDepth,
                                 String coordinates) {
        this.maxAltitude = maxAltitude;
        this.maxDepth = maxDepth;
        this.coordinates = coordinates;
    }
    @Override
    public void takeOff() {
        System.out.println("Дрон злітає!");
    }
    @Override
    public double getMaxAltitude() {
        return maxAltitude;
    }
    @Override
    public void dive(double depthMeters) {
        System.out.println("Дрон занурюється на глибину "
                + depthMeters + " метрів.");
    }
    @Override
    public double getMaxDepth() {
        return maxDepth;
    }
    @Override
    public String getCoordinates() {
        return coordinates;
    }
}
public class task11AmphibiousRescueDrone {
    public static void testFlight(Flyable f) {
        f.takeOff();
        System.out.println("Максимальна висота: "
                + f.getMaxAltitude() + " м");
    }
    public static void testDiving(Swimmable s) {
        s.dive(5);
        System.out.println("Максимальна глибина: "
                + s.getMaxDepth() + " м");
    }
    public static void logPosition(GpsTrackable g) {
        System.out.println("Координати дрона: "
                + g.getCoordinates());
    }
    public static void main(String[] args) {
        AmphibiousRescueDrone drone =
                new AmphibiousRescueDrone(500, 30, "50.4501, 30.5234");
        System.out.println("=== Тестування польоту ===");
        testFlight(drone);
        System.out.println("\n=== Тестування занурення ===");
        testDiving(drone);
        System.out.println("\n=== GPS-відстеження ===");
        logPosition(drone);
    }
}

