import java.util.*;
public class StreamAPI
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        ArrayList<Integer> list=new ArrayList<>();
        System.out.println("Enter size of list : ");
        int n=sc.nextInt();
        System.out.println("Enter elements of list : ");
        for(int i=0;i<n;i++)
        {
            list.add(sc.nextInt());
        }
        System.out.println("Even elements are : ");
        list.stream().filter(i -> i % 2 == 0).forEach(System.out::println);
    }
}
