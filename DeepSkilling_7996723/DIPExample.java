interface Eater{
    void eat();
}
class Human implements Eater{
    public void eat(){
        System.out.println("Human Eats");
    }
}
class Animal implements Eater{
    public void eat(){
        System.out.println("Animal Eats");
    }
}
class FoodManager{
    Eater eat;
    FoodManager(Eater eat){
        this.eat=eat;
    }
    void serveFood(){
        eat.eat();
    }
}
public class DIPExample{
    public static void main(String[] args) {
        Eater human = new Human();
        FoodManager obj = new FoodManager(human);
        obj.serveFood();
    }
}