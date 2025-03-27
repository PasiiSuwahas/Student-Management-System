package StudentManagemnt2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class StudentManagementUtil {



    //Student Registration method with ID and The Name
    public static void studentRegistration(Student [] studentArray){
        String studentID = ValidationUtil.ValidateAndGetStudentID();
        String studentName = ValidationUtil.ValidateAndGetStudentName();

        for(int index=0; index<studentArray.length; index++){
            if (studentArray[index]==null) {
                Student st = new Student(studentID,studentName);
                studentArray[index]=st;
                break;
            }
        }
    }





    //Checking Available seats method
    public static void checkAvailableSeats(Student [] studentNameArray ) {
        int count=0;
        for(int index=0; index<studentNameArray.length; index++){

            if (studentNameArray[index]==null) {
                count++;
            }
        }
        System.out.println("Available Seats Are:"+count);

    }





    //Delete Student method
    public static void deleteStudent(Student[] studentNameArray ) {
        String studentID = ValidationUtil.ValidateAndGetStudentID();
        int sizeOfIndex=-1;
        for(int index=0; index<studentNameArray.length; index++){
            if (studentNameArray[index]!= null && studentID.equals(studentNameArray[index].getStudentID()) ){
                sizeOfIndex=index;
                break;
            }
        }
        if (sizeOfIndex==-1) {
            System.out.println("Invalid Student ID");

        }else{
            //Shift the student to the previous index
            for(int indexShift=sizeOfIndex; indexShift<studentNameArray.length-1; indexShift++){
                if(studentNameArray[indexShift+1]!=null){
                    studentNameArray[indexShift]=studentNameArray[indexShift+1];
                }else{
                    studentNameArray[indexShift]=null;
                    break;
                }
            }
            studentNameArray[studentNameArray.length-1]=null;
            System.out.println("Deleted Successfully");

        }


    }






    //Find the Student With Student ID
    public static void findStudent(Student [] studentNameArray){
        String studentID = ValidationUtil.ValidateAndGetStudentID();
        for(int index=0; index<studentNameArray.length; index++){
            if (studentNameArray[index]!= null && studentID.equals(studentNameArray[index].getStudentID())){
                System.out.println("Student Name:"+studentNameArray[index].getStudentName());
                System.out.println("Student ID:"+studentNameArray[index].getStudentID());
            }
        }

    }






    //write To file
    public static void saveStudentDetails(Student[] studentNameArray) throws IOException {
        // File path
        String filePath = "students.txt";

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(filePath,false));

            // Write each student's details (ID, Name, Marks) to the file
            for (int i = 0; i < studentNameArray.length; i++) {
                Student student = studentNameArray[i];
                if (student == null) {
                    break;
                }
                writer.write(student.getStudentID() + "\n");
                writer.write((student.getStudentName() != null) || !student.getStudentName().isEmpty() ? student.getStudentName() + "\n" : "null\n");

                if (student.getMarks() != null) {
                    for (Module mark : student.getMarks()) {
                        writer.write(mark != null ? mark.mark + "\n" : "null\n");
                    }
                } else {
                    writer.write("null\n"); // Handle missing marks with a marker
                }
                if( studentNameArray[i+1] != null){
                    writer.write("--new-record--\n"); // Separate each student's record with a newline
                }
            }
        } finally {
            // Ensure proper resource closing
            if (writer != null) {
                writer.write("--EOD--"); // Handle missing marks with a marker
                writer.close();
            }
        }
    }

    public static Student[] loadStudentDetails() throws IOException {
        String filePath = "students.txt";
        BufferedReader reader = null;
        List<Student> students = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            while (line != null && !line.equals("--EOD--")) {
                String studentID = line;
                String studentName = reader.readLine();
                List<Module> marksList = new ArrayList<>();
                line = reader.readLine();
                boolean hasMarkData = false;
                while (line != null && !line.equals("null") && !line.equals("--new-record--")) {
                    hasMarkData = true;
                    double mark = Double.parseDouble(line);
                    marksList.add(new Module(mark));  // Assuming Module has a constructor that accepts an integer mark
                    line = reader.readLine();
                }

                Module[] marksArray = hasMarkData ? marksList.toArray(new Module[3]) : null ;
                Student student = new Student(studentID, studentName,marksArray);
                students.add(student);
                line = reader.readLine();
                if(!hasMarkData){
                    line = reader.readLine();
                }


            }
        } finally {
            if (reader != null) {
                reader.close();
            }
        }

        return students.toArray(new Student[100]);
    }











    // View Students According to their names and Sort the names using array list
    public static void listOfStudentsView(Student [] studentNameArray){
        ArrayList<String> studentN=new ArrayList<>();
        for(int i=0;i<studentNameArray.length;i++){
            if(studentNameArray[i]!= null){
                studentN.add(studentNameArray[i].getStudentName());
            }
        }
        Collections.sort(studentN);
        for(int i=0;i<studentN.size();i++){
            System.out.println(studentN.get(i));
        }


    }








    //Add Student personal Details method Optional
    public static void addStudentDetails(Student [] studentNameArray){
        String studentID = ValidationUtil.ValidateAndGetStudentID();
        for(int index=0;index<studentNameArray.length;index++){
            if(studentNameArray[index] !=null && studentID.equals(studentNameArray[index].getStudentID())){
                String studentName = ValidationUtil.ValidateAndGetStudentName();
                Student st=new Student(studentID,studentName);
                st.marks = new Module[3];
                studentNameArray[index]=st;

                double mark1 = ValidationUtil.ValidateAndGetStudentMark("Enter the Module 1 Mark");
                double mark2 = ValidationUtil.ValidateAndGetStudentMark("Enter the Module 2 Mark");
                double mark3 = ValidationUtil.ValidateAndGetStudentMark("Enter the Module 3 Mark");

                Module module1= new Module(mark1);
                Module module2= new Module(mark2);
                Module module3= new Module(mark3);

                st.marks[0]=module1;
                st.marks[1]=module2;
                st.marks[2]=module3;

                studentNameArray[index]=st;
                System.out.println(studentNameArray[index].getStudentName());
                System.out.println(studentNameArray[index].getMarks());
                System.out.println("Student Registration Successful");
                break;

            }
        }
    }








    //Total registered Students
    public static void totalStudent(Student[] studentNameArray){
        int totalStudents=0;
        for(int index=0;index<studentNameArray.length;index++){
            if(studentNameArray[index]!=null){
                totalStudents++;
            }
        }
        System.out.println("Total registrations:"+totalStudents);
    }







    //Students Pass Count According to each Module
    public static void StudentPassCount(Student[] studentNameArray) {
        int countStudentM1 = 0;
        int countStudentM2 = 0;
        int countStudentM3 = 0;
        for (int index = 0; index < studentNameArray.length; index++) {
            double totalMarksMOdule1;
            double totalMarksMOdule2;
            double totalMarksMOdule3;
            if (studentNameArray[index] != null && studentNameArray[index].marks != null) {
                totalMarksMOdule1 = studentNameArray[index].marks[0].mark;
                totalMarksMOdule2 = studentNameArray[index].marks[1].mark;
                totalMarksMOdule3 = studentNameArray[index].marks[2].mark;
                if (totalMarksMOdule1 > 40) {
                    countStudentM1++;
                }
                if (totalMarksMOdule2 > 40) {
                    countStudentM2++;
                }
                if (totalMarksMOdule3 > 40) {
                    countStudentM3++;


                }

            }
        }
        System.out.println("Module1 Pass Student Count:"+countStudentM1);
        System.out.println("Module2 Pass Student Count:"+countStudentM2);
        System.out.println("Module3 Pass Student Count:"+countStudentM3);
    }




    // Student Personal Report
    public static void studentReport(Student[] studentNameArray){
        for(int index=0;index<studentNameArray.length;index++){
            String StudentID;
            String StudentName;
            double module1Marks;
            double module2Marks;
            double module3Marks;
            double totalMarks;
            double average;
            String grade;

            if (studentNameArray[index] != null && studentNameArray[index].marks == null) {
                StudentID = studentNameArray[index].getStudentID();
                StudentName = studentNameArray[index].getStudentName();
                System.out.println("ONLY Register with id and the Name;");
                System.out.println("Student ID;"+StudentID);
                System.out.println("Student Name;"+StudentName);


            } else if (studentNameArray[index] != null && studentNameArray[index].marks != null) {
                StudentID = studentNameArray[index].getStudentID();
                StudentName =studentNameArray[index].getStudentName();
                module1Marks=studentNameArray[index].marks[0].mark;
                module2Marks=studentNameArray[index].marks[1].mark;
                module3Marks= studentNameArray[index].marks[2].mark;
                totalMarks=studentNameArray[index].marks[0].mark+studentNameArray[index].marks[1].mark+studentNameArray[index].marks[2].mark;
                average=(totalMarks/3.00);
                if(average<=100&& average>=80){
                    grade="Distinction";

                }
                else if(average>=70){
                    grade="Merit";

                }
                else if(average>=40){
                    grade="Pass";

                }
                else{
                    grade="Fail";

                }

                System.out.println("Student ID;"+StudentID);
                System.out.println("Student Name;"+StudentName);
                System.out.println("Student Module Marks;"+module1Marks);
                System.out.println("Student Module Marks;"+module2Marks);
                System.out.println("Student Module3 Marks;"+module3Marks);
                System.out.println("Student Total;"+totalMarks);
                System.out.println("Student Average;"+average);
                System.out.println("Student Grade;"+grade);



            }
        }

    }
}

