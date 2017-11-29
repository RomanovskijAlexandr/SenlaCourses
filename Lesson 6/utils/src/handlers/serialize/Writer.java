package handlers.serialize;

import entities.Entity;
import org.apache.log4j.Logger;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class Writer {

    private static final Logger log = Logger.getLogger(Writer.class.getName());

    public void writeEntities(List<? extends Entity> entities, String path) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(entities);
        } catch (Exception e) {
            log.info(e);
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                log.info(e);
            }
        }

    }
}
