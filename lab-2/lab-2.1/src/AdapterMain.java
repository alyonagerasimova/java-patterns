import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class AdapterMain {

    private static final String[] strings = new String[] {"6","1","3","2","Test","abc"};
    private static final String filePath = "out/test.b";

    public static void main(String[] args){
        try(var outputStream = new FileOutputStream(filePath)){
            WriteStringToBytes adapter = new ByteAdapter(outputStream);
            adapter.writeString(strings);

            var inputStream = new FileInputStream(filePath);
            while (inputStream.available() > 0) {
                System.out.println(inputStream.read());
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
