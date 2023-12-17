// Admin.java
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Admin extends Person {
    private String adminRole;
    private List<Teacher> teachers;
    private List<Student> students;

    public Admin(String name, int age, String adminRole) {
        super(name, age);
        this.adminRole = adminRole;
        this.teachers = loadTeachersFromFile();
        this.students = loadStudentsFromFile();
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
        saveTeachersToFile();
        System.out.println("Teacher added: " + teacher.getName());
    }

    public void viewTeachers() {
        System.out.println("Teachers:");
        for (Teacher teacher : teachers) {
            System.out.println(teacher.getName() + ", Age: " + teacher.getAge() + ", Subject: " + teacher.getSubject());
        }
    }

    public void addStudent(Student student) {
        students.add(student);
        saveStudentsToFile();
        System.out.println("Student added: " + student.getName());
    }

    public void viewStudents() {
        System.out.println("Students:");
        for (Student student : students) {
            System.out.println(student.getName() + ", Age: " + student.getAge() + ", Student ID: " + student.getStudentId());
        }
    }

    private List<Teacher> loadTeachersFromFile() {
        List<Teacher> loadedTeachers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("teachers.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 3) {
                    loadedTeachers.add(new Teacher(parts[0], Integer.parseInt(parts[1]), parts[2]));
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return loadedTeachers;
    }

    private List<Student> loadStudentsFromFile() {
        List<Student> loadedStudents = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("students.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 3) {
                    loadedStudents.add(new Student(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return loadedStudents;
    }

    private void saveTeachersToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("teachers.txt"))) {
            for (Teacher teacher : teachers) {
                writer.println(teacher.getName() + " " + teacher.getAge() + " " + teacher.getSubject());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveStudentsToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("students.txt"))) {
            for (Student student : students) {
                writer.println(student.getName() + " " + student.getAge() + " " + student.getStudentId());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
