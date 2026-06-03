import java.io.*;
import java.net.*;

public class Server
{
    public static void main(String[] args)
    {
        try
        {
            ServerSocket server =
                    new ServerSocket(5000);

            System.out.println(
                    "Server started...");

            Socket socket =
                    server.accept();

            System.out.println(
                    "Client connected!");

            BufferedReader in =
                    new BufferedReader(
                            new InputStreamReader(
                                    socket.getInputStream()));

            PrintWriter out =
                    new PrintWriter(
                            socket.getOutputStream(),
                            true);

            String msg =
                    in.readLine();

            System.out.println(
                    "Client: " + msg);

            out.println(
                    "Hello from Server");

            socket.close();
            server.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}