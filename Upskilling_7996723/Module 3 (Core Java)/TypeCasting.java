import java.util.Scanner;

public class TypeCasting {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a double value : ");
        double d=sc.nextDouble();
        System.out.println("Enter an integer value : ");
        int n=sc.nextInt();
        System.out.println((int)d);
        System.out.println((double)n);
        sc.close();
    }
}
