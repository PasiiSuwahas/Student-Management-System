package StudentManagemnt2;

public class Student {
    String studentID;
    String studentName;
    Module[] marks;

//

    Student(String studentID, String studentName) {
        this.studentID=studentID;
        this.studentName=studentName;
    }

    public Student(String studentID, String studentName, Module[] marks) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.marks = marks;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getStudentName() {

        return studentName;
    }

    public Module[] getMarks() {
        return marks;
    }
}
