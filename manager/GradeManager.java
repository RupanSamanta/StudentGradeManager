import StudentGradeManager.model.*;
import java.util.*;

public class GradeManager {

    // ─── DATA STORAGE ───────────────────────────────────────────
    private ArrayList<Student> students;
    private ArrayList<Course> courses;
    private ArrayList<Grade> grades;
    private HashMap<String, Student> studentMap; // studentId → Student

    // ─── CONSTRUCTOR ────────────────────────────────────────────
    public GradeManager() {
        // initialize all lists and map here
    }

    // ─── STUDENT METHODS ────────────────────────────────────────
    public void addStudent(Student student) {
        // add to both ArrayList AND HashMap
    }

    public Student findStudentById(String studentId) {
        // use studentMap for fast lookup
        // throw exception if not found
    }

    public void printAllStudents() {
        // loop ArrayList and print each student
    }

    public void sortStudentsBySgpa() {
        // use Comparator to sort students list by sgpa descending
    }

    // ─── COURSE METHODS ─────────────────────────────────────────
    public void addCourse(Course course) {
        // add to courses list
        // throw exception if courseCode already exists
    }

    public Course findCourseByCode(String courseCode) {
        // loop courses list and find matching courseCode
        // throw exception if not found
    }

    public void printAllCourses() {
        // loop and print each course
    }

    // ─── GRADE METHODS ──────────────────────────────────────────
    public void addGrade(Grade grade) {
        // add to grades list
        // make sure same student+course combo doesn't exist already
    }

    public ArrayList<Grade> getGradesForStudent(String studentId) {
        // find student by id
        // loop grades and collect all grades matching that student
        // return the result list
    }

    public ArrayList<Grade> getGradesForCourse(String courseCode) {
        // find course by code
        // loop grades and collect all grades matching that course
        // return the result list
    }

    public void printGradesForStudent(String studentId) {
        // call getGradesForStudent()
        // loop and print each grade
    }
}