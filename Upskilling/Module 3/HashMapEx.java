import java.util.Scanner;
import java.util.HashMap;
public class HashMapEx
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        HashMap<Integer,String> map=new HashMap<>();
        System.out.println("Enter number of students : ");
        int n=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++)
        {
            System.out.print("Enter student ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            map.put(id, name);
        }
        System.out.println("Enter ID to search : ");
        int search=sc.nextInt();
        String result=map.get(search);
        if(result!=null)
        {
            System.out.println("Student Name : "+result);
        }
        else
        {
            System.out.println("ID not found.");
        }
        sc.close();
    }
}
