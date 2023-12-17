// Teacher.java
public class Teacher extends Person {
    private String subject;

    // Constructor
    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    // Getter and Setter method for subject
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
