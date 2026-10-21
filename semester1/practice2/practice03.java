package practice2;

public class practice03 {
    public static void main() {
        int number = 19;
        int remainder = number % 2;
        System.out.println("Число " + number +" " + "при діленні на 2 дає остачу: " + remainder);
        System.out.println();
        int totalSeconds = 385;
        int minutes = totalSeconds /60;
        int seconds = totalSeconds %60;
        System.out.println("385 секунд = " + minutes + " хв" +" " + seconds + " сек");
        System.out.println();
        int n = 47;
        int tens = n/10;
        int units = n%10;
        int sum = tens + units;
        System.out.println("Число:" + n + ". " + "Десятки:" + tens + ", " + "Одиниці:" + units + ". " + "Сума цифр:" + sum);
        System.out.println();
        System.out.println("Очікуваний результат:");
        int score = 100;
        score += 50;
        System.out.println("Після додавання: " + score);
        score -=20;
        System.out.println("Післят віднімання: " + score);
        score *=2;
        System.out.println("Після множення: " + score);
        score /=4;
        System.out.println("Після ділення: " + score);
        System.out.println();
        int counter = 5;
        System.out.println(counter++);
        System.out.println(counter);
        System.out.println();
        int counter2 = 5;
        System.out.println(++counter2);
        //різниця в тому, що conter++ спочатку використовує число, а наступне збільшує на 1, а ++conter збільшує на один відразу
        System.out.println();
        int grade1 = 4;
        int grade2 = 5;
        int grade3 = 4;
        double average = (grade1 + grade2 + grade3)/3.0;
        System.out.println("Середній бал: " + average);
        System.out.println();
        double celsius = 25.0;
        double fahrenheit = celsius *1.8 + 32;
        double kelvin = celsius + 273.15;
        System.out.println("Очікуваний результат: ");
        System.out.println(celsius + "°C" + " = "  + fahrenheit + "°F");
        System.out.println(celsius + "°C" + " = " + kelvin + " K" );

    }
}
