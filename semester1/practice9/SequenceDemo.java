package practice9;

abstract class AbstractSequence {
    private final String title;
    public AbstractSequence(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Назва послідовності не може бути порожньою");
        }
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
    public abstract double getTerm(int index);
    public double sumFirstN(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n не може бути від'ємним");
        }
        double sum = 0.0;
        for (int i = 1; i <= n; i++) {
            sum += getTerm(i);
        }
        return sum;
    }
    protected void checkIndex(int index) {
        if (index < 1) {
            throw new IllegalArgumentException("Індекс має бути >= 1, отримано: " + index);
        }
    }
    @Override
    public String toString() {
        return title;
    }
}
class HarmonicSequence extends AbstractSequence {
    public HarmonicSequence() {
        super("Гармонічна послідовність (a_n = 1/n)");
    }
    @Override
    public double getTerm(int index) {
        checkIndex(index);
        return 1.0 / index;
    }
}
class SquareNumbersSequence extends AbstractSequence {
    public SquareNumbersSequence() {
        super("Послідовність квадратів (a_n = n^2)");
    }
    @Override
    public double getTerm(int index) {
        checkIndex(index);
        return (double) index * index;
    }
}
public class SequenceDemo {
    public static void main(String[] args) {
        AbstractSequence[] sequences = {
            new HarmonicSequence(),
            new SquareNumbersSequence()
        };
        int n = 5;
        for (AbstractSequence s : sequences) {
            System.out.printf("%s: a_3 = %.4f, сума перших %d членів = %.4f%n",
                    s, s.getTerm(3), n, s.sumFirstN(n));
        }
    }
}

