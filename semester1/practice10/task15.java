package practice10;

public class task15 {
    interface Transformable2D{
        void translate(double dx, double dy);
        void scale(double factor);
    }
     static class BoundingBox implements Transformable2D {
        private double x, y;
        private double w, h;
        public BoundingBox(double x, double y, double w, double h) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
        }
        @Override
        public void translate(double dx, double dy) {
            x += dx;
            y += dy;
        }
        @Override
        public void scale(double factor) {
            if (factor <= 0) {
                throw new IllegalArgumentException("Коефіцієнт має бути більше 0");
            }
            x *= factor;
            y *= factor;
            w *= factor;
            h *= factor;
        }
        @Override
        public String toString() {
            return "BoundingBox: x=" + x + ", y=" + y +
                    ", w=" + w + ", h=" + h;
        }
    }
    static class CircleRegion implements Transformable2D {
        private double x, y;
        private double r;
        public CircleRegion(double x, double y, double r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
        @Override
        public void translate(double dx, double dy) {
            x += dx;
            y += dy;
        }
        @Override
        public void scale(double factor) {
            if (factor <= 0) {
                throw new IllegalArgumentException("Коефіцієнт має бути більше 0");
            }
            x *= factor;
            y *= factor;
            r *= factor;
        }
        @Override
        public String toString() {
            return "CircleRegion: x=" + x + ", y=" + y + ", r=" + r;
        }
    }
    public static void applyGlobalTransform(
            Transformable2D[] objects,
            double dx,
            double dy,
            double scaleFactor) {
        for (Transformable2D object : objects) {
            object.translate(dx, dy);
            object.scale(scaleFactor);
        }
    }
    public static void main(String[] args) {
        Transformable2D[] objects = {
                new BoundingBox(2, 3, 10, 5),
                new CircleRegion(4, 6, 3)
        };
        System.out.println("До трансформації:");
        for (Transformable2D object : objects) {
            System.out.println(object);
        }
        applyGlobalTransform(objects, 2, 3, 2);
        System.out.println("\nПісля трансформації:");
        for (Transformable2D object : objects) {
            System.out.println(object);
        }
    }
}
