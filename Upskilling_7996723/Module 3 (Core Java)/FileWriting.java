import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriting
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a string : ");
        String text=sc.nextLine();
        try
        {
            FileWriter fw=new FileWriter("output.txt");
            fw.write(text);
            fw.close();
            System.out.println("File Writing Successfully Completed!");
        }
        catch(IOException e)
        {
            System.out.println("Error Writing File");
        }
        sc.close();
    }
}
