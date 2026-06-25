public class ProxyTest
{
    public static void main(String[] args)
    {
        Image image = new ProxyImage("sample.jpg");
        System.out.println("Image created.");
        System.out.println("\nFirst display:");
        image.display();
        System.out.println("\nSecond display:");
        image.display();
    }
}