package Helper;

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
            if (input != null) {
                properties.load(input);
                input.close();
            } else {
                // Handle the case where the input stream is null
                System.err.println("Error: Unable to load properties. config.properties not found.");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
