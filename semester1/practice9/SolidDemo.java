package practice9;

abstract class Solid3D {
    private final String materialName;
    private final double densityKgPerM3; // густина ρ
    public Solid3D(String materialName, double densityKgPerM3) {
        if (materialName == null || materialName.isBlank()) {
            throw new IllegalArgumentException("Назва матеріалу не може бути порожньою");
        }
        if (densityKgPerM3 <= 0) {
            throw new IllegalArgumentException("Густина має бути додатною");
        }
        this.materialName = materialName;
        this.densityKgPerM3 = densityKgPerM3;
    }
    public String getMaterialName() {
        return materialName;
    }
    public double getDensityKgPerM3() {
        return densityKgPerM3;
    }
    public abstract double getVolume();
    public abstract double getSurfaceArea();
    public final double getMassKg() {
        return densityKgPerM3 * getVolume();
    }
}
class Sphere3D extends Solid3D {
    private final double radius;
    public Sphere3D(String materialName, double densityKgPerM3, double radius) {
        super(materialName, densityKgPerM3);
        if (radius <= 0) {
            throw new IllegalArgumentException("Радіус має бути додатним");
        }
        this.radius = radius;
    }
    @Override
    public double getVolume() {
        return 4.0 / 3.0 * Math.PI * Math.pow(radius, 3);
    }
    @Override
    public double getSurfaceArea() {
        return 4.0 * Math.PI * radius * radius;
    }
    @Override
    public String toString() {
        return "Куля (" + getMaterialName() + ", r = " + radius + " м)";
    }
}
class Cylinder3D extends Solid3D {
    private final double radius;
    private final double height;
    public Cylinder3D(String materialName, double densityKgPerM3, double radius, double height) {
        super(materialName, densityKgPerM3);
        if (radius <= 0 || height <= 0) {
            throw new IllegalArgumentException("Радіус і висота мають бути додатними");
        }
        this.radius = radius;
        this.height = height;
    }
    @Override
    public double getVolume() {
        return Math.PI * radius * radius * height;
    }
    @Override
    public double getSurfaceArea() {
        return 2.0 * Math.PI * radius * (radius + height);
    }
    @Override
    public String toString() {
        return "Циліндр (" + getMaterialName() + ", r = " + radius + " м, h = " + height + " м)";
    }
}
public class SolidDemo {
    public static void main(String[] args) {
        final double STEEL_DENSITY = 7850.0;   // кг/м^3
        final double GOLD_DENSITY = 19320.0;   // кг/м^3
        Solid3D[] solids = {
            new Sphere3D("сталь", STEEL_DENSITY, 0.5),
            new Sphere3D("золото", GOLD_DENSITY, 0.1),
            new Cylinder3D("сталь", STEEL_DENSITY, 0.2, 1.0),
            new Cylinder3D("золото", GOLD_DENSITY, 0.05, 0.3)
        };
        for (Solid3D s : solids) {
            System.out.printf("%s%n  V = %.6f м^3, S = %.6f м^2, маса = %.3f кг%n",
                    s, s.getVolume(), s.getSurfaceArea(), s.getMassKg());
        }
    }
}

