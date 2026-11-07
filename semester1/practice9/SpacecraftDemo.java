package practice9;

abstract class AbstractThruster {
    protected static final double G0 = 9.80665; // м/с^2
    private final String thrusterId;
    public AbstractThruster(String thrusterId) {
        if (thrusterId == null || thrusterId.isBlank()) {
            throw new IllegalArgumentException("ID двигуна не може бути порожнім");
        }
        this.thrusterId = thrusterId;
    }
    public String getThrusterId() {
        return thrusterId;
    }
    public abstract double getThrustKn();
    public abstract double getFuelBurnRate();
    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + thrusterId;
    }
}
class ChemicalThruster extends AbstractThruster {
    private final double thrustKn;
    private final double specificImpulseSec; // типово 250–450 с
    public ChemicalThruster(String thrusterId, double thrustKn, double specificImpulseSec) {
        super(thrusterId);
        if (thrustKn <= 0 || specificImpulseSec <= 0) {
            throw new IllegalArgumentException("Тяга та питомий імпульс мають бути додатними");
        }
        this.thrustKn = thrustKn;
        this.specificImpulseSec = specificImpulseSec;
    }
    @Override
    public double getThrustKn() {
        return thrustKn;
    }
    @Override
    public double getFuelBurnRate() {
        return thrustKn * 1000.0 / (specificImpulseSec * G0);
    }
}
class IonThruster extends AbstractThruster {
    private final double thrustKn;
    private final double specificImpulseSec; // типово 2000–5000 с
    public IonThruster(String thrusterId, double thrustKn, double specificImpulseSec) {
        super(thrusterId);
        if (thrustKn <= 0 || specificImpulseSec <= 0) {
            throw new IllegalArgumentException("Тяга та питомий імпульс мають бути додатними");
        }
        this.thrustKn = thrustKn;
        this.specificImpulseSec = specificImpulseSec;
    }
    @Override
    public double getThrustKn() {
        return thrustKn;
    }
    @Override
    public double getFuelBurnRate() {
        return thrustKn * 1000.0 / (specificImpulseSec * G0);
    }
}
class Spacecraft {
    private final String shipName;
    private final double dryMassTons;
    private final AbstractThruster[] thrusters;
    private int count; // кількість встановлених двигунів
    public Spacecraft(String shipName, double dryMassTons, int maxThrusters) {
        if (shipName == null || shipName.isBlank()) {
            throw new IllegalArgumentException("Назва корабля не може бути порожньою");
        }
        if (dryMassTons <= 0) {
            throw new IllegalArgumentException("Суха маса має бути додатною");
        }
        if (maxThrusters <= 0) {
            throw new IllegalArgumentException("Кількість слотів має бути додатною");
        }
        this.shipName = shipName;
        this.dryMassTons = dryMassTons;
        this.thrusters = new AbstractThruster[maxThrusters];
        this.count = 0;
    }
    public String getShipName() {
        return shipName;
    }
    public int getCount() {
        return count;
    }
    public void addThruster(AbstractThruster thruster) {
        if (thruster == null) {
            throw new IllegalArgumentException("Двигун не може бути null");
        }
        if (count >= thrusters.length) {
            throw new IllegalStateException("Усі слоти двигунів зайняті (" + thrusters.length + ")");
        }
        thrusters[count++] = thruster;
    }
    public double getTotalThrustKn() {
        double total = 0.0;
        for (int i = 0; i < count; i++) {
            total += thrusters[i].getThrustKn();
        }
        return total;
    }
    public double getTotalFuelBurnRate() {
        double total = 0.0;
        for (int i = 0; i < count; i++) {
            total += thrusters[i].getFuelBurnRate();
        }
        return total;
    }
    public double getInitialAcceleration() {
        return getTotalThrustKn() / dryMassTons;
    }
    public void printReport() {
        System.out.printf("Корабель «%s» (суха маса %.1f т, двигунів: %d з %d)%n",
                shipName, dryMassTons, count, thrusters.length);
        for (int i = 0; i < count; i++) {
            System.out.printf("  - %s: тяга %.4f кН, витрата %.6f кг/с%n",
                    thrusters[i], thrusters[i].getThrustKn(), thrusters[i].getFuelBurnRate());
        }
        System.out.printf("  Сумарна тяга: %.4f кН, сумарна витрата: %.6f кг/с%n",
                getTotalThrustKn(), getTotalFuelBurnRate());
        System.out.printf("  Початкове прискорення: %.6f м/с^2 (%.6f g)%n",
                getInitialAcceleration(), getInitialAcceleration() / AbstractThruster.G0);
    }
}
public class SpacecraftDemo {
    public static void main(String[] args) {
        Spacecraft launcher = new Spacecraft("Орел-1", 10.0, 4);
        launcher.addThruster(new ChemicalThruster("C1", 45.0, 320));
        launcher.addThruster(new ChemicalThruster("C2", 45.0, 320));
        launcher.addThruster(new IonThruster("I1", 0.0005, 3500));
        launcher.printReport();
        System.out.println();
        Spacecraft probe = new Spacecraft("Зонд-Ліра", 2.0, 4);
        for (int i = 1; i <= 4; i++) {
            probe.addThruster(new IonThruster("I" + i, 0.0002, 4000));
        }
        probe.printReport();
    }
}

