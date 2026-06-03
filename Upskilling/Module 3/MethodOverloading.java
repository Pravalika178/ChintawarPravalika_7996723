public class MethodOverloading
{
    static int add(int a,int b)
    {
        return a+b;
    }
    static double add(double a,double b)
    {
        return a+b;
    }
    static float add(float a,float b)
    {
        return a+b;
    }
    public static void main(String[] args)
    {
        System.out.println(add(3,9));
        System.out.println(add(2.9,4.5));
        System.out.println(add(54.45094405,24.5094));
    }
}
