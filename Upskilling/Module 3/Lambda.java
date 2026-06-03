import java.util.*;
public class Lambda
{
    public static void main(String[] args)
    {
        List<String> names = new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of elements : ");
        int n=sc.nextInt();
        System.out.println("Enter string values : ");
        for(int i=0;i<n;i++)
        {
            names.add(sc.next());
        }
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
        System.out.println("Sorted List:");
        for(String name : names)
        {
            System.out.println(name);
        }
    }
}