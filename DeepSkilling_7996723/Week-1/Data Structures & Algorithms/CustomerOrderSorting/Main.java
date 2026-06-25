public class Main
{
    public static void main(String[] args)
    {
        Order[] orders1 =
        {
            new Order(101, "Rahul", 2500),
            new Order(102, "Priya", 1200),
            new Order(103, "Amit", 5000),
            new Order(104, "Sneha", 3200),
            new Order(105, "Kiran", 1800)
        };
        Order[] orders2 =
        {
            new Order(101, "Rahul", 2500),
            new Order(102, "Priya", 1200),
            new Order(103, "Amit", 5000),
            new Order(104, "Sneha", 3200),
            new Order(105, "Kiran", 1800)
        };
        System.out.println("=== Bubble Sort ===");
        SortingOperations.bubbleSort(orders1);
        SortingOperations.displayOrders(orders1);
        System.out.println();
        System.out.println("=== Quick Sort ===");
        SortingOperations.quickSort(orders2,0,orders2.length - 1);
        SortingOperations.displayOrders(orders2);
    }
}