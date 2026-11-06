package practice9;

public class ClosedInterval {
  private double start;
  private double end;
  public ClosedInterval(double start, double end) {
        resize(start, end);
    }
    public void resize(double newStart, double newEnd) {
        if (newStart > newEnd) {
            double temp = newStart;
            newStart = newEnd;
            newEnd = temp;
        }
        this.start = newStart;
        this.end = newEnd;
    }
    public double getLength() {
        return end - start;
    }
    public double getMidpoint() {
        return (start + end) / 2.0;
    }
    public boolean overlaps(ClosedInterval other) {
        if (other == null) {
            return false;
        }
        return this.start <= other.end &&
               this.end >= other.start;
    }
    @Override
    public String toString() {
        return "[" + start + "; " + end + "] (центр: "
                + getMidpoint() + ", довжина: "
                + getLength() + ")";
    }

}
