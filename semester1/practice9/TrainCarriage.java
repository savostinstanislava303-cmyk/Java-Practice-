package practice9;

public class TrainCarriage {
    private final int carriageNumber;
    private final String type;
    private final int totalSeats;
    private int occupiedSeats;
    public TrainCarriage(int carriageNumber, String type, int totalSeats) {
        if (carriageNumber <= 0) {
            throw new IllegalArgumentException("Номер вагона має бути додатним");
        }
        if (!isValidType(type)) {
            throw new IllegalArgumentException("Невідомий тип вагона: " + type);
        }
        if (totalSeats <= 0) {
            throw new IllegalArgumentException("Кількість місць має бути додатною");
        }
        this.carriageNumber = carriageNumber;
        this.type = type;
        this.totalSeats = totalSeats;
        this.occupiedSeats = 0;
    }
    private static boolean isValidType(String type) {
        return "Купе".equals(type) || "Плацкарт".equals(type) || "Інтерсіті".equals(type);
    }
    public int getCarriageNumber() {
        return carriageNumber;
    }
    public String getType() {
        return type;
    }
    public int getTotalSeats() {
        return totalSeats;
    }
    public int getOccupiedSeats() {
        return occupiedSeats;
    }
    public int getFreeSeats() {
        return totalSeats - occupiedSeats;
    }
    public boolean bookSeats(int seats) {
        if (seats <= 0 || seats > getFreeSeats()) {
            return false;
        }
        occupiedSeats += seats;
        return true;
    }
    @Override
    public String toString() {
        return "Вагон " + carriageNumber + " (" + type + "): "
                + occupiedSeats + "/" + totalSeats + " зайнято, вільно " + getFreeSeats();
    }
}

