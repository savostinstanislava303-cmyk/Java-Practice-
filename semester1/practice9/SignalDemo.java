package practice9;

import java.util.Arrays;
abstract class AbstractFilter {
    private final String filterName;
    public AbstractFilter(String filterName) {
        if (filterName == null || filterName.isBlank()) {
            throw new IllegalArgumentException("Назва фільтра не може бути порожньою");
        }
        this.filterName = filterName;
    }
    public String getFilterName() {
        return filterName;
    }
    public abstract double processSample(double x);
    @Override
    public String toString() {
        return filterName;
    }
}
class AmplifierFilter extends AbstractFilter {
    private final double gain;
    public AmplifierFilter(double gain) {
        super("Підсилювач x" + gain);
        if (Double.isNaN(gain) || Double.isInfinite(gain)) {
            throw new IllegalArgumentException("Коефіцієнт підсилення має бути скінченним числом");
        }
        this.gain = gain;
    }
    @Override
    public double processSample(double x) {
        return x * gain;
    }
}
class ClippingFilter extends AbstractFilter {
    private final double threshold;
    public ClippingFilter(double threshold) {
        super("Обмежувач ±" + threshold);
        if (threshold < 0 || Double.isNaN(threshold)) {
            throw new IllegalArgumentException("Поріг не може бути від'ємним");
        }
        this.threshold = threshold;
    }
    @Override
    public double processSample(double x) {
        return Math.max(-threshold, Math.min(threshold, x));
    }
}
class SignalProcessor {
    private final AbstractFilter[] pipeline;
    public SignalProcessor(AbstractFilter[] pipeline) {
        if (pipeline == null || pipeline.length == 0) {
            throw new IllegalArgumentException("Конвеєр має містити хоча б один фільтр");
        }
        for (AbstractFilter f : pipeline) {
            if (f == null) {
                throw new IllegalArgumentException("Фільтр не може бути null");
            }
        }
        this.pipeline = pipeline.clone(); // захисна копія конвеєра
    }
    public double[] process(double[] signal) {
        if (signal == null) {
            throw new IllegalArgumentException("Сигнал не може бути null");
        }
        double[] result = Arrays.copyOf(signal, signal.length); // захисна копія
        for (AbstractFilter filter : pipeline) {
            for (int i = 0; i < result.length; i++) {
                result[i] = filter.processSample(result[i]);
            }
        }
        return result;
    }
}
public class SignalDemo {
    public static void main(String[] args) {
        double[] signal = {-3.0, -1.0, 0.5, 2.0, 4.0};
        SignalProcessor ampThenClip = new SignalProcessor(new AbstractFilter[] {
            new AmplifierFilter(2.0),
            new ClippingFilter(5.0)
        });
        SignalProcessor clipThenAmp = new SignalProcessor(new AbstractFilter[] {
            new ClippingFilter(3.5),
            new AmplifierFilter(2.0)
        });
        System.out.println("Вхідний сигнал:           " + Arrays.toString(signal));
        System.out.println("Підсилення x2 -> ±5:      " + Arrays.toString(ampThenClip.process(signal)));
        System.out.println("Обмеження ±3.5 -> x2:     " + Arrays.toString(clipThenAmp.process(signal)));
        System.out.println("Вхідний після обробки:    " + Arrays.toString(signal) + " (не змінився)");
    }
    
}

