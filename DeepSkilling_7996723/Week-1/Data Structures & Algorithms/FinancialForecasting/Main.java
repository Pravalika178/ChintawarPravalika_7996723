public class Main
{
    public static void main(String[] args)
    {
        double presentValue = 10000;
        double growthRate = 0.10; // 10%
        int years = 5;
        double futureValue = FinancialForecast.predictFutureValue(presentValue,growthRate,years);
        System.out.println("Present Value : Rs" +presentValue);
        System.out.println("Growth Rate   : " +(growthRate * 100) + "%");
        System.out.println("Years         : " + years);
        System.out.printf("Predicted Future Value : Rs.%.2f%n",futureValue);
    }
}