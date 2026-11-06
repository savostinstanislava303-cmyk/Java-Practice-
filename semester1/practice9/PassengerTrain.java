package practice9;

public class PassengerTrain {
    private final String route;
    private final TrainCarriage[] carriages;
    private int carriageCount;
    public PassengerTrain(String route, int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Місткість має бути додатною");
        }
        this.route = route;
        this.carriages = new TrainCarriage[capacity];
        this.carriageCount = 0;
    }
    public String getRoute() {
        return route;
    }
    public int getCarriageCount() {
        return carriageCount;
    }
    public boolean attachCarriage(TrainCarriage c) {
        if (c == null || carriageCount >= carriages.length) {
            return false;
        }
        if (findCarriage(c.getCarriageNumber()) != null) {
            return false;
        }
        carriages[carriageCount++] = c;
        return true;
    }
    public int getTotalFreeSeats() {
        int total = 0;
        for (int i = 0; i < carriageCount; i++) {
            total += carriages[i].getFreeSeats();
        }
        return total;
    }
    public boolean bookTicketsInCarriage(int carriageNumber, int seatsToBook) {
        TrainCarriage carriage = findCarriage(carriageNumber);
        if (carriage == null) {
            return false;
        }
        return carriage.bookSeats(seatsToBook);
    }
    private TrainCarriage findCarriage(int carriageNumber) {
        for (int i = 0; i < carriageCount; i++) {
            if (carriages[i].getCarriageNumber() == carriageNumber) {
                return carriages[i];
            }
        }
        return null;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Потяг: ").append(route).append('\n');
        if (carriageCount == 0) {
            sb.append("(вагонів немає)");
            return sb.toString();
        }
        for (int i = 0; i < carriageCount; i++) {
            sb.append(carriages[i]);
            if (i < carriageCount - 1) {
                sb.append('\n');
            }
        }
        return sb.toString();
    }
}

