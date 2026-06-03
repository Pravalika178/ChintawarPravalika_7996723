class Animal
{
    void makeSound()
    {
        System.out.println("Animal makes sound...");
    }
}
class Dog extends Animal
{
    @Override
    void makeSound()
    {
        System.out.println("Dog barks...");
    }
}
public class Inheritance
{
    public static void main(String[] args)
    {
        Dog d=new Dog();
        d.makeSound();
    }
}
