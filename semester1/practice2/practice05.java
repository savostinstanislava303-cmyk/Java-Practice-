package practice2;

public class practice05 {
    public static void main() {
        double a = 3.0;
        double b = 4.0;
        double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        System.out.println("Катети: " + a + " та " + b + ". Гіпотенуза: " + c);
        System.out.println();
        double radius = 5.0;
        double length = 2 * Math.PI * radius;
        double area = Math.PI * Math.pow(radius, 2);
        System.out.println("Радіус: " + radius);
        System.out.println("Довжина кола: " + length);
        System.out.println("Площа круга: " + area);
        System.out.println();
        double dayTemp = 18.5;
        double nightTemp = -3.2;
        double difference = Math.abs(dayTemp - nightTemp);
        double maxTemp = Math.max(dayTemp, nightTemp);
        double minTemp = Math.min(dayTemp, nightTemp);
        System.out.println("Перепад температури: " + difference);
        System.out.println("Максимальна температура: " + maxTemp);
        System.out.println("Мінімальна температура: " + minTemp);
        System.out.println();
        double num = 5.67;
        System.out.println("Math.round: " + Math.round(num));
        System.out.println("Math.ceil: " + Math.ceil(num));
        System.out.println("Math.floor: " + Math.floor(num));
        double negNum = -5.67;
        System.out.println("Для -5.67:");
        System.out.println("Math.round: " + Math.round(negNum));
        System.out.println("Math.ceil: " + Math.ceil(negNum));
        System.out.println("Math.floor: " + Math.floor(negNum));
        System.out.println();
        double a1 = 1.0;
        double b1 = -7.0;
        double c1 = 10.0;
        double d1 = Math.pow(b1, 2) - 4 * a1 * c1;
        double x1 = (-b1 + Math.sqrt(d1)) / (2 * a1);
        double x2 = (-b1 - Math.sqrt(d1)) / (2 * a1);
        System.out.println("Дискримінант D = " + d1);
        System.out.println("Корінь x1 = " + x1);
        System.out.println("Корінь x2 = " + x2);
        System.out.println();
        int dice = (int) (Math.random() * 6) + 1;
        System.out.println("Випало на кубику: " + dice);
        System.out.println();
        int min = -10;
        int max = 35;
        int randomTemp = (int) (Math.random() * (max - min + 1)) + min;
        System.out.println("Погода на завтра: " + randomTemp + "°C");
        System.out.println();
        double P = 10000.0;
        double r = 12.0;
        int t = 3;
        double S = P * Math.pow(1 + r / 100, t);
        double profit = S - P;
        System.out.println("+------------------------------------+");
        System.out.println("|     ДЕПОЗИТНИЙ КАЛЬКУЛЯТОР        |");
        System.out.println("+------------------------------------+");
        System.out.println("Початкова сума: " + P + " грн");
        System.out.println("Термін: " + t + " роки під " + r + "% річних");
        System.out.printf("Підсумкова сума: %.2f грн%n", S);
        System.out.printf("Чистий прибуток: %.2f грн%n", profit);
        System.out.println("+------------------------------------+");

    }
}
