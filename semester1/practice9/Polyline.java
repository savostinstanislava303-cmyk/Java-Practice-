package practice9;

public class Polyline {
    private final Point2D[] vertices;
    private int count;
    public Polyline(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Місткість має бути додатною");
        }
        this.vertices = new Point2D[capacity];
        this.count = 0;
    }
    public void addVertex(double x, double y) {
        if (count >= vertices.length) {
            throw new IllegalStateException("Масив вершин заповнений (місткість: " + vertices.length + ")");
        }
        vertices[count++] = new Point2D(x, y);
    }
    public int getCount() {
        return count;
    }
    public double getTotalLength() {
        double sum = 0;
        for (int i = 1; i < count; i++) {
            sum += vertices[i - 1].distanceTo(vertices[i]);
        }
        return sum;
    }
    public double getClosedPerimeter() {
        if (count < 2) {
            return 0;
        }
        return getTotalLength() + vertices[count - 1].distanceTo(vertices[0]);
    }
}

