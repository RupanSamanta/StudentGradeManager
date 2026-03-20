package manager;

import model.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class GradeManager {

    private List<Student> students;
    private List<Course> courses;
    private List<Grade> grades;
    private HashMap<String, Student> studentMap;

    public GradeManager() {
        students = new ArrayList<>();
        courses = new ArrayList<>();
        grades = new ArrayList<>();
        studentMap = new HashMap<>();
    }

    // STUDENT METHODS
    public void addStudent(Student student) {
        if (studentMap.containsKey(student.getStudentId())) {
            throw new IllegalArgumentException("Student with ID " + student.getStudentId() + " already exists.");
        }
        students.add(student);
        studentMap.put(student.getStudentId(), student);
    }

    public Student findStudentById(String studentId) {
        if (!studentMap.containsKey(studentId)) {
            throw new IllegalArgumentException("Student with ID " + studentId + " not found.");
        }
        return studentMap.get(studentId);
    }

    public void printAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void sortStudentsBySgpa() {
        students.sort(Comparator.comparingDouble(Student::getSgpa).reversed());
    }

    // COURSE METHODS
    public void addCourse(Course course) {
        if (courses.contains(course)) {
            throw new IllegalArgumentException("Course " + course.getCourseName() + " already exists.");
        }
        courses.add(course);
    }

    public Course findCourseByCode(String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equals(courseCode)) {
                return course;
            }
        }
        throw new IllegalArgumentException("Course with code " + courseCode + " not found.");
    }

    public void printAllCourses() {
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    // GRADE METHODS
    public void addGrade(Grade grade) {
        // validate student and course exist
        findStudentById(grade.getStudent().getStudentId());
        findCourseByCode(grade.getCourse().getCourseCode());
        grades.add(grade);
    }

    public ArrayList<Grade> getGradesForStudent(String studentId) {
        ArrayList<Grade> studentGrades = new ArrayList<>();
        for (Grade grade : grades) {
            if (grade.getStudent().getStudentId().equals(studentId)) {
                studentGrades.add(grade);
            }
        }
        return studentGrades;
    }

    public ArrayList<Grade> getGradesForCourse(String courseCode) {
        ArrayList<Grade> courseGrades = new ArrayList<>();
        for (Grade grade : grades) {
            if (grade.getCourse().getCourseCode().equals(courseCode)) {
                courseGrades.add(grade);
            }
        }
        return courseGrades;
    }

    public void printGradesForStudent(String studentId) {
        ArrayList<Grade> studentGrades = getGradesForStudent(studentId);
        if (studentGrades.isEmpty()) {
            System.out.println("No grades found for student ID " + studentId);
            return;
        }
        for (Grade grade : studentGrades) {
            System.out.println(grade.getCourse().getCourseName() + ": " + grade.getMarksObtained() + " (" + grade.getGrade() + ")");
        }
    }
}
