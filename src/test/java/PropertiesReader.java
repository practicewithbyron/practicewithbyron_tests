import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    public final Properties properties = new Properties();
    private InputStream input = null;

    public PropertiesReader(){
        try {
            input = getClass().getClassLoader().getResourceAsStream("config.properties");
            properties.load(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
