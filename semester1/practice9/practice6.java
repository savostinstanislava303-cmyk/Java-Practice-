package practice9;

public class practice6 {
 public static void main(String[] args) {
        HighSecuritySafe safe = new HighSecuritySafe(1234, 5000);
        System.out.println("Початковий стан сейфа:");
        System.out.println(safe);
        System.out.println("Перша неправильна спроба:");
        safe.takeCash(1111, 500);
        System.out.println("Друга неправильна спроба:");
        safe.takeCash(2222, 500);
        System.out.println("Третя неправильна спроба:");
        safe.takeCash(3333, 500);
        System.out.println("Спроба доступу після блокування:");
        safe.putCash(1234, 1000);
        System.out.println("Кінцевий стан сейфа:");
        System.out.println(safe);
    }
}
