package practice9;

class Point2D1 {
    private double x;
    private double y;
    public Point2D1(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double distanceTo(Point2D1 other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
public class LineSegment {
    private final Point2D1 start;
    private final Point2D1 end;
    public LineSegment(Point2D1 start, Point2D1 end) {
        this.start = new Point2D1(start.getX(), start.getY());
        this.end = new Point2D1(end.getX(), end.getY());
    }
    public double getLength() {
        return start.distanceTo(end);
    }
    public Point2D1 getMidpoint() {
        double middleX = (start.getX() + end.getX()) / 2;
        double middleY = (start.getY() + end.getY()) / 2;
        return new Point2D1(middleX, middleY);
    }
    @Override
    public String toString() {
        return "Відрізок: початок = " + start +
                ", кінець = " + end +
                ", довжина = " + getLength() +
                ", середина = " + getMidpoint();
    }
    public static void main(String[] args) {
        Point2D1 point1 = new Point2D1(2, 3);
        Point2D1 point2 = new Point2D1(8, 7);
        LineSegment segment = new LineSegment(point1, point2);
        System.out.println(segment);
        System.out.println("Довжина відрізка: " +
                segment.getLength());
        System.out.println("Середина відрізка: " +
                segment.getMidpoint());
    }
}



