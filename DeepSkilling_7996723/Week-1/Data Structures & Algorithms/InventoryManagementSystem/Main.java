public class Main
{
    public static void main(String[] args)
    {
        InventoryManager manager = new InventoryManager();
        Product p1 = new Product(101,"Laptop",20,50000);
        Product p2 = new Product(102,"Mouse",100,500);
        manager.addProduct(p1);
        manager.addProduct(p2);
        manager.displayProduct(101);
        manager.updateProduct(101,"Gaming Laptop",15,65000);
        manager.displayProduct(101);
        manager.deleteProduct(102);
    }
}