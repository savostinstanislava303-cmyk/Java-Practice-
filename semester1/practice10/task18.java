package practice10;

public class task18 {
    abstract static class AbstractSmartAppliance {
        private final String room;
        private final String model;
        protected boolean poweredOn;
        public AbstractSmartAppliance(String room, String model, boolean poweredOn) {
            this.room = room;
            this.model = model;
            this.poweredOn = poweredOn;
        }
        public abstract double getCurrentWatts();
        public String getRoom() {
            return room;
        }
        public String getModel() {
            return model;
        }
    }
    interface Dimmable {
        void setBrightness(int percent);
    }
    interface HeatingCapable {
        void setTargetTemperature(double celsius);
    }
    static class SmartLedChandelier extends AbstractSmartAppliance
            implements Dimmable {
        private int brightness;
        private final double maxWatts = 60.0;
        public SmartLedChandelier(String room, String model, boolean poweredOn) {
            super(room, model, poweredOn);
            brightness = 100;
        }
        @Override
        public void setBrightness(int percent) {
            if (percent < 0 || percent > 100) {
                throw new IllegalArgumentException(
                        "Яскравість має бути від 0 до 100");
            }
            brightness = percent;
        }
        @Override
        public double getCurrentWatts() {
            if (!poweredOn) {
                return 0;
            }
            return maxWatts * brightness / 100.0;
        }
    }
    static class SmartUnderfloorHeating extends AbstractSmartAppliance
            implements HeatingCapable {
        private double targetTemperature;
        private final double powerWatts = 1500.0;
        public SmartUnderfloorHeating(String room, String model, boolean poweredOn) {
            super(room, model, poweredOn);
            targetTemperature = 22.0;
        }
        @Override
        public void setTargetTemperature(double celsius) {
            if (celsius < 5 || celsius > 35) {
                throw new IllegalArgumentException(
                        "Температура має бути від 5 до 35 градусів");
            }
            targetTemperature = celsius;
        }
        @Override
        public double getCurrentWatts() {
            if (!poweredOn) {
                return 0;
            }
            return powerWatts;
        }
    }
    public static void main(String[] args) {
        SmartLedChandelier chandelier =
                new SmartLedChandelier("Вітальня", "LED-100", true);
        SmartUnderfloorHeating heating =
                new SmartUnderfloorHeating("Ванна", "Heat-200", true);
        chandelier.setBrightness(50);
        heating.setTargetTemperature(24.0);
        AbstractSmartAppliance[] appliances = {
                chandelier,
                heating
        };
        double totalWatts = 0;
        System.out.println("=== СПОЖИВАННЯ ЕНЕРГІЇ РОЗУМНОГО БУДИНКУ ===");
        for (AbstractSmartAppliance appliance : appliances) {
            double watts = appliance.getCurrentWatts();
            System.out.println("Кімната: " + appliance.getRoom());
            System.out.println("Модель: " + appliance.getModel());
            System.out.println("Споживання: " + watts + " Вт");
            totalWatts += watts;
            System.out.println();
        }
        System.out.println("Загальне споживання: " + totalWatts + " Вт");
        System.out.println("Загальне споживання: " +
                (totalWatts / 1000.0) + " кВт");
    }
}

