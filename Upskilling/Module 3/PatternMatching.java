public class PatternMatching
{
    static void checkType(Object obj)
    {
        switch(obj)
        {
            case Integer i ->
                System.out.println("Integer : " + i);
            case String s ->
                System.out.println("String : " + s);
            case Double d ->
                System.out.println("Double : " + d);
            case Boolean b ->
                System.out.println("Boolean : "+ b);
            default ->
                System.out.println("Unknown Type");
        }
    }
    public static void main(String[] args)
    {
        checkType(73475);
        checkType("hkdfvjvhdf");
        checkType(58678.86578);
        checkType(true);
    }
}