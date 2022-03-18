import java.io.*;

public class Singleton {
    public static void main(String[] args) throws IOException {
        var properties = ConfigManager.getInstance().getProperties();
        System.out.println(properties.getProperty("test"));
    }
}
