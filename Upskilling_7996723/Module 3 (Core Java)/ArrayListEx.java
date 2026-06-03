import java.util.Scanner;
import java.util.ArrayList;
public class ArrayListEx
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        ArrayList<String> list=new ArrayList<>();
        System.out.println("Enter number of students : ");
        int n=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter "+(i+1)+" Student Name : ");
            list.add(sc.next());
        }
        String[] arr=new String[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=list.get(i);
        }
        System.out.print("Student Details : ");
        for(int i=0;i<n;i++)
        {
            System.out.print("\n"+arr[i]);
        }
        sc.close();
    }
}
