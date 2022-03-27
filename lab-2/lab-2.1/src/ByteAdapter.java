import java.io.*;
import java.nio.charset.StandardCharsets;

public class ByteAdapter implements WriteStringToBytes{

    private final OutputStream outputStream;

    public ByteAdapter(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void writeString(String[] strings) throws IOException {
        for(String str : strings){
            this.outputStream.write(str.getBytes(StandardCharsets.UTF_8));
        }
        this.outputStream.flush();
    }
}
