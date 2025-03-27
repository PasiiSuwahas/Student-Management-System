package StudentManagemnt2;
import java.io.IOException;
import java.util.Scanner;



public class Main {
    static  Student [] studentNameArray=new Student[100];
    public static void main(String[] args) throws IOException {
        studentNameArray = StudentManagementUtil.loadStudentDetails();
        /*Calling mainMenu Method */
        mainMenu();


    }
    /* Creating a method for main Menu */
    public static void mainMenu() throws IOException {
        int choice =0;
        while (choice != 8) {
            System.out.println("\n\n=====================================================================");
            System.out.println("               STUDENT ACTIVITY MANAGEMENT SYSTEM MENU            ");
            System.out.println("=====================================================================");
            System.out.println(" |      1. Check available seats                                 | ");
            System.out.println(" |      2. Register student (with ID)                            | ");
            System.out.println(" |      3. Delete student                                        | ");
            System.out.println(" |      4. Find student (with student ID)                        | ");
            System.out.println(" |      5. Store student details into a file                     | ");
            System.out.println(" |      6. Load student details from the file to the system      | ");
            System.out.println(" |      7. View the list of students based on their names        | ");
            System.out.println(" |      8. Exit                                                  | ");
            System.out.println(" |      9. Add Student name and Marks                            | ");
            System.out.println(" |      10.Summary of registrations                              | ");
            System.out.println(" |      11.Student Report Summary                                | ");
            System.out.println("=====================================================================");

             choice = ValidationUtil.validateAndReturnUserChoice();

            switch (choice) {
                case 1:
                    System.out.println(" 1. Check available seats");
                    StudentManagementUtil.checkAvailableSeats(studentNameArray);
                    break;
                case 2:
                    System.out.println(" 2. Register student (with ID)");
                    StudentManagementUtil.studentRegistration(studentNameArray);
                    break;
                case 3:
                    System.out.println(" 3. Delete student");
                    StudentManagementUtil.deleteStudent(studentNameArray );
                    break;
                case 4:
                    System.out.println(" 4. Find student (with student ID)");
                    StudentManagementUtil.findStudent(studentNameArray);
                    break;
                case 5:
                    System.out.println(" 5. Store student details into a file");
                    try {
                        StudentManagementUtil.saveStudentDetails(studentNameArray);
                        System.out.println("Student details saved successfully!");
                    } catch (IOException e) {
                        System.out.println("Failed to save student data to file. Please check file permissions or try again later.");
                    }
                    break;
                case 6:
                    System.out.println(" 6. Load student details from the file to the system");
                    studentNameArray = StudentManagementUtil.loadStudentDetails();
                case 7:
                    System.out.println(" 7. View the list of students based on their names");
                    StudentManagementUtil.listOfStudentsView(studentNameArray);
                    break;
                case 8:
                    System.out.println("8. Exit");
                    break;
                case 9:
                    System.out.println("Add Student name and Marks");
                    StudentManagementUtil.addStudentDetails(studentNameArray);
                    break;
                case 10:
                    System.out.println("Summary of registrations");
                    StudentManagementUtil.totalStudent( studentNameArray);
                    StudentManagementUtil.StudentPassCount(studentNameArray);
                    break;
                case 11:
                    System.out.println(" Student Report Summary");
                    StudentManagementUtil.studentReport( studentNameArray);
                    break;
                default:
                    System.out.println("Invalid choice Enter a valid choice");
            }
        }

    }
}




