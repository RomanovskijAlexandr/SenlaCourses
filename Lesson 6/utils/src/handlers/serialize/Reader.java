package handlers.serialize;

import entities.Entity;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class Reader {

    private static final Logger log = Logger.getLogger(Reader.class.getName());

    public List<? extends Entity> readEntitiesFromFile(String path) {
        FileInputStream fis = null;
        List<? extends Entity> entities = null;
        try {
            fis = new FileInputStream(path);
            ObjectInputStream oin = new ObjectInputStream(fis);
            entities = (List<? extends Entity>) oin.readObject();
        } catch (Exception e) {
            log.info(e);
        }finally {
            try {
                fis.close();
            } catch (IOException e) {
                log.info(e);
            }
        }
        return entities;
    }
}
