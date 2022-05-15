import java.io.*;

public class ByteAdapter implements ByteAdapterInterface {

    private final OutputStream outputStream;

    public ByteAdapter(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void writeString(String[] strings) throws IOException {
        for(String str : strings){
            this.outputStream.write(str.getBytes());
        }
        this.outputStream.flush();
    }
}
