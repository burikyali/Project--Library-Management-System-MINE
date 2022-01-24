package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class testmain 
{
    public static void main(String[] args) throws FileNotFoundException 
    {

        File studentid = new File("StudentDets.txt");
        Scanner content0 = new Scanner(studentid);

        String data = content0.nextLine();
        String[] data1 = data.split(",");

        for (String a : data1)
        System.out.println(a);

        content0.close();
    }    
}
