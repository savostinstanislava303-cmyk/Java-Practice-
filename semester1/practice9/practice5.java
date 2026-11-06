package practice9;

public class practice5 {
 public static void main(String[] args) {
        RgbColor color1 = new RgbColor(255, 100, 50);
        RgbColor color2 = new RgbColor(0, 150, 200);
        System.out.println("Перший колір:");
        System.out.println(color1);
        System.out.println("Другий колір:");
        System.out.println(color2);
        RgbColor inverted = color1.invert();
        System.out.println("Інвертований перший колір:");
        System.out.println(inverted);
        RgbColor mixed = color1.mixWith(color2);
        System.out.println("Змішаний колір:");
        System.out.println(mixed);
        RgbColor checkedColor = new RgbColor(300, -20, 128);
        System.out.println("Колір після перевірки каналів:");
        System.out.println(checkedColor);
    }
}
