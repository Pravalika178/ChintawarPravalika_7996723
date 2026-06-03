import java.util.Scanner;

public class PalindromeString
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string : ");
        String s = sc.nextLine();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(int i = 0; i < s.length(); i++)
        {
            if(Character.isLetterOrDigit(s.charAt(i)))
            {
                sb1.append(s.charAt(i));
            }
        }
        for(int i = s.length() - 1; i >= 0; i--)
        {
            if(Character.isLetterOrDigit(s.charAt(i)))
            {
                sb2.append(s.charAt(i));
            }
        }
        String s1 = sb1.toString();
        String s2 = sb2.toString();
        System.out.println(s1.equalsIgnoreCase(s2));
        sc.close();
    }
}