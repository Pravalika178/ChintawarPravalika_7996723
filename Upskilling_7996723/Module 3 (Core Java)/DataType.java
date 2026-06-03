import java.util.Scanner;
public class DataType
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter different data type values : ");
        int n=sc.nextInt();
        double d=sc.nextDouble();
        float f=sc.nextFloat();
        boolean b=sc.nextBoolean();
        char c=sc.next().charAt(0);
        System.out.println(n+" "+d+" "+f+" "+b+" "+c);
        sc.close();
    }
}
