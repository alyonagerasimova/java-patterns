import java.io.*;
import java.util.Properties;

public class ConfigManager {

    private static ConfigManager configManager;
    private final Properties properties;

    private ConfigManager(String path) throws IOException {
        properties = new Properties();
        properties.load(new FileReader(path));
    }

    public synchronized static ConfigManager getInstance() throws IOException{
        if(configManager == null){
            configManager = new ConfigManager("lab-1.1/src/config.properties");
        }
        return configManager;
    }

    public Properties getProperties() {
        return properties;
    }
}
