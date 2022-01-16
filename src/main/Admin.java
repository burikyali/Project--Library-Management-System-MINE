package main;

import java.util.Scanner;

public class Admin 
{
    static String Name;
    static int ID;
    static String  Username;

    String newline = System.lineSeparator();
    
    public static void Adminmain()
    {
        Scanner scan = new Scanner(System.in);
        String newline = System.lineSeparator();
        System.out.println("Available Options As Admin: " + newline +"1. Add New Staff" + newline + "2. Announcements" + newline + "3. Terminate a Membership");
        System.out.println("Enter Choice: ");
        int option1 = scan.nextInt();

        switch (option1) 
        {
            case 1:
                addstaff();
                break;
            case 2:
                announcements();
            case 3:
                terminatemembership();
            default:
                System.out.println("Enter a valid choice: ");
            break;
        }

        scan.close();
    }


    public static void addstaff()
    
    {

    }

    public static void announcements()
    {

    }

    public static void terminatemembership()
    {

    }
}

