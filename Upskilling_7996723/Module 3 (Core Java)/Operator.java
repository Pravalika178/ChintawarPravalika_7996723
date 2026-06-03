import java.util.Scanner;

public class Operator
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int result1 = 10 + 5 * 2;
        int result2 = (10 + 5) * 2;
        int result3 = 20 / 5 + 3 * 4;
        int result4 = 50 - 10 + 2 * 5;
        System.out.println("Result1 : "+result1);
        System.out.println("Here the precedence rule is : Multiplication happens before Addition");
        System.out.println("Result2 : "+result2);
        System.out.println("Here the precedence rule is : Parentheses runs first");
        System.out.println("Result3 : "+result3);
        System.out.println("Here the precedence rule is : Multiplication & Division happens before Addition");
        System.out.println("Result4 : "+result4);
        System.out.println("Here the precedence rule is : Multiplication happens before Addition & Subtraction");
        sc.close();
    }
}
