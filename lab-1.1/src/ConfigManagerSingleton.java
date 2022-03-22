import java.io.*;
import java.util.Properties;

public class ConfigManagerSingleton {

    private static ConfigManagerSingleton configManagerSingleton;
    private final Properties properties;

    private ConfigManagerSingleton(String path) throws IOException {
        properties = new Properties();
        properties.load(new FileReader(path));
    }

    public synchronized static ConfigManagerSingleton getInstance() throws IOException{
        if(configManagerSingleton == null){
            configManagerSingleton = new ConfigManagerSingleton("lab-1.1/src/config.properties");
        }
        return configManagerSingleton;
    }

    public Properties getProperties() {
        return properties;
    }
}
