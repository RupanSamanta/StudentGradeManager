import java.util.Scanner;

import manager.GradeManager;
import model.Course;
import model.Grade;
import model.Student;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final GradeManager GRADE_MANAGER = new GradeManager();

    public static void main(String[] args) {
        System.out.println("Student Grade Manager");
        System.out.println("---------------------");

        boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt("Enter your choice: ");

            try {
                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        addCourse();
                        break;
                    case 3:
                        assignGrade();
                        break;
                    case 4:
                        showAllStudents();
                        break;
                    case 5:
                        showAllCourses();
                        break;
                    case 6:
                        showGradesForStudent();
                        break;
                    case 7:
                        showGradesForCourse();
                        break;
                    case 8:
                        sortStudentsBySgpa();
                        break;
                    case 9:
                        findStudentById();
                        break;
                    case 0:
                        running = false;
                        System.out.println("Exiting Student Grade Manager.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please choose a valid menu option.");
                }
            } catch (IllegalArgumentException exception) {
                System.out.println("Error: " + exception.getMessage());
            }

            System.out.println();
        }

        SCANNER.close();
    }

    private static void printMenu() {
        System.out.println("1. Add Student");
        System.out.println("2. Add Course");
        System.out.println("3. Assign Grade");
        System.out.println("4. Show All Students");
        System.out.println("5. Show All Courses");
        System.out.println("6. Show Grades For Student");
        System.out.println("7. Show Grades For Course");
        System.out.println("8. Sort Students By SGPA");
        System.out.println("9. Find Student By ID");
        System.out.println("0. Exit");
    }

    private static void addStudent() {
        String firstName = readRequiredText("First name: ");
        String lastName = readRequiredText("Last name: ");
        String studentId = readRequiredText("Student ID: ");
        int section = readInt("Section: ");
        int semester = readInt("Semester: ");

        Student student = new Student(firstName, lastName, studentId, section, semester);
        GRADE_MANAGER.addStudent(student);
        System.out.println("Student added successfully.");
    }

    private static void addCourse() {
        String courseName = readRequiredText("Course name: ");
        String courseCode = readRequiredText("Course code: ");
        int credits = readInt("Credits: ");
        int maxStudents = readInt("Maximum students: ");

        Course course = new Course(courseName, courseCode, credits);
        course.setMaxStudents(maxStudents);
        GRADE_MANAGER.addCourse(course);
        System.out.println("Course added successfully.");
    }

    private static void assignGrade() {
        if (!GRADE_MANAGER.hasStudents()) {
            System.out.println("Add at least one student before assigning grades.");
            return;
        }
        if (!GRADE_MANAGER.hasCourses()) {
            System.out.println("Add at least one course before assigning grades.");
            return;
        }

        String studentId = readRequiredText("Student ID: ");
        String courseCode = readRequiredText("Course code: ");
        float marks = readFloat("Marks obtained: ");

        Student student = GRADE_MANAGER.findStudentById(studentId);
        Course course = GRADE_MANAGER.findCourseByCode(courseCode);
        Grade grade = new Grade(student, course, marks);

        GRADE_MANAGER.addGrade(grade);
        System.out.println("Grade assigned successfully.");
    }

    private static void showAllStudents() {
        if (!GRADE_MANAGER.hasStudents()) {
            System.out.println("No students available.");
            return;
        }
        GRADE_MANAGER.printAllStudents();
    }

    private static void showAllCourses() {
        if (!GRADE_MANAGER.hasCourses()) {
            System.out.println("No courses available.");
            return;
        }
        GRADE_MANAGER.printAllCourses();
    }

    private static void showGradesForStudent() {
        if (!GRADE_MANAGER.hasGrades()) {
            System.out.println("No grades available.");
            return;
        }
        String studentId = readRequiredText("Student ID: ");
        GRADE_MANAGER.printGradesForStudent(studentId);
    }

    private static void showGradesForCourse() {
        if (!GRADE_MANAGER.hasGrades()) {
            System.out.println("No grades available.");
            return;
        }
        String courseCode = readRequiredText("Course code: ");
        GRADE_MANAGER.printGradesForCourse(courseCode);
    }

    private static void sortStudentsBySgpa() {
        if (!GRADE_MANAGER.hasStudents()) {
            System.out.println("No students available to sort.");
            return;
        }
        GRADE_MANAGER.sortStudentsBySgpa();
        System.out.println("Students sorted by SGPA in descending order.");
        GRADE_MANAGER.printAllStudents();
    }

    private static void findStudentById() {
        if (!GRADE_MANAGER.hasStudents()) {
            System.out.println("No students available.");
            return;
        }
        String studentId = readRequiredText("Student ID: ");
        Student student = GRADE_MANAGER.findStudentById(studentId);
        System.out.println(student);
    }

    private static String readRequiredText(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = SCANNER.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Input cannot be empty.");
        }
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = SCANNER.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException exception) {
                System.out.println("Please enter a valid whole number.");
            }
        }
    }

    private static float readFloat(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = SCANNER.nextLine().trim();
            try {
                return Float.parseFloat(input);
            } catch (NumberFormatException exception) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
