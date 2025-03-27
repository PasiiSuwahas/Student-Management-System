package StudentManagemnt2;

import java.util.Scanner;

public class ValidationUtil {

// validate the User choice
    public static int validateAndReturnUserChoice() {
        int returnValue = 0;

        while (true) {

            Scanner input = new Scanner(System.in);
            System.out.println(" Enter your choice :");
            String choice = input.nextLine();
            try {
                returnValue = Integer.parseInt(choice);
                break;

            } catch (Exception e) {
                System.out.println("Please Enter a Valid Choice");

            }
        }
        return returnValue;
    }


public static boolean isValidString(String input) {
    if(input.isEmpty()){
        return false;
    }
    // Check each character in the string
    for (int i = 0; i < input.length(); i++) {
        char ch = input.charAt(i);
        if (!Character.isLetter(ch)) {
            return false; // Found a non-alphabetic character
        }
    }
    return true; // All characters are alphabetic
 }
//validate the student name
 public static String ValidateAndGetStudentName(){
        while(true){
            Scanner input=new Scanner(System.in);
            System.out.println("Enter Student Name:");
            String studentName=input.nextLine();
            if(isValidString(studentName)){
                return studentName;
            }else{
                System.out.println("Not a valid Name");
            }
        }
 }

    public static boolean isValidNumber(String input) {
        if (input.isEmpty() || input == null) {
            return false;
        }
        try {
            double doubleData = Double.parseDouble(input);
            return true;

        }catch (Exception e){
            return false;
        }
    }
    public static double ValidateAndGetStudentMark(String message){
        while(true){
            Scanner input=new Scanner(System.in);
            System.out.println(message);
            String studentMark = input.nextLine();
            if(isValidNumber(studentMark)){
                return Double.parseDouble(studentMark);
            }else{
                System.out.println("Not a valid Mark");
            }
        }
    }

    public static boolean isValidStudentID(String studentID) {
        if (studentID == null || studentID.length() != 8) {
            return false;
        }
        if (studentID.charAt(0) != 'w' && studentID.charAt(0) != 'W') {
            return false;
        }
        // Check other characters digits (2nd to 8th)
        for (int i = 1; i < studentID.length(); i++) {
            char ch = studentID.charAt(i);
            if (!Character.isDigit(ch)) {
                return false; // Not a digit
            }
        }
          return true;

    }
    public static String ValidateAndGetStudentID(){
        while(true){
            Scanner input=new Scanner(System.in);
            System.out.println("Enter the Student ID");
            String studentID = input.nextLine();
            if(isValidStudentID(studentID)){
                return studentID;
            }else{
                System.out.println("Not a valid Student ID");
            }
        }
    }
}

