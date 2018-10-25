import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InData {
    public String leitura (String rotulo) { //throws IOException
        System.out.println(rotulo);

        String ret = "";

        InputStreamReader tec = new InputStreamReader(System.in);
        BufferedReader buff = new BufferedReader(tec);

        try {
            ret = buff.readLine();
        } catch(IOException ioe) {
            System.out.println("\n\tErro RAM - JVM");
        }

        return ret;
    }
}