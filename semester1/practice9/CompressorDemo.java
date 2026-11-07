package practice9;

abstract class AbstractCompressor {
    private final String algorithmName;
    public AbstractCompressor(String algorithmName) {
        if (algorithmName == null || algorithmName.isBlank()) {
            throw new IllegalArgumentException("Назва алгоритму не може бути порожньою");
        }
        this.algorithmName = algorithmName;
    }
    public String getAlgorithmName() {
        return algorithmName;
    }
    public abstract int estimateCompressedSize(int originalSizeBytes);
    public double getCompressionRatio(int originalSizeBytes) {
        checkSize(originalSizeBytes);
        int compressed = estimateCompressedSize(originalSizeBytes);
        return (1.0 - (double) compressed / originalSizeBytes) * 100.0;
    }
    protected void checkSize(int originalSizeBytes) {
        if (originalSizeBytes <= 0) {
            throw new IllegalArgumentException("Розмір файлу має бути додатним");
        }
    }
    @Override
    public String toString() {
        return algorithmName;
    }
}
class ZipCompressor extends AbstractCompressor {
    private static final double SAVING = 0.45; // стискає на 45%
    public ZipCompressor() {
        super("ZIP");
    }
    @Override
    public int estimateCompressedSize(int originalSizeBytes) {
        checkSize(originalSizeBytes);
        return (int) Math.round(originalSizeBytes * (1.0 - SAVING));
    }
}
class UltraLzmaCompressor extends AbstractCompressor {
    private static final double SAVING = 0.70;  // стискає на 70%
    private static final int HEADER_BYTES = 128; // службовий заголовок
    public UltraLzmaCompressor() {
        super("Ultra LZMA");
    }
    @Override
    public int estimateCompressedSize(int originalSizeBytes) {
        checkSize(originalSizeBytes);
        return (int) Math.round(originalSizeBytes * (1.0 - SAVING)) + HEADER_BYTES;
    }
}
public class CompressorDemo {
    public static void main(String[] args) {
        AbstractCompressor[] compressors = {
            new ZipCompressor(),
            new UltraLzmaCompressor()
        };
        int[] sizes = {100, 1000, 100000};
        for (int size : sizes) {
            System.out.println("Оригінал: " + size + " байт");
            for (AbstractCompressor c : compressors) {
                System.out.printf("  %-11s -> %6d байт, стиснення: %.2f%%%n",
                        c, c.estimateCompressedSize(size), c.getCompressionRatio(size));
            }
        }
    }
}

