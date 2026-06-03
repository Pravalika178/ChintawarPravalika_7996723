import java.util.Scanner;

public class TryCatch
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter first number : ");
        int n1=sc.nextInt();
        System.out.println("Enter second number : ");
        int n2=sc.nextInt();
        try
        {
            int n=n1/n2;
            System.out.println("Division : "+n);
        }
        catch(ArithmeticException e)
        {
            System.out.println("Division by Zero cannot be done.");
        }
        sc.close();
    }
}
