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
        if (marksObtained < 0.0f || marksObtained > 100.0f)
            throw new IllegalArgumentException("Marks must be between 0 and 100");
        this.marksObtained = marksObtained;
        this.grade = calculateGrade(marksObtained);
    }

    private String calculateGrade(float marks) {
        if (marks >= 90) return "A+";
        if (marks >= 80) return "A";
        if (marks >= 70) return "B+";
        if (marks >= 60) return "B";
        if (marks >= 50) return "C";
        if (marks >= 40) return "D";
        return "F";
    }
}

