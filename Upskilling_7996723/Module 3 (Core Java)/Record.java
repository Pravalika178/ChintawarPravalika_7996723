import java.util.*;
record Person(String name, int age) {}
public class Record
{
    public static void main(String[] args)
    {
        Person p1 = new Person("Rahul", 22);
        Person p2 = new Person("Priya", 17);
        System.out.println("Individual Records:");
        System.out.println(p1);
        System.out.println(p2);
        List<Person> people = Arrays.asList(
                new Person("Rahul", 22),
                new Person("Priya", 17),
                new Person("Amit", 25),
                new Person("Neha", 19)
        );
        System.out.println("\nPeople aged 18 or above:");
        people.stream().filter(p -> p.age() >= 18).forEach(System.out::println);
    }
}