package practice8;

class IntRangeTask7 {
    private int min;
    private int max;
    // Конструктор
    public IntRangeTask7(int min, int max) {
        if (min <= max) {
            this.min = min;
            this.max = max;
        } else {
            this.min = max;
            this.max = min;
        }
    }
    public int getMin() {
        return min;
    }
    public int getMax() {
        return max;
    }
    public void setRange(int min, int max) {
        if (min <= max) {
            this.min = min;
            this.max = max;
        } else {
            this.min = max;
            this.max = min;
        }
    }
    public boolean contains(int value) {
        return value >= min && value <= max;
    }

    public int getLength() {
        return max - min;
    }

    @Override
    public String toString() {
        return String.format(
                "[%d .. %d] (довжина: %d)",
                min, max, getLength()
        );
    }
}

class IntRangeMainTask7 {
    public static void main(String[] args) {
        IntRangeTask7 range = new IntRangeTask7(10, 30);
        System.out.println("Початковий діапазон:");
        System.out.println(range);
        System.out.println("Число 15 входить у діапазон: " +
                range.contains(15));
        System.out.println("Число 40 входить у діапазон: " +
                range.contains(40));
        IntRangeTask7 range2 = new IntRangeTask7(50, 20);
        System.out.println("\nДіапазон після автоматичної заміни меж:");
        System.out.println(range2);
        range.setRange(100, 40);
        System.out.println("\nПісля оновлення:");
        System.out.println(range);
    }
}
