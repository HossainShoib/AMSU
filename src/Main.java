import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the UMS");
        System.out.println("1. Login as admin");
        System.out.println("2. Login as teacher");
        System.out.println("3. Login as student");
        System.out.print("Enter choice: ");

        int choice = scanner.nextInt();

        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();

        if (Login.authenticate(username, password)) {
            switch (choice) {
                case 1:
                    adminMenu();
                    break;
                case 2:
                    teacherMenu();
                    break;
                case 3:
                    studentMenu();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } else {
            System.out.println("Authentication failed. Invalid username or password.");
        }

        scanner.close();
    }

    private static void adminMenu() {
        Admin admin = new Admin("AdminName", 30, "System Administrator");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Admin Menu:");
            System.out.println("1. Add Teacher");
            System.out.println("2. View Teachers");
            System.out.println("3. Add Student");
            System.out.println("4. View Students");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int adminChoice = scanner.nextInt();

            switch (adminChoice) {
                case 1:
                    System.out.print("Enter teacher name: ");
                    String teacherName = scanner.next();
                    System.out.print("Enter teacher age: ");
                    int teacherAge = scanner.nextInt();
                    System.out.print("Enter teacher subject: ");
                    String teacherSubject = scanner.next();

                    Teacher newTeacher = new Teacher(teacherName, teacherAge, teacherSubject);
                    admin.addTeacher(newTeacher);
                    break;

                case 2:
                    admin.viewTeachers();
                    break;

                case 3:
                    System.out.print("Enter student name: ");
                    String studentName = scanner.next();
                    System.out.print("Enter student age: ");
                    int studentAge = scanner.nextInt();
                    System.out.print("Enter student ID: ");
                    int studentId = scanner.nextInt();

                    Student newStudent = new Student(studentName, studentAge, studentId);
                    admin.addStudent(newStudent);
                    break;

                case 4:
                    admin.viewStudents();
                    break;

                case 5:
                    System.out.println("Exiting Admin Menu");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void teacherMenu() {
        System.out.println("Teacher Menu:");
        // Add teacher-specific menu options here
    }

    private static void studentMenu() {
        System.out.println("Student Menu:");
        // Add student-specific menu options here
    }
}
