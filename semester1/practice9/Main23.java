package practice9;

public class Main23 {
    public static void main(String[] args) {
        PassengerTrain train = new PassengerTrain("Київ — Львів", 3);
        System.out.println(train.attachCarriage(new TrainCarriage(1, "Купе", 36)));
        System.out.println(train.attachCarriage(new TrainCarriage(2, "Плацкарт", 54)));
        System.out.println(train.attachCarriage(new TrainCarriage(3, "Інтерсіті", 60)));
        System.out.println(train.attachCarriage(new TrainCarriage(4, "Купе", 36)));
        System.out.println();
        System.out.println("Вільних місць на початку: " + train.getTotalFreeSeats());
        System.out.println("Бронювання 10 місць у вагоні 1: " + train.bookTicketsInCarriage(1, 10));
        System.out.println("Бронювання 30 місць у вагоні 1: " + train.bookTicketsInCarriage(1, 30));
        System.out.println("Бронювання 5 місць у вагоні 9: " + train.bookTicketsInCarriage(9, 5));
        System.out.println("Бронювання 54 місць у вагоні 2: " + train.bookTicketsInCarriage(2, 54));
        System.out.println("Бронювання 1 місця у вагоні 2: " + train.bookTicketsInCarriage(2, 1));
        System.out.println();
        System.out.println(train);
        System.out.println("Вільних місць: " + train.getTotalFreeSeats());
    }
}
