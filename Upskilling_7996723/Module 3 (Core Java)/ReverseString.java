import java.util.Scanner;

public class ReverseString
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a string : ");
        String s=sc.nextLine();
        StringBuilder sb=new StringBuilder();
        for(int i=s.length()-1;i>=0;i--)
        {
            sb.append(s.charAt(i));
        }
        System.out.println("Reversed String is : "+sb);
        sc.close();
    }
}
