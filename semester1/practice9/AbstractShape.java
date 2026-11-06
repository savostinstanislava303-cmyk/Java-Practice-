package practice9;

import java.util.Locale;
public abstract class AbstractShape {
    private String color;
    public AbstractShape(String color) {
        if (color == null || color.isBlank()) {
            throw new IllegalArgumentException("Колір не може бути порожнім");
        }
        this.color = color;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        if (color == null || color.isBlank()) {
            throw new IllegalArgumentException("Колір не може бути порожнім");
        }
        this.color = color;
    }
    public abstract double getArea();
    public abstract double getPerimeter();
    @Override
    public String toString() {
        return String.format(Locale.US, "%s [колір: %s, площа: %.2f, периметр: %.2f]",
                getClass().getSimpleName(), color, getArea(), getPerimeter());
    }
}

