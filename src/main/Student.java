package main;

import java.util.Scanner;

public class Student 
{
    String newline = System.lineSeparator();

    public static void Studentmain()
    {
        System.out.println("****Welcome to the STUDENT PORTAL****");
        Scanner scan = new Scanner(System.in);
        String newline = System.lineSeparator();
        System.out.println("Available Options As Student: " + newline +"1. Take Book" + newline + "2. Return Book" + newline + "3. Check Account Details" + newline + "4. Change Password" + newline + "5. Membership Status");
        System.out.println("Enter Choice: ");

        scan.close();
    }
}
