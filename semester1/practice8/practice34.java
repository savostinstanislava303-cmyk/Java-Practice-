package practice8;

    class GradeSheet {
    private String studentName;
    protected int[] grades;
    public GradeSheet(String studentName, int[] grades) {
        this.studentName = studentName;
        this.grades = grades;
    }
    public double calculateScore() {
        if (grades.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.length;
    }
    @Override
    public String toString() {
        return "Студент: " + studentName +
                ", звичайний середній бал: " +
                String.format("%.2f", calculateScore());
    }
}
class WeightedGradeSheet extends GradeSheet {
    private double[] weights;
    public WeightedGradeSheet(String studentName, int[] grades, double[] weights) {
        super(studentName, grades);
        this.weights = weights;
    }
    @Override
    public double calculateScore() {
        if (grades.length == 0 || grades.length != weights.length) {
            return 0;
        }
        double weightedSum = 0;
        double weightsSum = 0;
        for (int i = 0; i < grades.length; i++) {
            weightedSum += grades[i] * weights[i];
            weightsSum += weights[i];
        }
        if (weightsSum == 0) {
            return 0;
        }
        return weightedSum / weightsSum;
    }
    @Override
    public String toString() {
        return "Зважений середній бал: " +
                String.format("%.2f", calculateScore());
    }
}
public class practice34 {
    public static void main(String[] args) {
        int[] grades = {90, 75, 100, 80};
        double[] weights = {2.0, 1.0, 3.0, 2.0};
        GradeSheet regular = new GradeSheet("Олена", grades);
        WeightedGradeSheet weighted =
                new WeightedGradeSheet("Олена", grades, weights);
        System.out.println(regular);
        System.out.println(weighted);
    }
}
