public class Main
{
    public static void main(String[] args)
    {
        Book[] books =
        {
            new Book(101, "C++", "Bjarne Stroustrup"),
            new Book(102, "DBMS", "Korth"),
            new Book(103, "Java", "James Gosling"),
            new Book(104, "Python", "Guido van Rossum")
        };
        System.out.println("=== Linear Search ===");
        Book result1 = LibrarySearch.linearSearch(books,"Java");
        if (result1 != null)
        {
            System.out.println(result1);
        }
        else
        {
            System.out.println("Book not found");
        }
        System.out.println();
        System.out.println("=== Binary Search ===");
        Book result2 = LibrarySearch.binarySearch(books,"Java");
        if (result2 != null)
        {
            System.out.println(result2);
        }
        else
        {
            System.out.println("Book not found");
        }
    }
}