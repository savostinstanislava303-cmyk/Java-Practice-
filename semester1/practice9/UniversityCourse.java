package practice9;

public class UniversityCourse {
    private static final double HOURS_PER_ECTS_CREDIT = 30.0;
    private static final double REQUIRED_TOTAL_SCORE = 100.0;
    private static final double EPSILON = 1e-9;
    private final String courseTitle;
    private final CourseModule[] modules;
    private int moduleCount;
    public UniversityCourse(String courseTitle, int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Місткість має бути додатною");
        }
        this.courseTitle = courseTitle;
        this.modules = new CourseModule[capacity];
        this.moduleCount = 0;
    }
    public String getCourseTitle() {
        return courseTitle;
    }
    public int getModuleCount() {
        return moduleCount;
    }
    public boolean addModule(CourseModule module) {
        if (module == null || moduleCount >= modules.length) {
            return false;
        }
        modules[moduleCount++] = module;
        return true;
    }
    public int getTotalHours() {
        int total = 0;
        for (int i = 0; i < moduleCount; i++) {
            total += modules[i].getTotalHours();
        }
        return total;
    }
    public double getTotalEctsCredits() {
        return getTotalHours() / HOURS_PER_ECTS_CREDIT;
    }
    public double getTotalMaxScore() {
        double total = 0;
        for (int i = 0; i < moduleCount; i++) {
            total += modules[i].getMaxScore();
        }
        return total;
    }
    public boolean isScoreSumValid() {
        return Math.abs(getTotalMaxScore() - REQUIRED_TOTAL_SCORE) < EPSILON;
    }
}


