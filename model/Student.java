package model;

public class Student {
    private String firstName;
    private String lastName;
    private String studentId;
    private int section;
    private int semester;
    private float sgpa;

    public Student(String firstName, String lastName, String studentId, int section, int semester, float sgpa) {
        if (section < 1)
            throw new IllegalArgumentException("Section must be at least 1");

        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.setSection(section);
        this.setSemester(semester);
        this.setSgpa(sgpa);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getStudentId() {
        return studentId;
    }

    public int getSection() {
        return section;
    }

    public int getSemester() {
        return semester;
    }

    public float getSgpa() {
        return sgpa;
    }

    public void setSemester(int semester) {
        if (semester < 1 || semester > 8)
            throw new IllegalArgumentException("Semester must be between 1 and 8");
        this.semester = semester;
    }

    public void setSection(int section) {
        if (section < 1)
            throw new IllegalArgumentException("Section must be at least 1");
        this.section = section;
    }

    public void setSgpa(float sgpa) {
        if (sgpa < 0.0f || sgpa > 10.0f) {
            throw new IllegalArgumentException("SGPA must be between 0.0 and 10.0");
        }
        this.sgpa = sgpa;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentId + ", Name: " + getFullName() + ", Section: " + section + ", Semester: "
                + semester + ", SGPA: " + sgpa;
    }
}
