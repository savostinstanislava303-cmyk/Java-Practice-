package practice9;

public class CourseModule {
    private final String topic;
    private final int lectureHours;
    private final int practiceHours;
    private double maxScore;
    public CourseModule(String topic, int lectureHours, int practiceHours, double maxScore) {
        if (topic == null || topic.isBlank()) {
            throw new IllegalArgumentException("Тема не може бути порожньою");
        }
        if (lectureHours < 0 || practiceHours < 0) {
            throw new IllegalArgumentException("Кількість годин не може бути від'ємною");
        }
        if (maxScore < 0) {
            throw new IllegalArgumentException("Максимальний бал не може бути від'ємним");
        }
        this.topic = topic;
        this.lectureHours = lectureHours;
        this.practiceHours = practiceHours;
        this.maxScore = maxScore;
    }
    public String getTopic() {
        return topic;
    }
    public int getLectureHours() {
        return lectureHours;
    }
    public int getPracticeHours() {
        return practiceHours;
    }
    public double getMaxScore() {
        return maxScore;
    }
    public void setMaxScore(double maxScore) {
        if (maxScore < 0) {
            throw new IllegalArgumentException("Максимальний бал не може бути від'ємним");
        }
        this.maxScore = maxScore;
    }
    public int getTotalHours() {
        return lectureHours + practiceHours;
    }
}

