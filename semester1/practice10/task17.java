package practice10;

public class task17 {
    abstract static class AbstractBird {
        protected final String species;
        protected double weightKg;
        public AbstractBird(String species, double weightKg) {
            this.species = species;
            this.weightKg = weightKg;
        }
        public abstract String makeSound();
    }
    interface FlyableUnit {
        double getFlightSpeedKmh();
    }
    interface SwimmingUnit {
        double getDiveDepthMeters();
    }
    static class Falcon extends AbstractBird implements FlyableUnit {
        public Falcon(String species, double weightKg) {
            super(species, weightKg);
        }
        @Override
        public String makeSound() {
            return "Клекіт";
        }
        @Override
        public double getFlightSpeedKmh() {
            return 320.0;
        }
    }
    static class EmperorPenguin extends AbstractBird implements SwimmingUnit {
        public EmperorPenguin(String species, double weightKg) {
            super(species, weightKg);
        }
        @Override
        public String makeSound() {
            return "Крик пінгвіна";
        }
        @Override
        public double getDiveDepthMeters() {
            return 500.0;
        }
    }
    static class CargoPlane implements FlyableUnit {
        @Override
        public double getFlightSpeedKmh() {
            return 850.0;
        }
    }
    public static void main(String[] args) {
        AbstractBird[] birds = {
                new Falcon("Сокіл", 1.5),
                new EmperorPenguin("Імператорський пінгвін", 30.0)
        };
        System.out.println("=== МАСИВ ПТАХІВ ===");
        for (AbstractBird bird : birds) {
            System.out.println("Вид: " + bird.species);
            System.out.println("Вага: " + bird.weightKg + " кг");
            System.out.println("Звук: " + bird.makeSound());
            if (bird instanceof FlyableUnit) {
                FlyableUnit flyer = (FlyableUnit) bird;
                System.out.println("Швидкість польоту: " +
                        flyer.getFlightSpeedKmh() + " км/год");
            }
            if (bird instanceof SwimmingUnit) {
                SwimmingUnit swimmer = (SwimmingUnit) bird;
                System.out.println("Глибина занурення: " +
                        swimmer.getDiveDepthMeters() + " м");
            }
            System.out.println();
        }
        FlyableUnit[] flyingObjects = {
                new Falcon("Сокіл", 1.5),
                new CargoPlane()
        };
        System.out.println("=== ОБ'ЄКТИ, ЯКІ ВМІЮТЬ ЛІТАТИ ===");
        for (FlyableUnit flyer : flyingObjects) {
            System.out.println("Швидкість польоту: " +
                    flyer.getFlightSpeedKmh() + " км/год");
        }
    }
}

