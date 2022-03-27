import java.io.*;
import java.nio.charset.StandardCharsets;

public class ByteAdapter implements WriteStringToBytes{

    private final OutputStreamWriter streamWriter;

    public ByteAdapter(OutputStream outputStream) {
        this.streamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
    }

    @Override
    public void writeString(String[] strings) throws IOException {
        for(String str : strings){
            this.streamWriter.write(str);
        }
        this.streamWriter.flush();
    }
}
