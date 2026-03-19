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
}
