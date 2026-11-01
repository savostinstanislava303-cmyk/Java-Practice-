package practice8;

public class practice12 {
      public static void main(String[] args) {
          System.out.println("---- Завдання 12 ----");
 Rectangle rectangle = new Rectangle(5, 4);
        Box3D box = new Box3D(5, 4, 3);
        System.out.println(rectangle);
        System.out.println();
        System.out.println(box);
        System.out.println("Об'єм паралелепіпеда: " + box.getVolume());
    }
}
// клас прямокутника
class Rectangle {
    private double width;
    private double height;
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    public double getWidth() {
        return width;
    }
    public double getHeight() {
        return height;
    }
    public double getArea() {
        return width * height;
    }
    @Override
    public String toString() {
        return "Прямокутник: ширина = " + width +
                ", висота = " + height +
                ", площа = " + getArea();
    }
}
// Клас паралелепіпеда
class Box3D extends Rectangle {
    private double depth;
    public Box3D(double width, double height, double depth) {
        super(width, height);
        this.depth = depth;
    }
    public double getVolume() {
        return super.getArea() * depth;
    }
    @Override
    public String toString() {
        return "Паралелепіпед: ширина = " + getWidth() +
                ", висота = " + getHeight() +
                ", глибина = " + depth +
                ", об'єм = " + getVolume();


      }
}
