package main;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        String comma =",";   
        String newline = System.lineSeparator();
        Scanner sc = new Scanner(System.in);
        System.out.println("Registering/Adding a New STAFF. Enter Details: ");

        System.out.println("Enter Name of Staff: ");
        String Name=sc.nextLine();
        System.out.println("Entered Name: " + Name);

        System.out.println("Enter Desired ID for Staff: ");
        int ID=sc.nextInt();
        String IDmain = String.valueOf(ID);
        IDmain=IDmain.trim();
        System.out.println("Entered ID: " + IDmain);
        
        System.out.println("Enter User Name For Staff: ");
        String Uname=sc.nextLine() + sc.nextLine();
        System.out.println("Entered Username: " + Uname);
         
        System.out.println("Enter Password: ");
        String Pass=sc.nextLine();
        System.out.println("Entered Password: " + Pass);
         
        System.out.println("Confirm Password: ");
        String ConPass=sc.nextLine();
        Uname=Uname.trim();
        Pass=Pass.trim();
        ConPass=ConPass.trim();
        Name=Name.trim();

        String x= Uname;
        if(Pass.equals(ConPass))
        {
             
              File f = new File("StaffDets.txt");
              File f2 = new File("staffid.txt");
              Scanner content = new Scanner(f);
              Scanner content2 = new Scanner(f2);
              
              while (content2.hasNextLine()) 
              {
                String data2 = content2.nextLine();
                if (data2.equals(IDmain)) 
                {
                    System.out.println("*****You are already Registered or the ID is already taken*****");
                    System.out.println("***You can either Register with new details or Login with other Details***");

                    System.out.println("1. Registration For Staff ");
                    System.out.println("2. Login For Staff ");
                    System.out.println("3. Goto Admin Home Page");
                    System.out.println("Enter Your Choice: ");
                    int choiceherenow=sc.nextInt();
                    if(choiceherenow==1)
                    {
                        addstaff();
                        System.out.println("Redirecting to Staff Registration....");
                    }
                    else if(choiceherenow==2)
                    {
                        LMS.staffLogin();
                        System.out.println("Redirecting to Staff Login......");
                    }
                    else if (choiceherenow==3)
                    {
                        Adminmain();
                        System.out.println("Redirecting to Admin Login.......");
                    }
                    else
                    {
                        System.out.println("Choose Proper Option");
                    }
                    break;
                }
              }
              
              int flag2=0;
              while (content.hasNextLine()) 
              {
                String data = content.nextLine();
                String[] data1 = data.split(",");
                List<String> datamain = new ArrayList<>(Arrays.asList(data1));
                if(datamain.contains(x))
                {
                    System.out.println("*****You Are Already Registered*****");
                    System.out.println("***You can either Register with new details or Login With Current Details***");
                    flag2=1;
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
                if(flag2==0)
                {
                    try {
                        BufferedWriter out = new BufferedWriter(new FileWriter("StaffDets.txt", true)); 
                        out.write(IDmain +comma+ Name + comma + Uname+comma+Pass+"\n");
                        out.close();

                        BufferedWriter outhere = new BufferedWriter(new FileWriter("staffdetslogin.txt", true)); 
                        outhere.write(Uname+" "+Pass+"\n");
                        outhere.close();

                        BufferedWriter outnow = new BufferedWriter(new FileWriter("staffid.txt", true)); 
                        outnow.write(IDmain+"\n");
                        outnow.close();
                    }
                    catch (IOException e) {
                        System.out.println("exception occoured" + e);
                    }
                     
                    System.out.println("***Successfully Registered***");
                    System.out.println(">>>Where Do you wanna go next?" + newline + "Enter 1 To Login To Staff" + newline + "Enter 2 To Goto Admin Home Page" + newline + "Enter 3 To Goto Staff Registration");
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

                    else if(choice==3)
                    {
                        System.out.println("Redirecting To Staff Registration.....");
                        addstaff();
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

                System.out.println("Where Do You wanna go next?"  +newline + "1. Make New Announcement" + newline +"2. Go To Admin Portal");
                int choice = scan1.nextInt();

                if (choice==1)
                {
                    System.out.println("Redirecting To Announcements.....");
                    announcements();
                }

                else if (choice==2)
                {
                    System.out.println("Redirecting to Admin Portal...");
                    Adminmain();
                }
                else
                {
                    System.out.println("Invalid Option selected. Redirecting to Admin Portal.....");
                    Adminmain();
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

