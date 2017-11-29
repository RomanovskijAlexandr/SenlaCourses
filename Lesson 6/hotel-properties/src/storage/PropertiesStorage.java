package storage;

import reader.PropertiesReader;

import java.io.IOException;
import java.util.Properties;

public class PropertiesStorage {
    private PropertiesReader propertyReader;
    private Properties properties;

    private static PropertiesStorage propertiesStorage;

    public static PropertiesStorage getInstance() throws IOException {
        if (propertiesStorage == null) {
            propertiesStorage = new PropertiesStorage();
        }
        return propertiesStorage;
    }

    private PropertiesStorage() throws IOException {
        this.propertyReader = new PropertiesReader();
        this.properties = this.propertyReader.getProperties();

    }


    public Properties getProperties() {
        return properties;
    }
}
