# 📚 StudentGradeManager

A console-based Java application to manage students, courses, and grades. Built as a learning project to practice core Java concepts including OOP, Collections, Generics, Sorting, and Exception Handling.

---

## 🗂️ Project Structure

```
StudentGradeManager/
├── Main.java
├── model/
│   ├── Student.java       # Student entity with validation
│   ├── Course.java        # Course entity
│   └── Grade.java         # Grade linking Student and Course
└── manager/
    └── GradeManager.java  # Core logic — add, remove, search, sort
```

---

## ✨ Features

- Add and manage students with details like name, ID, semester, section, and SGPA
- Add courses with course code, name, and credits
- Assign grades to students for specific courses
- Search students quickly by ID using `HashMap`
- Sort students by SGPA using `Comparator`
- Input validation with meaningful error messages

---

## 🧠 Concepts Practiced

| Concept | Where Used |
|---|---|
| OOP (Encapsulation) | `Student`, `Course`, `Grade` model classes |
| Getters / Setters | All model classes |
| Input Validation | Setters with `IllegalArgumentException` |
| `ArrayList` | Storing list of students and courses |
| `HashMap` | Fast student lookup by ID |
| `Comparator` | Sorting students by SGPA |
| Generics | Collections and custom structures |
| `toString()` | Clean object representation |

---

## 🚀 Getting Started

### Prerequisites
- Java 11 or higher
- Any IDE (IntelliJ IDEA, VS Code, Eclipse) or terminal

### Run the project

```bash
# Compile
javac -d out src/StudentGradeManager/**/*.java src/StudentGradeManager/Main.java

# Run
java -cp out StudentGradeManager.Main
```

---

## 📦 Model Classes

### `Student`
| Field | Type | Description |
|---|---|---|
| `studentId` | `String` | Unique ID — immutable after creation |
| `firstName` | `String` | First name |
| `lastName` | `String` | Last name |
| `semester` | `int` | Must be between 1 and 8 |
| `section` | `int` | Must be at least 1 |
| `sgpa` | `float` | Must be between 0.0 and 10.0 |

### `Course`
| Field | Type | Description |
|---|---|---|
| `courseCode` | `String` | Unique code — immutable |
| `courseName` | `String` | Full name of the course |
| `credits` | `int` | Must be between 1 and 5 |
| `maxStudents` | `int` | Must be greater than 0 |

### `Grade`
| Field | Type | Description |
|---|---|---|
| `student` | `Student` | Linked student — immutable |
| `course` | `Course` | Linked course — immutable |
| `marksObtained` | `float` | Must be between 0.0 and 100.0 |
| `grade` | `String` | Auto-calculated: 90+=A, 80+=B, 70+=C, else F |

---

## 📈 Roadmap

- [x] Student model with validation
- [x] Course model
- [ ] Grade model
- [ ] GradeManager with ArrayList and HashMap
- [ ] Sort students by SGPA
- [ ] Console menu interface

---

## 🙋 About

This project is part of a self-learning Java journey, progressing from Beginner to Intermediate level. Built step by step with a focus on writing clean, well-structured Java code.

---

## 📄 License

This project is open source and free to use for learning purposes.