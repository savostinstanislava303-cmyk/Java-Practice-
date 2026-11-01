package practice8;

public class practice10 {
    public static void main (String[] args) {
        System.out.println("---- Завдання 10 ----");
          Dog dog = new Dog("Бобік", 3, 12.5, "Америкаський кокер-спанієль ");
        Cat cat = new Cat("Рікі", 2, 4.2, true);
        System.out.println(dog);
        System.out.println(dog.fetchStick());
        System.out.println();
        System.out.println(cat);
        System.out.println(cat.purr());
    }
}
// Батьківський клас
class Animal {
    private String name;
    private int age;
    private double weight;
    public Animal(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }
    @Override
    public String toString() {
        return "Ім'я: " + name +
                ", вік: " + age +
                ", вага: " + weight + " кг";
    }
}
// Клас собаки
class Dog extends Animal {
    private String breed;
    public Dog(String name, int age, double weight, String breed) {
        super(name, age, weight);
        this.breed = breed;
    }
    public String fetchStick() {
        return "Собака приносить палицю!";
    }
    @Override
    public String toString() {
        return "Собака: " + super.toString() +
                ", порода: " + breed;
    }
}
// Клас кота
class Cat extends Animal {
    private boolean isIndoor;
    public Cat(String name, int age, double weight, boolean isIndoor) {
        super(name, age, weight);
        this.isIndoor = isIndoor;
    }
    public String purr() {
        return "Кіт муркоче: мур-мур!";
    }
    @Override
    public String toString() {
        return "Кіт: " + super.toString() +
                ", хатній: " + (isIndoor ? "так" : "ні");
    }

}
