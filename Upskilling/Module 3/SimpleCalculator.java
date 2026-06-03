import java.util.Scanner;
class SimpleCalculator
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter first number : ");
        double n1=sc.nextDouble();
        System.out.println("Enter second number : ");
        double n2=sc.nextDouble();
        System.out.println("Enter operator(+,-,*,/,%)");
        char op=sc.next().charAt(0);
        double result=0;
        switch(op)
        {
            case '+':
                result=n1+n2;
                break;
            case '-':
                result=n1-n2;
                break;
            case '*':
                result=n1*n2;
                break;
            case '/':
                result=n1/n2;
                break;
            case '%':
                result=n1%n2;
                break;
            default:
                System.out.println("Invalid operator");
        }
        System.out.println("Result = " + result);
        sc.close();
    }
}