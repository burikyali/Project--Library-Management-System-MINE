package main;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LMS 
{
    
    public static void main(String[] args) throws FileNotFoundException 
    {   
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Your Institution's Name: ");
        String Institutionname = scan.nextLine();

        System.out.println("Welcome to the Library Management System");
        System.out.println( "******" + Institutionname + "********");

        loginmain();
        scan.close();
    }

    public static void loginmain() throws FileNotFoundException
    {   
        System.out.println("Welcome to the Library Management System");
        Scanner scan = new Scanner(System.in);
        String newline = System.lineSeparator();
        System.out.println("Choose (Enter Number)" + newline + "1. Login" + newline + "2. Registration");
        System.out.print("Enter Your Choice: ");
        int mainoption = scan.nextInt();
        if (mainoption==1) 
        {
            System.out.println("Login Option Selected. Redirecting to Login Page.....");
            System.out.println("Select Login (Enter Number): " + newline + "1. Admin" + newline + "2. Student" + newline + "3. Librarian" + newline + "4. Staff");
            System.out.print("Enter Your Choice: ");
            int loginoption = scan.nextInt();
            
            switch (loginoption) 
            {
                case 1:
                    System.out.println("Redirecting To Admin Login.... ");
                    AdminLogin();
                    break;
                case 2:
                    System.out.println("Redirecting To Student Login....");
                    Studentlogin();
                    break;
                case 3:
                    System.out.println("Redirecting To Librarian Login..... ");
                    LibrarianLogin();
                    break;
                case 4:
                    System.out.println("Redirecting To Staff Login..... ");
                    staffLogin();
                    break;
                default:
                    System.out.println("Please choose from the given options. INVALID CHOICE. Redirecting to Home Page");
                    loginmain();
            }       
        }
        else if (mainoption==2)
        {
            System.out.println("Registration option Selected. Redirecting to Registration Page....");
            System.out.println("Select Registration (Enter Number): " + newline + "1. Admin" + newline + "2. Student");
            System.out.print("Enter Your Choice: ");
            int regoption = scan.nextInt();

            switch (regoption) 
            {
                case 1:
                    System.out.println("Redirecting To Admin Registration.... ");
                    AdminRegistration();
                    break;
            
                case 2:
                    System.out.println("Redirecting To Student Registration....");
                    StudentRegistration();
                    break;
            }
        }
        else
        {
            System.out.println("Please Choose Either 1 OR 2. INVALID CHOICE. ");
            loginmain();
        }
        scan.close();  
    }
    
    public static void AdminRegistration() throws FileNotFoundException
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome To Admin Registration");
        System.out.println("Enter User Name For Registartion: ");
        String Uname=sc.nextLine();
        System.out.println(Uname);
         
        System.out.println("Enter Password: ");
        String Pass=sc.nextLine();
        System.out.println(Pass);
         
        System.out.println("Confirm Password: ");
        String ConPass=sc.nextLine();
        System.out.println(ConPass);
        Uname=Uname.trim();
        Pass=Pass.trim();
        ConPass=ConPass.trim();

        String x= Uname+" "+Pass;
        if(Pass.equals(ConPass))
        {
             
              File f = new File("AdminDets.txt");
              Scanner content = new Scanner(f);
               
               
              int flag=0;
              while (content.hasNextLine()) {
                String data = content.nextLine();
                if(data.equals(x))
                {
                    System.out.println("*****You Are Already Registered*****");
                    System.out.println("***You can either Register with new details or Login With Current Details***");
                    flag=1;
                    System.out.println("1. Registration. ");
                    System.out.println("2. Login. ");
                     
                    System.out.println("Enter your Choice");
                    int choice=sc.nextInt();
                    if(choice==1)
                    {
                        AdminRegistration();
                    }
                    else if(choice==2)
                    {
                        AdminLogin();
                    }
                    else
                    {
                        System.out.println("Choose Proper Option");
                    }
                    break;
                }
              }
                if(flag==0)
                {
                    try {
                        BufferedWriter out = new BufferedWriter(new FileWriter("AdminDets.txt", true)); 
                        out.write(Uname+" "+Pass+"\n");
                        out.close();
    
                    }
                    catch (IOException e) {
                        System.out.println("exception occoured" + e);
                    }
                     
                    System.out.println("Successfully Registered");
                    System.out.println("Please login");
                    AdminLogin();
                }
             content.close();
             
        }
        else
        {
            System.out.println("Passwords DON'T MATCH. TRY AGAIN.");
            System.out.println("1. Registration. ");
            System.out.println("2. Login. ");
             
            System.out.println("Enter your Choice");
            int choice=sc.nextInt();
            if(choice==1)
            {
                AdminRegistration();
            }
            else if(choice==2)
            {
                AdminLogin();
            }
            else
            {
                System.out.println("Choose Proper Option");
            }
        }
        sc.close();
    }

    public static void StudentRegistration() throws FileNotFoundException
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome To Student Registration");
        System.out.println("Enter User Name For Registration: ");
        String Uname=sc.nextLine();
        System.out.println(Uname);
         
        System.out.println("Enter Password: ");
        String Pass=sc.nextLine();
        System.out.println(Pass);
         
        System.out.println("Confirm Password: ");
        String ConPass=sc.nextLine();
        System.out.println(ConPass);
        Uname=Uname.trim();
        Pass=Pass.trim();
        ConPass=ConPass.trim();

        String x= Uname+" "+Pass;
        if(Pass.equals(ConPass))
        {
             
              File f = new File("StudentDets.txt");
              Scanner content = new Scanner(f);
               
               
              int flag=0;
              while (content.hasNextLine()) {
                String data = content.nextLine();
                if(data.equals(x))
                {
                    System.out.println("*****You Are Already Registered*****");
                    System.out.println("***You can either Register with new details or Login With Current Details***");
                    flag=1;
                    System.out.println("1. Registration. ");
                    System.out.println("2. Login. ");
                     
                    System.out.println("Enter your Choice");
                    int choice=sc.nextInt();
                    if(choice==1)
                    {
                        StudentRegistration();
                    }
                    else if(choice==2)
                    {
                        Studentlogin();
                    }
                    else
                    {
                        System.out.println("Choose Proper Option");
                    }
                    break;
                }
              }
                if(flag==0)
                {
                    try {
                        BufferedWriter out = new BufferedWriter(new FileWriter("StudentDets.txt", true)); 
                        out.write(Uname+" "+Pass+"\n");
                        out.close();
    
                    }
                    catch (IOException e) {
                        System.out.println("exception occoured" + e);
                    }
                     
                    System.out.println("Successfully Registered");
                    System.out.println("Please login");
                    Studentlogin();
                }
             content.close();
             
        }
        else
        {
            System.out.println("Passwords DON'T MATCH. TRY AGAIN.");
            System.out.println("1. Registration. ");
            System.out.println("2. Login. ");
             
            System.out.println("Enter your Choice: ");
            int choice=sc.nextInt();
            if(choice==1)
            {
                StudentRegistration();
            }
            else if(choice==2)
            {
                Studentlogin();
            }
            else
            {
                System.out.println("Choose Proper Option");
            }
        }
        sc.close();
    }

    public static void AdminLogin()
    {
        Scanner sc=new Scanner(System.in);
         
        System.out.println("Enter User Name: ");
        String Uname=sc.nextLine();
        System.out.println(Uname);
         
        System.out.println("Enter Password: ");
        String Pass=sc.nextLine();
        System.out.println(Pass);
        Uname=Uname.trim();
        Pass=Pass.trim();
        String x= Uname+" "+Pass;
         
         
        try {
             
              File f = new File("AdminDets.txt");
              Scanner content = new Scanner(f);
              int flag=0;
              while (content.hasNextLine()) {
                String data = content.nextLine();
                if(data.equals(x))
                {
                    System.out.println(">>Login Successful");
                    flag=1;
                    Admin.Adminmain();
                }
              }
                if(flag==0)
                {
                    System.out.println("****Login Failed****");
                    System.out.println(">>>Wrong Username Or Password<<<");
                    System.out.println("You can either Register for ADMIN with new details or try to login again");
                    System.out.println("1. Registration. ");
                    System.out.println("2. Login. ");
                     
                    System.out.println("Enter your Choice");
                    int choice=sc.nextInt();
                    if(choice==1)
                    {
                        AdminRegistration();
                    }
                    else if(choice==2)
                    {
                        AdminLogin();
                    }
                    else
                    {
                        System.out.println("Choose Proper Option");
                    }
                }
               
              content.close();
            } 
            catch (FileNotFoundException e) {
             
                 
              System.out.println("Error.");
              e.printStackTrace();
            }
         
        sc.close();
    }

    public static void Studentlogin()
    {
        Scanner sc=new Scanner(System.in);
         
        System.out.println("Enter User Name: ");
        String Uname=sc.nextLine();
        System.out.println(Uname);
         
        System.out.println("Enter Password: ");
        String Pass=sc.nextLine();
        System.out.println(Pass);
        Uname=Uname.trim();
        Pass=Pass.trim();
        String x= Uname+" "+Pass;
         
         
        try {
             
              File f = new File("StudentDets.txt");
              Scanner content = new Scanner(f);
              int flag=0;
              while (content.hasNextLine()) {
                String data = content.nextLine();
                if(data.equals(x))
                {
                    System.out.println(">>Login Successful");
                    flag=1;
                    Student.Studentmain();
                }
              }
                if(flag==0)
                {
                    System.out.println("****Login Failed****");
                    System.out.println(">>>Wrong Username Or Password<<<");
                    System.out.println("You can either Register for STUDENT with new details or try to login again");
                    System.out.println("1. Registration. ");
                    System.out.println("2. Login. ");
                     
                    System.out.println("Enter your Choice");
                    int choice=sc.nextInt();
                    if(choice==1)
                    {
                        StudentRegistration();
                    }
                    else if(choice==2)
                    {
                        Studentlogin();
                    }
                    else
                    {
                        System.out.println("Choose Proper Option");
                    }
                }
               
              content.close();
            } 
            catch (FileNotFoundException e) {
             
                 
              System.out.println("Error.");
              e.printStackTrace();
            }
         
        sc.close();
    }

    public static void LibrarianLogin()
    {
        String newline = System.lineSeparator();
        Scanner sc=new Scanner(System.in);
         
        System.out.println("Enter User Name: ");
        String Uname=sc.nextLine();
        System.out.println(Uname);
         
        System.out.println("Enter Password: ");
        String Pass=sc.nextLine();
        System.out.println(Pass);
        Uname=Uname.trim();
        Pass=Pass.trim();
        String x= Uname+" "+Pass;
         
         
        try {
             
              File f = new File("LibrarianDets.txt");
              Scanner content = new Scanner(f);
              int flag=0;
              while (content.hasNextLine()) {
                String data = content.nextLine();
                if(data.equals(x))
                {
                    System.out.println(">>Login Successful");
                    flag=1;
                    Librarian.libmain();
                }
              }
                if(flag==0)
                {
                    System.out.println("****Login Failed****");
                    System.out.println(">>>Wrong Username Or Password<<<");
                    System.out.println("You can try to login again.");
                    System.out.println("Do you want to login again? " + newline + "Enter 1 To Login Again" + newline + "Enter 2 To Goto Home Page");
                    System.out.println("Enter your Choice: ");
                    int choice=sc.nextInt();
                    if(choice==1)
                    {
                        LibrarianLogin();
                    }
                    else if(choice==2)
                    {   
                        System.out.println("Redirecting you to Home Page");
                        loginmain();
                    }
                    else
                    {
                        System.out.println("Choose Proper Option" + newline + "Redirecting to Librarian Login....");
                    }
                }
               
              content.close();
            } 
            catch (FileNotFoundException e) {
             
                 
              System.out.println("Error.");
              e.printStackTrace();
            }
         
        sc.close();
    }

    public static void staffLogin()
    {
        Scanner sc=new Scanner(System.in);
         
        System.out.println("Enter User Name: ");
        String Uname=sc.nextLine();
        System.out.println(Uname);
         
        System.out.println("Enter Password: ");
        String Pass=sc.nextLine();
        System.out.println(Pass);
        Uname=Uname.trim();
        Pass=Pass.trim();
        String x= Uname+" "+Pass;
         
         
        try {
             
              File f = new File("StaffDets.txt");
              Scanner content = new Scanner(f);
              int flag=0;
              while (content.hasNextLine()) {
                String data = content.nextLine();
                if(data.equals(x))
                {
                    System.out.println(">>Login Successful");
                    flag=1;
                    Staff.staffmain();
                }
              }
                if(flag==0)
                {
                    System.out.println("****Login Failed****");
                    System.out.println(">>>Wrong Username Or Password<<<");
                    System.out.println("You can either Register for Staff with new details or try to login again");
                    System.out.println("1. Registration. ");
                    System.out.println("2. Login. ");
                     
                    System.out.println("Enter your Choice");
                    int choice=sc.nextInt();
                    if(choice==1)
                    {
                        Admin.addstaff();
                    }
                    else if(choice==2)
                    {
                        staffLogin();
                    }
                    else
                    {
                        System.out.println("Choose Proper Option");
                    }
                }
               
              content.close();
            } 
            catch (FileNotFoundException e) {
             
                 
              System.out.println("Error.");
              e.printStackTrace();
            }
         
        sc.close();
    }
}   

