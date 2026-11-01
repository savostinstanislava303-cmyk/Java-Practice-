package practice8;

class Gamer {
    private String nickname;
    private int hoursPlayed;

    public Gamer(String nickname, int hoursPlayed) {
        this.nickname = nickname;
        this.hoursPlayed = hoursPlayed;
    }
    @Override
    public String toString() {
        return "Нікнейм: " + nickname +
                ", годин зіграно: " + hoursPlayed;
    }
}
class ProEsportsPlayer extends Gamer {
    private String teamName;
    private double prizeMoneyUSD;
    private int tournamentsWon;
    public ProEsportsPlayer(String nickname, int hoursPlayed,
                            String teamName, double prizeMoneyUSD,
                            int tournamentsWon) {
        super(nickname, hoursPlayed);
        this.teamName = teamName;
        this.prizeMoneyUSD = prizeMoneyUSD;
        this.tournamentsWon = tournamentsWon;
    }
    public double getAveragePrizePerWin() {
        if (tournamentsWon == 0) {
            return 0;
        }

        return prizeMoneyUSD / tournamentsWon;
    }
    @Override
    public String toString() {
        return super.toString() +
                ", команда: " + teamName +
                ", призові: " + prizeMoneyUSD + " USD" +
                ", перемог у турнірах: " + tournamentsWon +
                ", середній приз за перемогу: " +
                getAveragePrizePerWin() + " USD";
    }
}
    public class practice16 {
    public static void main(String[] args) {
        Gamer gamer = new Gamer("Player123", 500);
        ProEsportsPlayer proPlayer = new ProEsportsPlayer(
                "NikitaPro",
                2500,
                "Team Spirit",
                150000,
                10
        );

        System.out.println(gamer);
        System.out.println();

        System.out.println(proPlayer);
    }
}

