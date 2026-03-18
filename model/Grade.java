package StudentGradeManager.model;

public class Grade {

    Student student;
    Course course;
    float marksObtained;
    String grade;

    public Grade(Student student, Course course, float marksObtained) {
        this.student = student;
        this.course = course;
        setMarksObtained(marksObtained);
    }

    public void setMarksObtained(float marksObtained) {
        if (marksObtained < 0 || marksObtained > 100) {
            throw new IllegalArgumentException("Marks must be between 0 and 100.");
        }
        this.marksObtained = marksObtained;
    }
}
