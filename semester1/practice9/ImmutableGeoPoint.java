package practice9;

public class ImmutableGeoPoint {
     private final double latitude;
    private final double longitude;
    public ImmutableGeoPoint(double latitude, double longitude) {
        this.latitude = Math.max(-90.0, Math.min(90.0, latitude));
        this.longitude = Math.max(-180.0, Math.min(180.0, longitude));
    }
    public double getLatitude() {
        return latitude;
    }
    public double getLongitude() {
        return longitude;
    }
    public ImmutableGeoPoint shift(double dLat, double dLon) {
        return new ImmutableGeoPoint(
                latitude + dLat,
                longitude + dLon
        );
    }
    @Override
    public String toString() {
        return String.format(
                "ImmutableGeoPoint[latitude=%.2f, longitude=%.2f]",
                latitude,
                longitude
        );
    }
    public static void main(String[] args) {
        ImmutableGeoPoint point = new ImmutableGeoPoint(50.45, 30.52);
        System.out.println("Початкова точка:");
        System.out.println(point);
        ImmutableGeoPoint shiftedPoint = point.shift(10.0, 20.0);
        System.out.println("Нова точка:");
        System.out.println(shiftedPoint);
        System.out.println("Початкова точка після зміщення:");
        System.out.println(point);
        ImmutableGeoPoint limitedPoint =
                new ImmutableGeoPoint(100.0, 200.0);
        System.out.println("Точка з обмеженими координатами:");
        System.out.println(limitedPoint);
    }
}
