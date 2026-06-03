import java.util.Scanner;
class InvalidAgeException extends Exception
{
    InvalidAgeException()
    {
        super("Invalid Age for License");
    }
}
public class CustomException
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your age : ");
        int n = sc.nextInt();

        try
        {
            if(n >= 18)
            {
                System.out.println("Eligible");
            }
            else
            {
                throw new InvalidAgeException();
            }
        }
        catch(InvalidAgeException e)
        {
            System.out.println(e.getMessage());
        }
        sc.close();
    }
}