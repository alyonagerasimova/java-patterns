import java.io.*;
import java.nio.charset.StandardCharsets;

public class AdapterMain {

    private static final String[] strings = new String[] {"1","2","3","4","Test","abc"};
    private static final String filePath = "out/test.b";

    public static void main(String[] args){
        try(OutputStream outputStream = new FileOutputStream(filePath)){
            ByteAdapterInterface adapter = new ByteAdapter(outputStream);
            adapter.writeString(strings);

            // TEST
            var inputStream = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8));
            while (inputStream.ready()) {
                System.out.println(inputStream.readLine());
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
