public class ObserverTest
{
    public static void main(String[] args)
    {
        StockMarket stockMarket = new StockMarket();
        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();
        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);
        System.out.println("Stock Price Changed:");
        stockMarket.setStock("TCS", 3500.50);
    }
}