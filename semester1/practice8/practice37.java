package practice8;

class CinemaHall {
    private String hallName;
    protected boolean[][] seats;
    protected double baseTicketPrice;
    public CinemaHall(String hallName, int rows, int cols, double baseTicketPrice) {
        this.hallName = hallName;
        this.baseTicketPrice = baseTicketPrice;
        seats = new boolean[rows][cols];
    }
    public void bookSeat(int row, int col) {
        if (row < 0 || row >= seats.length ||
                col < 0 || col >= seats[row].length) {
            System.out.println("Такого місця не існує!");
            return;
        }
        if (seats[row][col]) {
            System.out.println("Це місце вже зайняте!");
        } else {
            seats[row][col] = true;
            System.out.println("Місце успішно заброньовано!");
        }
    }
    public int getOccupiedCount() {
        int count = 0;
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }
    public double calculateRevenue() {
        return getOccupiedCount() * baseTicketPrice;
    }
    @Override
    public String toString() {
        String result = "Зал: " + hallName + "\n";
        result += "Схема місць:\n";

        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j]) {
                    result += "[X] ";
                } else {
                    result += "[O] ";
                }
            }
            result += "\n";
        }
        result += "Зайнято місць: " + getOccupiedCount();
        return result;
    }
}

class VipCinemaHall extends CinemaHall {
    private double complimentaryBarCost;
    public VipCinemaHall(String hallName, int rows, int cols,
                         double baseTicketPrice, double complimentaryBarCost) {
        super(hallName, rows, cols, baseTicketPrice);
        this.complimentaryBarCost = complimentaryBarCost;
    }

    @Override
    public double calculateRevenue() {
        double revenue = 0;
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j]) {
                    revenue += baseTicketPrice;
                    // Для останнього ряду додаємо вартість напоїв
                    if (i == seats.length - 1) {
                        revenue += complimentaryBarCost;
                    }
                }
            }
        }

        return revenue;
    }
}
public class practice37 {
    public static void main(String[] args) {
        VipCinemaHall hall = new VipCinemaHall(
                "VIP-зал",
                4,
                5,
                150,
                50
        );

        hall.bookSeat(0, 1);
        hall.bookSeat(1, 2);
        hall.bookSeat(3, 0);
        hall.bookSeat(3, 1);
        hall.bookSeat(3, 2);

        System.out.println();
        System.out.println(hall);
        System.out.println("Дохід кінотеатру: " +
                hall.calculateRevenue() + " грн");
    }
}
