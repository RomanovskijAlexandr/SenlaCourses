package reader;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    private Properties properties;
    private InputStream inputStream;

    private static final Logger log = Logger.getLogger(PropertiesReader.class.getName());

    public PropertiesReader() {
        try {
            this.properties = new Properties();
            this.inputStream = new FileInputStream("hotel-properties/resources/hotel.properties");
        } catch (FileNotFoundException e) {
            log.info(e);
        }
    }

    public Properties getProperties() {
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            log.info(e);
        }
        return properties;
    }
}
