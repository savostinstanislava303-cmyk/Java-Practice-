package practice6;
import java.util.Scanner;
import java.util.Arrays;
public class practice61 {
  public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        while (true) {
            System.out.print("\nПрактична №6. Введіть номер завдання 1-40 (0 — вихід): ");
            if (!sc.hasNextInt()) { System.out.println("Введіть число."); sc.next(); continue; }
            int n = sc.nextInt();
            if (n == 0) break;
            switch (n) {
                case 1 -> task1();
                case 2 -> task2();
                case 3 -> task3();
                case 4 -> task4();
                case 5 -> task5();
                case 6 -> task6();
                case 7 -> task7();
                case 8 -> task8();
                case 9 -> task9();
                case 10 -> task10();
                case 11 -> task11();
                case 12 -> task12();
                case 13 -> task13();
                case 14 -> task14();
                case 15 -> task15();
                case 16 -> task16();
                case 17 -> task17();
                case 18 -> task18();
                case 19 -> task19();
                case 20 -> task20();
                case 21 -> task21();
                case 22 -> task22();
                 case 23 -> task23();
                 case 24 -> task24();
                 case 25 -> task25();
                 case 26 -> task26();
                 case 27 -> task27();
                  case 28 -> task28();
                 case 29 -> task29();
                 case 30 -> task30();
                 case 31 -> task31();
                 case 32 -> task32();
                 case 33 -> task33();
                 case 34 -> task34();
                 case 35 -> task35();
                 case 36 -> task36();
                 case 37 -> task37();
                 case 38 -> task38();
                 case 39 -> task39();
                 case 40 -> task40();
                default -> System.out.println("Номер має бути від 1 до 40.");
            }
        }
        sc.close();
    }
       static class Student {
      String name;
      int age;
      double gpa;
      Student(String n, int a, double d) {
          name=n; age=a; gpa=d;
      }
  }
    static void task1() {
      Student s1 =new Student("Денис",19, 4.75);
        System.out.println(s1.name+", "+s1.age+", "+ s1.gpa);
  }
   static class Car {
      String brand;
      String model;
      int year;
      int speed;

   }
   static void task2() {
       Car car1 = new Car();
        car1.brand = "Toyota";
        car1.model = "Camry";
        car1.year = 2021;
        car1.speed = 180;
       Car car2 = new Car();
       car2.brand = "BMW";
       car2.model = "M5";
       car2.year = 2023;
       car2.speed = 250;
        System.out.println(
        car1.brand + " " +
        car1.model + " (" +
        car1.year + "), " +
          car1.speed + " км/год"
      );
         System.out.println(
        car2.brand + " " +
        car2.model + " (" +
        car2.year + "), " +
          car2.speed + " км/год"
      );
        System.out.println("   Новіший: " + (car1.year > car2.year ? car1.brand : car2.brand));
   }
static class Book {
    String title;
    String author;
    int pages;
    boolean isRead;

}
static void task3() {
    Book emptyBook = new Book();
    System.out.println(emptyBook.title);
    System.out.println(emptyBook.author);
    System.out.println(emptyBook.pages);
    System.out.println(emptyBook.isRead);
}
 static class Rectangle {
    double width;
    double height;
}
static void task4() {
    Rectangle rectangle = new Rectangle();
    rectangle.width = 7.5;
    rectangle.height = 4.0;
    double area = rectangle.width * rectangle.height;
    double perimeter = 2 * (rectangle.width + rectangle.height);
    System.out.println("Площа прямокутника: " + area);
    System.out.println("Периметр прямокутника: " + perimeter);
}
static class Product {
      String name;
      double price;
      int quantity;
}
static void task5() {
      Product product = new Product();
    product.name = "Монітор";
    product.price = 6500.0;
    product.quantity = 8;
    double totalCost = product.price * product.quantity;
    System.out.println("Товар: " + product.name);
    System.out.println("Загальна вартість : " + totalCost + " грн");
    }
    static class Smartphone {
      String model;
      int batteryLevel;
      boolean isTurnedOn;
    }
    static void task6(){
      Smartphone smartphone = new Smartphone();
    smartphone.model = "Samsung";
    smartphone.batteryLevel = 100;
    smartphone.isTurnedOn = true;
    smartphone.batteryLevel -= 35;
    if (smartphone.batteryLevel == 0) {
        smartphone.isTurnedOn = false;
    }
    System.out.println("Модель: " + smartphone.model);
    System.out.println("Рівень заряду: " + smartphone.batteryLevel + "%");
    System.out.println("Телефон увімкнений: " + smartphone.isTurnedOn);
    }
    static class Point2D {
      double x;
      double y;
    }
    static void task7() {
        Point2D A = new Point2D();
        A.x = 0;
        A.y = 0;
        Point2D B = new Point2D();
        B.x = 3;
        B.y = 4;
        double distance = Math.sqrt(
                Math.pow(B.x - A.x, 2) + Math.pow(B.y - A.y, 2)
        );
        System.out.println("Відстань між точками: " + distance);
    }
   static class Student1 {
    String name;
}
static void task8() {
    Student1 first = new Student1();
    first.name = "Іван";
    Student1 second = first;
    second.name = "Петро";
    System.out.println("Ім'я першого студента: " + first.name);
      // Змінні first і second вказують на одного й того самого студента тому, коли змінюємо ім'я через second, воно змінюється і для first.
}
static class Greeter {
    public void sayHello() {
        System.out.println("Привіт усім!");
    }
    public void sayHelloTo(String name) {
        System.out.println("Привіт, " + name + "! Раді тебе бачити.");
    }
}
static void task9() {
    Greeter greeter = new Greeter();
    greeter.sayHello();
    greeter.sayHelloTo("Іван");
}
static class Animal {
    String species;
    String name;
    public void makeSound() {
        System.out.println(name + "видає звук!");
    }
    public void printInfo() {
        System.out.println("Вид тварини: " + species);
        System.out.println("Кличка: " + name);
    }
    }
    static void task10() {
        Animal cat = new Animal();
        cat.species = "Кіт";
        cat.name = "Рікі ";
        Animal dog = new Animal();
        dog.species = "Собака";
        dog.name = "Бобік ";
        cat.printInfo();
        cat.makeSound();
        System.out.println();
        dog.printInfo();
        dog.makeSound();
}
    static class Counter{
     int count;
     public void increment(){
         count++;
     }
     public void decrement(){
         count--;
     }
     public void reset(){
         count=0;
     }
     public void printCount(){
         System.out.println("Поточне значення: "+count);
     }
}
static void task11() {
    Counter counter = new Counter();
    counter.increment();
    counter.increment();
    counter.increment();
    counter.decrement();
    counter.printCount();
}
   static class TrafficLight{
    String currentColor;
   public void changeColor(String newColor){
       currentColor = newColor;
   }
   public void showSignal(){
        if (currentColor.equals("Червоний")) {
            System.out.println("Стій!");
        } else if (currentColor.equals("Жовтий")) {
            System.out.println("Увага!");
        } else if (currentColor.equals("Зелений")) {
            System.out.println("Їдь!");
        }
   }
   }
   static void task12() {
    TrafficLight trafficLight = new TrafficLight();
    trafficLight.changeColor("Червоний");
    trafficLight.showSignal();
    trafficLight.changeColor("Жовтий");
    trafficLight.showSignal();
    trafficLight.changeColor("Зелений");
    trafficLight.showSignal();
}
    static class Player{
     String nickname;
     int health=100;
     public void takeDamage(int damage){
         health-=damage;
         if (health<=0) {
             health=0;
             System.out.println(nickname+"загинув!");
         }
     }

    public void heal(int amount) {
        health += amount;

        if (health > 100) {
            health = 100;
        }
    }
}
static void task13() {
    Player player = new Player();
    player.nickname = "Shadow";
    System.out.println("Початкове здоров'я: " + player.health);
    player.takeDamage(40);
    System.out.println("Після отримання шкоди: " + player.health);
    player.heal(20);
    System.out.println("Після лікування: " + player.health);
    player.takeDamage(90);
    System.out.println("Поточне здоров'я: " + player.health);
    }
    static class Lamp{
     boolean isOn;
         public void turnOn(){
              isOn = true;
            }
         public void turnOff(){
            isOn = false;
         }
         public void toggle(){
              isOn = !isOn;
         }
         public void status(){
              if (isOn) {
            System.out.println("Лампа світить");
        } else {
                  System.out.println("Лампа вимкнена");
              }
         }
    }
         static void task14() {
             Lamp lamp = new Lamp();
             lamp.status();
             lamp.toggle();
             lamp.status();
             lamp.toggle();
             lamp.status();
         }
       static class Stopwatch {
      int seconds;
      public void tick(){
          seconds++;
      }
      public void addSeconds(int s){
             seconds += s;
      }
      public void displayTime(){
           int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;
        System.out.printf("%02d:%02d%n", minutes, remainingSeconds);
      }
       }
     static void task15() {
    Stopwatch stopwatch = new Stopwatch();
    stopwatch.tick();
    stopwatch.addSeconds(124);
    stopwatch.displayTime();
}
static class Printer{
    String model;
    int paperCount;
    public void printDocument(String title, int pages){
        if (paperCount >= pages) {
            paperCount -= pages;
            System.out.println("Документ \"" + title + "\" успішно надруковано.");
            System.out.println("Залишилося паперу: " + paperCount + " арк.");
        } else {
            System.out.println("Помилка: Недостатньо паперу в принтері " + model + "!");
        }
    }
}
    static void task16() {
      Printer printer = new Printer();
      printer.model = "HP LaserJet";
     printer.paperCount = 10;
      printer.printDocument("Звіт", 4);
       printer.printDocument("Практична робота", 8);
}
  static class SimpleCalculator {
    public int add(int a, int b) {
        return a + b;
    }
    public int subtract(int a, int b) {
        return a - b;
    }
    public int multiply(int a, int b) {
        return a * b;
    }
    public double divide(int a, int b) {
        if (b == 0) {
            System.out.println("Помилка: ділення на нуль!");
            return 0.0;
        }
        return (double) a / b;
    }
}
static void task17() {
    SimpleCalculator calculator = new SimpleCalculator();
    int sum = calculator.add(10, 5);
    int difference = calculator.subtract(10, 5);
    int product = calculator.multiply(10, 5);
    double quotient = calculator.divide(10, 5);
    System.out.println("Сума: " + sum);
    System.out.println("Різниця: " + difference);
    System.out.println("Добуток: " + product);
    System.out.println("Частка: " + quotient);
}
   static class Circle{
        double radius;
    public double getArea() {
        return Math.PI * radius * radius;
    }
    public double getCircumference() {
        return 2 * Math.PI * radius;
    }
}
static void task18() {
    Circle circle = new Circle();
    circle.radius = 5.0;
    double area = circle.getArea();
    double circumference = circle.getCircumference();
    System.out.println("Площа круга: " + area);
    System.out.println("Довжина кола: " + circumference);
   }
    static class  TemperatureConverter{
    public double celsiusToFahrenheit(double c) {
        return c * 1.8 + 32;
    }
    public double fahrenheitToCelsius(double f) {
        return (f - 32) / 1.8;
    }
}
static void task19() {
    TemperatureConverter converter = new TemperatureConverter();
    double fahrenheit = converter.celsiusToFahrenheit(25);
    double celsius = converter.fahrenheitToCelsius(fahrenheit);
    System.out.println("25 градусів Цельсія = " + fahrenheit + " градусів Фаренгейта");
    System.out.println(fahrenheit + " градусів Фаренгейта = " + celsius + " градусів Цельсія");
    }
    static class NumberChecker{
       public boolean isEven(int n) {
        return n % 2 == 0;
    }
    public boolean isPositive(int n) {
        return n > 0;
    }
    public boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
          return true;
    }
}
static void task20() {
    NumberChecker checker = new NumberChecker();
    int[] numbers = {7, 12, -5};
    for (int n : numbers) {
        System.out.println("Число: " + n);
        System.out.println("Парне: " + checker.isEven(n));
        System.out.println("Додатне: " + checker.isPositive(n));
        System.out.println("Просте: " + checker.isPrime(n));
        System.out.println();
    }
    }
    static class CurrencyExchange{
 double usdRate = 41.5;
    public double toUSD(double uah) {
        return uah / usdRate;
    }
    public double toUAH(double usd) {
        return usd * usdRate;
    }
}
static void task21() {
    CurrencyExchange exchange = new CurrencyExchange();
    double dollars = exchange.toUSD(10000);
    System.out.printf("10000 грн = %.2f доларів США%n", dollars);
    }
    static class Employee{
      String name;
      double baseSalary;
      double bonusPercentage;
      public double calculateTotalSalary() {
        return baseSalary * (1 + bonusPercentage / 100);
      }
      public double calculateTax(){
            return calculateTotalSalary() * 0.195;
      }
    }
    static void task22() {
        Employee employee = new Employee();
        employee.name = "Степан";
        employee.baseSalary = 30000;
        employee.bonusPercentage = 15;
        double totalSalary = employee.calculateTotalSalary();
        double tax = employee.calculateTax();
        System.out.println("Працівник: " + employee.name);
        System.out.printf("Зарплата з бонусом: %.2f грн%n", totalSalary);
        System.out.printf("Податок (19.5%%): %.2f грн%n", tax);
        System.out.printf("Зарплата після податку: %.2f грн%n", totalSalary - tax);
    }
    static class TextFormatter{
      public String formatTitle(String text){
           return "*** " + text.toUpperCase() + " ***";
      }
      public int countVowels(String text){
           int count = 0;
        String vowels = "аоуеиіяюєїaeiou";
        for (int i = 0; i < text.length(); i++) {
            char letter = Character.toLowerCase(text.charAt(i));
            if (vowels.indexOf(letter) != -1) {
                count++;
      }
    }
       return count;
    }
}
    static void task23() {
    TextFormatter formatter = new TextFormatter();
    String text = "Привіт";
    System.out.println(formatter.formatTitle(text));
    System.out.println("Кількість голосних: " + formatter.countVowels(text));
}
     static class Triangle{
      double a;
      double b;
      double c;
      public boolean isValid() {
          return a > 0 && b > 0 && c > 0
                  && a + b > c
                  && a + c > b
                  && b + c > a;
      }
    public double getPerimeter() {
        return a + b + c;
    }
    public double getArea() {
        if (!isValid()) {
            return 0.0;
        }
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
static void task24() {
    Triangle triangle = new Triangle();
    triangle.a = 3;
    triangle.b = 4;
    triangle.c = 5;
    System.out.println("Трикутник правильний: " + triangle.isValid());
    System.out.println("Периметр: " + triangle.getPerimeter());
    System.out.println("Площа: " + triangle.getArea());
      }
      static class SecretVault{
      private String secretCode = "Pass123";
       public boolean verifyCode(String attempt) {
        return secretCode.equals(attempt);
    }
      }
      static void task25() {
          SecretVault vault = new SecretVault();
          // Помилка компіляції: secretCode has private access in SecretVault, vault.secretCode = "hacked";
          System.out.println(vault.verifyCode("Pass123"));
          System.out.println(vault.verifyCode("hacked"));
      }
      static class UserAccount{
       private String username;
    private String password;
    public void setCredentials(String u, String p) {
        username = u;
        password = p;
    }
    public boolean login(String enteredUser, String enteredPass) {
        return username.equals(enteredUser)
                && password.equals(enteredPass);
    }
    public void changePassword(String oldPass, String newPass) {
        if (password.equals(oldPass)) {
            password = newPass;
            System.out.println("Пароль успішно змінено!");
        } else {
            System.out.println("Помилка: неправильний старий пароль!");
        }
    }
}
static void task26() {
    UserAccount user = new UserAccount();
    user.setCredentials("student", "Pass123");
    System.out.println(user.login("student", "Pass123"));
    System.out.println(user.login("student", "wrong"));
    user.changePassword("Pass123", "NewPass456");
    System.out.println(user.login("student", "NewPass456"));
    user.changePassword("wrong", "AnotherPass");
      }
      static class BankAccount{
        private String accountNumber;
    private double balance;
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Рахунок поповнено на " + amount + " грн");
        } else {
            System.out.println("Помилка: сума поповнення має бути більшою за 0!");
        }
    }
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Знято " + amount + " грн");
            return true;
        } else {
            System.out.println("Помилка: недостатньо коштів або неправильна сума!");
            return false;
        }
    }
    public double getBalance() {
        return balance;
    }
}
static void task27() {
    BankAccount account = new BankAccount();
    account.deposit(1000);
    boolean result = account.withdraw(1500);
    System.out.println("Транзакція успішна: " + result);
    System.out.println("Залишок: " + account.getBalance() + " грн");
      }
      static class Thermometer{
       private double temperature;
    public void setTemperature(double t) {
        if (t < -273.15) {
            System.out.println("Помилка: температура нижче абсолютного нуля!");
        } else {
            temperature = t;
        }
    }
    public double getTemperature() {
        return temperature;
    }
}
    static void task28() {
    Thermometer thermometer = new Thermometer();
    thermometer.setTemperature(25.0);
    System.out.println("Температура: " + thermometer.getTemperature() + " °C");
    thermometer.setTemperature(-300.0);
    System.out.println("Температура після перевірки: "
            + thermometer.getTemperature() + " °C");
      }
      static class CarSpeedometer{
      private int speed = 0;
    public void accelerate(int delta) {
        speed += delta;
        if (speed > 240) {
            speed = 240;
        }
    }
    public void brake(int delta) {
        speed -= delta;
        if (speed < 0) {
            speed = 0;
        }
    }
    public int getSpeed() {
        return speed;
    }
}
static void task29() {
    CarSpeedometer car = new CarSpeedometer();
    car.accelerate(100);
    System.out.println("Швидкість після розгону: " + car.getSpeed() + " км/год");
    car.accelerate(200);
    System.out.println("Швидкість після сильного розгону: " + car.getSpeed() + " км/год");
    car.brake(50);
    System.out.println("Швидкість після гальмування: " + car.getSpeed() + " км/год");
    car.brake(300);
    System.out.println("Швидкість після сильного гальмування: " + car.getSpeed() + " км/год");
      }
      static class Person {
    private String name;
    private int age;
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        if (age >= 0 && age <= 120) {
            this.age = age;
        } else {
            System.out.println("Помилка: некоректний вік!");
        }
    }
    public void printSummary() {
        System.out.println("Ім'я: " + name);
        System.out.println("Вік: " + age);
    }
}
static void task30() {
    Person person1 = new Person();
    person1.setName("Олександр");
    person1.setAge(22);
    Person person2 = new Person();
    person2.setName("Стас");
    person2.setAge(18);
    System.out.println("Перша людина:");
    person1.printSummary();
    System.out.println("Друга людина:");
    person2.printSummary();
}
    static class DiscountCard{
       private String ownerName;
    private double totalSpent;
    private int discountPercent;
    public DiscountCard(String ownerName) {
        this.ownerName = ownerName;
        this.totalSpent = 0;
        this.discountPercent = 1;
    }
    public void addPurchase(double cost) {
        if (cost <= 0) {
            System.out.println("Помилка: сума покупки має бути більшою за 0!");
            return;
        }
        totalSpent += cost;
        if (totalSpent >= 10000) {
            discountPercent = 10;
        } else if (totalSpent >= 5000) {
            discountPercent = 5;
        } else {
            discountPercent = 1;
        }
    }
    public void printCardInfo() {
        System.out.println("Власник картки: " + ownerName);
        System.out.println("Загальна сума покупок: " + totalSpent + " грн");
        System.out.println("Знижка: " + discountPercent + "%");
    }
}
static void task31() {
    DiscountCard card = new DiscountCard("Анна");
    card.addPurchase(3000);
    System.out.println("Після першої покупки:");
    card.printCardInfo();
    System.out.println();
    card.addPurchase(4000);
    System.out.println("Після другої покупки:");
    card.printCardInfo();
    }
      static class SmartDoorLock{
       private int pinCode = 1234;
    private boolean isLocked = true;
    private int failedAttempts = 0;
    public void enterPin(int enteredPin) {
        if (failedAttempts >= 3) {
            System.out.println("СИСТЕМА ЗАБЛОКОВАНА! Викличте охорону.");
            return;
        }
        if (enteredPin == pinCode) {
            isLocked = false;
            failedAttempts = 0;
            System.out.println("Замок відчинено!");
        } else {
            failedAttempts++;
            System.out.println("Неправильний PIN! Спроба "
                    + failedAttempts + " з 3.");
            if (failedAttempts >= 3) {
                System.out.println("СИСТЕМА ЗАБЛОКОВАНА! Викличте охорону.");
            }
        }
    }
}
static void task32() {
    SmartDoorLock lock = new SmartDoorLock();
    lock.enterPin(1111);
    lock.enterPin(2222);
    lock.enterPin(3333);
    lock.enterPin(1234);
      }
       static class GradeBook{
      private String studentName;
       private int[] grades;
    public void setData(String name, int[] g) {
        studentName = name;
        grades = g;
    }
    public double getAverage() {
        int sum = 0;

        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.length;
    }
    public int getHighestGrade() {
        int highest = grades[0];

        for (int grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }
    public int getLowestGrade() {
        int lowest = grades[0];
        for (int grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
    }
}
static void task33() {
    GradeBook book = new GradeBook();
    int[] grades = {85, 92, 78, 96, 65};
    book.setData("Тихон", grades);
    System.out.println("Студент: Тихон");
    System.out.println("Середній бал: " + book.getAverage());
    System.out.println("Найвища оцінка: " + book.getHighestGrade());
    System.out.println("Найнижча оцінка: " + book.getLowestGrade());
       }
      static class ArrayStats {
    private int[] numbers;
    public void setNumbers(int[] nums) {
        numbers = nums;
    }
    public int countEvens() {
        int count = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                count++;
            }
        }
        return count;
    }
    public int countOdds() {
        int count = 0;
        for (int number : numbers) {
            if (number % 2 != 0) {
                count++;
            }
        }
        return count;
    }
    public int calculateSum() {
        int sum = 0;

        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
static void task34() {
    ArrayStats stats = new ArrayStats();
    int[] numbers = {5, 11, 3, 9, 15, 19, 3, 9, 14, 2};
    stats.setNumbers(numbers);
    System.out.println("Кількість парних чисел: " + stats.countEvens());
    System.out.println("Кількість непарних чисел: " + stats.countOdds());
    System.out.println("Сума всіх чисел: " + stats.calculateSum());
}
   static class ShoppingCart {
    private double[] itemPrices = new double[10];
    private int count = 0;
    public void addItem(double price) {
        if (count < itemPrices.length) {
            itemPrices[count] = price;
            count++;
        } else {
            System.out.println("Кошик заповнений!");
        }
    }
    public double getTotalCost() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += itemPrices[i];
        }
        return total;
    }
    public void applyDiscount(double percent) {
        for (int i = 0; i < count; i++) {
            itemPrices[i] = itemPrices[i] * (1 - percent / 100);
        }
    }
}
static void task35() {
    ShoppingCart cart = new ShoppingCart();
    cart.addItem(100.0);
    cart.addItem(250.0);
    cart.addItem(150.0);
    System.out.println("Чек до знижки:");
    System.out.println("Загальна сума: " + cart.getTotalCost() + " грн");
    cart.applyDiscount(15);
    System.out.println("Чек після знижки 15%:");
    System.out.println("Загальна сума: " + cart.getTotalCost() + " грн");
}
    static class TemperatureTracker {
    private double[] dailyTemps = new double[7];
    public void setTemps(double[] temps) {
        if (temps.length == 7) {
            dailyTemps = temps;
        } else {
            System.out.println("Потрібно ввести температури за 7 днів!");
        }
    }
    public int countDaysAbove(double threshold) {
        int count = 0;
        for (int i = 0; i < dailyTemps.length; i++) {
            if (dailyTemps[i] > threshold) {
                count++;
            }
        }
        return count;
    }
    public void printWeeklyReport() {
        String[] days = {
            "Понеділок", "Вівторок", "Середа",
            "Четвер", "П'ятниця", "Субота", "Неділя"
        };
        int warmestDay = 0;
        System.out.println("Звіт температур за тиждень:");
        for (int i = 0; i < dailyTemps.length; i++) {
            System.out.println(days[i] + ": " + dailyTemps[i] + " °C");
            if (dailyTemps[i] > dailyTemps[warmestDay]) {
                warmestDay = i;
            }
        }
        System.out.println("Найтепліший день: " + days[warmestDay]
                + " (" + dailyTemps[warmestDay] + " °C)");
    }
}
static void task36() {
    TemperatureTracker tracker = new TemperatureTracker();
    double[] temps = {20.5, 22.0, 21.5, 19.7, 18.1, 17.5, 15.8};
    tracker.setTemps(temps);
    tracker.printWeeklyReport();
    System.out.println("Днів із температурою вище 20 °C: "
            + tracker.countDaysAbove(20));
}
      static class ArraySearcher {
    private int[] data;
    public void setData(int[] data) {
        this.data = data;
    }
    public boolean contains(int target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return true;
            }
        }
        return false;
    }
    public int findIndex(int target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
static void task37() {
    ArraySearcher searcher = new ArraySearcher();
    int[] numbers = {10, 25, 7, 42, 15};
    searcher.setData(numbers);
    System.out.println("Чи є число 7: " + searcher.contains(7));
    System.out.println("Індекс числа 7: " + searcher.findIndex(7));
    System.out.println("Чи є число 100: " + searcher.contains(100));
    System.out.println("Індекс числа 100: " + searcher.findIndex(100));
}
    static class Vector3D {
    private double[] coords = new double[3];
    public void setCoords(double x, double y, double z) {
        coords[0] = x;
        coords[1] = y;
        coords[2] = z;
    }
    public double getMagnitude() {
        return Math.sqrt(
                coords[0] * coords[0]
                + coords[1] * coords[1]
                + coords[2] * coords[2]
        );
    }
    public void multiplyByScalar(double scalar) {
        for (int i = 0; i < coords.length; i++) {
            coords[i] *= scalar;
        }
    }
    public void printVector() {
        System.out.println("(" + coords[0] + ", "
                + coords[1] + ", " + coords[2] + ")");
    }
}
static void task38() {
    Vector3D vector = new Vector3D();
    vector.setCoords(2, 3, 6);
    System.out.print("Початковий вектор: ");
    vector.printVector();
    System.out.println("Довжина вектора: " + vector.getMagnitude());
    vector.multiplyByScalar(2);
    System.out.print("Вектор після множення на 2: ");
    vector.printVector();
}
     static class Matrix2D {
    private int[][] grid;
    public void setGrid(int[][] grid) {
        this.grid = grid;
    }
    public void printMatrix() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.printf("%4d", grid[i][j]);
            }
            System.out.println();
        }
    }
    public int getTotalSum() {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                sum += grid[i][j];
            }
        }
        return sum;
    }
    public int getRowSum(int rowIndex) {
        if (rowIndex < 0 || rowIndex >= grid.length) {
            return -1;
        }
        int sum = 0;
        for (int j = 0; j < grid[rowIndex].length; j++) {
            sum += grid[rowIndex][j];
        }
        return sum;
    }
}
static void task39() {
    Matrix2D matrix = new Matrix2D();
    int[][] numbers = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    matrix.setGrid(numbers);
    System.out.println("Матриця:");
    matrix.printMatrix();
    System.out.println("Сума всіх чисел: " + matrix.getTotalSum());
    System.out.println("Сума першого рядка: " + matrix.getRowSum(0));
    System.out.println("Сума другого рядка: " + matrix.getRowSum(1));
    System.out.println("Сума третього рядка: " + matrix.getRowSum(2));
}
     static class MatrixDiagonals {
    private int[][] matrix;
    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
    public int getMainDiagonalSum() {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }
    public int getAntiDiagonalSum() {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][matrix.length - 1 - i];
        }
        return sum;
    }
    public boolean isDiagonalSymmetric() {
        return getMainDiagonalSum() == getAntiDiagonalSum();
    }
}
static void task40() {
    MatrixDiagonals diagonals = new MatrixDiagonals();
    int[][] numbers = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    diagonals.setMatrix(numbers);
    System.out.println("Сума головної діагоналі: "
            + diagonals.getMainDiagonalSum());
    System.out.println("Сума побічної діагоналі: "
            + diagonals.getAntiDiagonalSum());
    System.out.println("Суми діагоналей рівні: "
            + diagonals.isDiagonalSymmetric());
}




}












