import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
public class FileReading
{
    public static void main(String[] args)
    {
        try
        {
            FileReader fr=new FileReader("output.txt");
            BufferedReader br=new BufferedReader(fr);
            String line;
            while((line=br.readLine())!=null)
            {
                System.out.println(line);
            }
            br.close();
        }
        catch(IOException e)
        {
            System.out.println("Error Readinng the File.");
        }
    }
}
