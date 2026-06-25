public class OCPExample {
    public static void main(String[] args) {
        AddToCart cart=new AddToCart();
        cart.addItemTocart();
        Wishlist list=new Wishlist();
        list.addItemToWishlist();
        BuyNow buy=new BuyNow();
        buy.buyNow();
    }
}
class AddToCart {
    void addItemTocart(){
        System.out.println("Item successfully added to cart!");
    }
}
class Wishlist {
    void addItemToWishlist(){
        System.out.println("Item successfully added to wishlist");
    }
}
class BuyNow {
    void buyNow(){
        System.out.println("Proceed to payment");
    }
}
//new method for online shopping sites
class BuyLater {
    void buyLater(){
        System.out.println("Don't worry you can buy it whenever you want, Item successfully added to BuyLater");
    }
}
/* 
public class OCPExample {

    public static void main(String[] args) {

        ShoppingAction action1 = new AddToCart();
        action1.execute();

        ShoppingAction action2 = new Wishlist();
        action2.execute();

        ShoppingAction action3 = new BuyNow();
        action3.execute();

        // newly added feature
        ShoppingAction action4 = new BuyLater();
        action4.execute();
    }
}

// common interface
interface ShoppingAction {

    void execute();
}

// add to cart feature
class AddToCart implements ShoppingAction {

    public void execute() {
        System.out.println("Item successfully added to cart!");
    }
}

// wishlist feature
class Wishlist implements ShoppingAction {

    public void execute() {
        System.out.println("Item successfully added to wishlist!");
    }
}

// buy now feature
class BuyNow implements ShoppingAction {

    public void execute() {
        System.out.println("Proceeding to payment...");
    }
}

// new feature added later
class BuyLater implements ShoppingAction {

    public void execute() {
        System.out.println("Item added to BuyLater!");
    }
}
*/
