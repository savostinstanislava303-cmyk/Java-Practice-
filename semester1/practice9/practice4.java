package practice9;

public class practice4 {
    public static void main(String[] args) {
        ClosedInterval interval1 = new ClosedInterval(2, 10);
        System.out.println("Перший інтервал:");
        System.out.println(interval1);
        ClosedInterval interval2 = new ClosedInterval(15, 5);
        System.out.println("Другий інтервал:");
        System.out.println(interval2);
        System.out.println("Чи перетинаються інтервали?");
        System.out.println(interval1.overlaps(interval2));
        interval1.resize(20, 8);
        System.out.println("Перший інтервал після resize():");
        System.out.println(interval1);
        System.out.println("Чи перетинаються інтервали тепер?");
        System.out.println(interval1.overlaps(interval2));
    }
}
