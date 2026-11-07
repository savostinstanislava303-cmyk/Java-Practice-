package practice9;

abstract class AbstractPcPart {
    private final String model;
    private final double priceUah;
    public AbstractPcPart(String model, double priceUah) {
        if (model == null || model.isBlank()) {
            throw new IllegalArgumentException("Модель не може бути порожньою");
        }
        if (priceUah < 0) {
            throw new IllegalArgumentException("Ціна не може бути від'ємною");
        }
        this.model = model;
        this.priceUah = priceUah;
    }
    public String getModel() {
        return model;
    }
    public double getPriceUah() {
        return priceUah;
    }
    public abstract int getPowerConsumptionWatts();
    @Override
    public String toString() {
        return model;
    }
}

class ProcessorPart extends AbstractPcPart {
    private final int cores;
    private final int watts;
    public ProcessorPart(String model, double priceUah, int cores, int watts) {
        super(model, priceUah);
        if (cores <= 0 || watts < 0) {
            throw new IllegalArgumentException("Некоректні параметри процесора");
        }
        this.cores = cores;
        this.watts = watts;
    }
    public int getCores() {
        return cores;
    }
    @Override
    public int getPowerConsumptionWatts() {
        return watts;
    }
}
class VideoCardPart extends AbstractPcPart {
    private final int vramGb;
    private final int watts;
    public VideoCardPart(String model, double priceUah, int vramGb, int watts) {
        super(model, priceUah);
        if (vramGb <= 0 || watts < 0) {
            throw new IllegalArgumentException("Некоректні параметри відеокарти");
        }
        this.vramGb = vramGb;
        this.watts = watts;
    }
    public int getVramGb() {
        return vramGb;
    }
    @Override
    public int getPowerConsumptionWatts() {
        return watts;
    }
}
class DesktopPC {
    private static final int HEADROOM_PERCENT = 20; // запас 20%
    private final int psuMaxWatts;
    private final AbstractPcPart[] parts;
    public DesktopPC(int psuMaxWatts, AbstractPcPart[] parts) {
        if (psuMaxWatts <= 0) {
            throw new IllegalArgumentException("Потужність БЖ має бути додатною");
        }
        if (parts == null || parts.length == 0) {
            throw new IllegalArgumentException("ПК має містити хоча б одну деталь");
        }
        for (AbstractPcPart p : parts) {
            if (p == null) {
                throw new IllegalArgumentException("Деталь не може бути null");
            }
        }
        this.psuMaxWatts = psuMaxWatts;
        this.parts = parts.clone(); // захисна копія
    }
    public int getTotalPowerConsumptionWatts() {
        int total = 0;
        for (AbstractPcPart p : parts) {
            total += p.getPowerConsumptionWatts();
        }
        return total;
    }
    public double getTotalPriceUah() {
        double total = 0;
        for (AbstractPcPart p : parts) {
            total += p.getPriceUah();
        }
        return total;
    }
    public int getRequiredPsuWatts() {
        long total = getTotalPowerConsumptionWatts();
        return (int) ((total * (100 + HEADROOM_PERCENT) + 99) / 100);
    }
    public boolean isSystemStable() {
        long total = getTotalPowerConsumptionWatts();
        return total * (100 + HEADROOM_PERCENT) <= (long) psuMaxWatts * 100;
    }
    public void printReport() {
        System.out.println("ПК (БЖ " + psuMaxWatts + " Вт):");
        for (AbstractPcPart p : parts) {
            System.out.printf("  - %s: %d Вт, %.2f грн%n",
                    p, p.getPowerConsumptionWatts(), p.getPriceUah());
        }
        System.out.printf("  Споживання: %d Вт, потрібно БЖ з запасом 20%%: %d Вт, ціна: %.2f грн%n",
                getTotalPowerConsumptionWatts(), getRequiredPsuWatts(), getTotalPriceUah());
        System.out.println("  Система стабільна: " + (isSystemStable() ? "ТАК" : "НІ"));
    }
}
public class PcBuildDemo {
    public static void main(String[] args) {
        AbstractPcPart cpu = new ProcessorPart("Ryzen 7 7800X3D", 15000, 8, 120);
        AbstractPcPart gpu = new VideoCardPart("RTX 4070 Super", 30000, 12, 220);
        new DesktopPC(450, new AbstractPcPart[] {cpu, gpu}).printReport();
        System.out.println();
        new DesktopPC(400, new AbstractPcPart[] {cpu, gpu}).printReport();
        System.out.println();
        AbstractPcPart cpu2 = new ProcessorPart("Core i9-14900K", 20000, 24, 125);
        AbstractPcPart gpu2 = new VideoCardPart("RTX 4090", 80000, 24, 450);
        new DesktopPC(750, new AbstractPcPart[] {cpu2, gpu2}).printReport();
    }
}

