import java.lang.reflect.Method;

public class Reflection
{
    public static void main(String[] args)
    {
        try
        {
            // Load class dynamically
            Class<?> cls = Class.forName("Student");

            System.out.println("Class Name : " + cls.getName());

            // Get all methods
            Method[] methods = cls.getDeclaredMethods();

            System.out.println("\nMethods:");

            for(Method m : methods)
            {
                System.out.println(m.getName());
            }

            // Create object dynamically
            Object obj = cls.getDeclaredConstructor().newInstance();

            // Invoke display()
            Method displayMethod = cls.getMethod("display");
            displayMethod.invoke(obj);

            // Invoke greet(String)
            Method greetMethod = cls.getMethod("greet", String.class);
            greetMethod.invoke(obj, "Chint");

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}