package practice9;

public class Main17 {
    public static void main(String[] args) {
        Polyline p = new Polyline(10);
        p.addVertex(0, 0);
        p.addVertex(4, 0);
        p.addVertex(4, 3);
        p.addVertex(0, 3);
        System.out.println("Кількість вершин: " + p.getCount());
        System.out.println("Довжина ламаної: " + p.getTotalLength());
        System.out.println("Периметр замкненої: " + p.getClosedPerimeter());

        Polyline t = new Polyline(3);
        t.addVertex(0, 0);
        t.addVertex(3, 0);
        t.addVertex(3, 4);
        System.out.println("Трикутник, довжина: " + t.getTotalLength());
        System.out.println("Трикутник, периметр: " + t.getClosedPerimeter());
    }
}
