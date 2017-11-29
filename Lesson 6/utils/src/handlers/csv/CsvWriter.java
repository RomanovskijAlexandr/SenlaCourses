package handlers.csv;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import entities.Entity;
import handlers.serialize.Reader;
import org.apache.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;


public class CsvWriter {

    private static final Logger log = Logger.getLogger(Reader.class.getName());

    public void writeEntitiesCSV(List<? extends Entity> entities, String path) throws IOException {
        Writer writer = null;
        StatefulBeanToCsv beanToCsv = null;
        try {
            writer = new FileWriter(path);
            beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
            beanToCsv.write(entities);
            writer.close();
        } catch (IOException e) {
            log.info(e);
        } catch (CsvRequiredFieldEmptyException e) {
            log.info(e);
        } catch (CsvDataTypeMismatchException e) {
            log.info(e);
        }finally {
            writer.close();
        }

    }
}
