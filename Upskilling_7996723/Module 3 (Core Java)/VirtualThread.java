public class VirtualThread
{
    public static void main(String[] args)
    {
        long startTime = System.currentTimeMillis();

        for(int i = 1; i <= 100000; i++)
        {
            int threadNumber = i;

            Thread.startVirtualThread(() ->
            {
                System.out.println(
                        "Virtual Thread "
                        + threadNumber
                        + " running");
            });
        }

        long endTime = System.currentTimeMillis();

        System.out.println(
                "Time Taken: "
                + (endTime - startTime)
                + " ms");
    }
}