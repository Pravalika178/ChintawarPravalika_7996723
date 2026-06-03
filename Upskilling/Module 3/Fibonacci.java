import java.util.Scanner;

public class Fibonacci
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of terms : ");
        int n=sc.nextInt();
        System.out.println("Fibonacci Series : ");
        int first=0;
        int second=1;
        for(int i=0;i<=n;i++)
        {
            System.out.print(first+" ");
            int next=first+second;
            first=second;
            second=next;
        }
        sc.close();
    }
}
