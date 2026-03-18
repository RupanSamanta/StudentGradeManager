package StudentGradeManager.model;

public class Course {
    private String courseName;
    private String courseCode;
    private int credits;
    private int maxStudents;

    public Course(String courseName, String courseCode, int credits) {
        this.courseCode = courseCode;
        setCourseName(courseName);
        setCredit(credits);
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredit(int credits) {
        if (credits < 1 || credits > 5) {
            throw new IllegalArgumentException("Credits must be between 1 and 5.");
        }
        this.credits = credits;
    }

    public void setCourseName(String courseName) {
        if (courseName == null || courseName.isBlank())
            throw new IllegalArgumentException("Course name cannot be empty");
        this.courseName = courseName;
    }

    public void setMaxStudents(int maxStudents) {
        if (maxStudents <= 0)
            throw new IllegalArgumentException("Max students must be greater than 0");
        this.maxStudents = maxStudents;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s | Credits: %d | Max Students: %d", courseCode, courseName, credits, maxStudents);
    }
}
