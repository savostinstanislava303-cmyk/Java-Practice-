package practice2;

public class practice02 {
    public static void main(String[] args) {
        int firstNumber = 5;
        double userWeight = 72.5;
        String userCity = "Kiyv";
        boolean isValidUser = true;
        System.out.println(firstNumber);
        System.out.println(userWeight);
        System.out.println(userCity);
        System.out.println(isValidUser);
        System.out.println();
        String firstName = "Тарас ";
        String lastName = "Шевченко";
        int age = 47;
        System.out.println("Мене звати " +  firstName + "" + lastName + ",мені " + age + " років");
        System.out.println();
        System.out.println("Сума без дужок: " + 10 + 20);
        System.out.println("Сума з дужками: " + (10 + 20));
        //у першому виразі 10 і 20 додається до тексту, тому вони з'єднались, а у другому як математичний вираз
        System.out.println();
        String login = "ivan.petrenko ";
        String domain = "gmail.com";
        String role = "student";
        String email=login + "@" + domain;
        System.out.println("Користувач " +login +"(роль:" + role +") має пошту:");
        System.out.println(email);
        System.out.println();
        String productName = "Ноутбук";
        int quantity = 2;
        double pricePerUnit = 24500.50;
        System.out.println("ЧЕК:\n"+ "Товар: " + productName + "\n" + "Кількість: "+ quantity+"шт.\n" + "Ціна: " + pricePerUnit + "грн");
        System.out.println();
        String currency = "UAH";
        int hryvnias = 1500;
        int kopecks = 75;
        System.out.println("Поточний баланс: " + hryvnias + "." + kopecks + " " + currency);
        System.out.println();
        String protocol = "https://";
        String host = "api.example.com";
        String endpoint = "/user";
        int userId = 42;
        System.out.println("Запит відправлено на: " + protocol + host + endpoint + userId);
        System.out.println();
        String language = "Java";
        int level = 1;
        boolean isReady = true;
        System.out.println("Мова: " + language +" | "+ "Рівень:" +level + " | " + "Готовність до практики: " + isReady);
        System.out.println();



    }
}
