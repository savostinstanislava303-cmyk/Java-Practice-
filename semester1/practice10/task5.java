package practice10;

abstract class ShippingTariff {
    public abstract double calculateCost(
            double weightKg,
            double distanceKm
    );
}
class RoadTruckTariff extends ShippingTariff {
    @Override
    public double calculateCost(double weightKg, double distanceKm) {
        return 15.0 * distanceKm + 2.5 * weightKg;
    }
}
class AirCargoTariff extends ShippingTariff {
    @Override
    public double calculateCost(double weightKg, double distanceKm) {
        return 45.0 * distanceKm + 18.0 * weightKg + 500.0;
    }
}
class RailFreightTariff extends ShippingTariff {
    @Override
    public double calculateCost(double weightKg, double distanceKm) {
        return 1200.0 + 4.0 * distanceKm + 0.8 * weightKg;
    }
}
public class task5 {
    public static void main(String[] args) {
        double weight = 100.0;
        double distance = 200.0;
        ShippingTariff[] tariffs = {
                new RoadTruckTariff(),
                new AirCargoTariff(),
                new RailFreightTariff()
        };
        for (ShippingTariff tariff : tariffs) {
            double cost = tariff.calculateCost(weight, distance);
            System.out.println(
                    "Тип доставки: "
                            + tariff.getClass().getSimpleName()
            );
            System.out.printf("Вартість доставки: %.2f грн%n", cost);
            System.out.println("--------------------------");
        }
    }
}
