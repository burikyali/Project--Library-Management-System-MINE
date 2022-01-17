package main;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Admin 
{
    String newline = System.lineSeparator();
    
    public static void Adminmain() throws FileNotFoundException
    {
        System.out.println("****Welcome to the Admin PORTAL****");
        Scanner scan = new Scanner(System.in);
        String newline = System.lineSeparator();
        System.out.println("Available Options As Admin: " + newline +"1. Add New Staff" + newline + "2. Announcements" + newline + "3. Terminate a Membership");
        System.out.println("Enter Choice: ");
        int option = scan.nextInt();

        switch (option) 
        {
            case 1:
                addstaff();
                break;
            case 2:
                announcements();
                break;
            case 3:
                terminatemembership();
                break;
            default:
                System.out.println("Enter a valid choice.");
                Adminmain();
            break;
        }

        scan.close();
    }

    public static void addstaff() throws FileNotFoundException
    
    {   
        String newline = System.lineSeparator();
        Scanner sc = new Scanner(System.in);
        System.out.println("Registering/Adding a New STAFF. Enter Details: ");

        System.out.println("Enter Name of Staff: ");
        String Name=sc.nextLine();
        System.out.println(Name);

        System.out.println("Enter Desired ID for Staff: ");
        int ID=sc.nextInt();
        String IDmain = String.valueOf(ID);
        System.out.println(IDmain);
        
        System.out.println("Enter User Name For Staff: ");
        String Uname=sc.nextLine() + sc.nextLine();
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
        Name=Name.trim();

        String x= Uname+" "+Pass;
        if(Pass.equals(ConPass))
        {
             
              File f = new File("StaffDets.txt");
              File f2 = new File("staffid.txt");
              Scanner content = new Scanner(f);
              Scanner content2 = new Scanner(f2);
              
              while (content2.hasNextLine()) 
              {
                String data2 = content2.nextLine();
                
                
              }
              
               
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
                        addstaff();
                    }
                    else if(choice==2)
                    {
                        LMS.staffLogin();
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
                        BufferedWriter out = new BufferedWriter(new FileWriter("StaffDets.txt", true)); 
                        out.write(Uname+" "+Pass+ " " + Name +"\n");

                        out.close();

                        BufferedWriter outstaff = new BufferedWriter(new FileWriter("staffid.txt", true));
                        outstaff.write(IDmain);
                        outstaff.close();
                    }
                    catch (IOException e) {
                        System.out.println("exception occoured" + e);
                    }
                     
                    System.out.println("***Successfully Registered***");
                    System.out.println("Do you want to Login To Staff Page?" + newline + "Enter 1 To Login" + newline + "Enter 2 To Goto Admin Home Page");
                    System.out.println("Enter Choice: ");
                    int choice = sc.nextInt();
                    if (choice==1) 
                    {
                        System.out.println("Please login");
                        LMS.staffLogin();
                    }

                    else if (choice==2)
                    {
                        System.out.println("Redirecting To Admin Home Page.....");
                        Adminmain();
                    }
            content.close();
            content2.close();          
                }
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
                addstaff();
            }
            else if(choice==2)
            {
                LMS.staffLogin();
            }
            else
            {
                System.out.println("Choose Proper Option");
            }
        }
        sc.close();
        

    }

    public static void announcements() throws FileNotFoundException
    {   
        Scanner scan1 = new Scanner(System.in);
        String newline = System.lineSeparator();
        System.out.println("****Welcome to Announcements****" + newline + "Enter 1 To make a new announcement" + newline + "Enter 2 to view past announcements");
        System.out.println("Enter Choice: ");
        int choice1 = scan1.nextInt();

        if (choice1==1) 
        {
            try 
            {
                System.out.println("Enter the announcement: ");
                String announce = scan1.nextLine() + scan1.nextLine();

                BufferedWriter out = new BufferedWriter(new FileWriter("announcements.txt", true)); 
                out.write(announce + "\n");
                out.close();

                System.out.println("Announcement Successfully made!" + newline + "Where do you wanna go next? (Enter Number) " +newline+ "1. Admin Home" + newline + "2. Announcements(To View Announcements)" + newline + "3. HOME PAGE");
                System.out.println("Enter Choice: ");
                int choicehere = scan1.nextInt();
                switch (choicehere) 
                {
                    case 1:
                        Adminmain();
                        break;
                    case 2:
                        announcements();
                        break;
                    case 3:
                        LMS.loginmain();
                        break;
                }
            } 
            
            catch (IOException e) 
            {
                System.out.println("exception occured" +  e);
            }
        }
        
        else if (choice1==2)
        {
            try 
            {
                FileInputStream fis=new FileInputStream("announcements.txt");       
                Scanner sc=new Scanner(fis);
                
                System.out.println("****PAST ANNOUNCEMENTS****");
               
                while(sc.hasNextLine())  
                {  
                System.out.println(sc.nextLine());      
                }  
                sc.close();     
            } 
            
            catch (IOException e) 
            {
                System.out.println("error occurred" + e);
            }
        }
        scan1.close();
    }   
    
    public static void terminatemembership()
    {

    }
}

