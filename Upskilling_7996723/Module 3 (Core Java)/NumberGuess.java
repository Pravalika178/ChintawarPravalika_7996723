import java.util.Scanner;

public class NumberGuess
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n = (int)(Math.random() * 100) + 1;
        System.out.println("Guess the number : ");
        int result=sc.nextInt();
        while(n!=result)
        {
            if(result>n)
            {
                System.out.println("Too high, try guessing a lower number : ");
            }
            else
            {
                System.out.println("Too low, try guessing a higher number : ");
            }
            result=sc.nextInt();
        }
        if(n==result)
        {
            System.out.println("Right Guess");
        }
        sc.close();
    }
}
