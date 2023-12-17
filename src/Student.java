// Student.java
public class Student extends Person {
    private int studentId;

    // Constructor
    public Student(String name, int age, int studentId) {
        super(name, age);
        this.studentId = studentId;
    }

    // Getter and Setter method for studentId
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
