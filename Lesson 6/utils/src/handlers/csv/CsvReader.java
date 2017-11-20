package handlers.csv;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import entities.Client;
import entities.Opportunity;
import entities.Room;
import handlers.serialize.Reader;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class CsvReader {

    private static final Logger log = Logger.getLogger(Reader.class.getName());

    public List<Client> readClientsCSV(String path) {
        List<Client> clients = null;
        try {
            CSVReader reader = new CSVReader(new FileReader(path));
            HeaderColumnNameMappingStrategy<Client> clientStrategy = new HeaderColumnNameMappingStrategy<Client>();
            CsvToBean<Client> csvToBean = new CsvToBean<Client>();
            clients = csvToBean.parse(clientStrategy, reader);
        } catch (FileNotFoundException e) {
            log.info(e);
        }
        return clients;
    }

    public List<Room> readRoomsCSV(String path) {
        List<Room> rooms = null;
        try {
            CSVReader reader = new CSVReader(new FileReader(path));
            HeaderColumnNameMappingStrategy<Room> roomStrategy = new HeaderColumnNameMappingStrategy<Room>();
            CsvToBean<Room> csvToBean = new CsvToBean<Room>();
            rooms = csvToBean.parse(roomStrategy, reader);
        } catch (FileNotFoundException e) {
            log.info(e);
        }
        return rooms;
    }

    public List<Opportunity> readOpportunityCSV(String path) {
        List<Opportunity> opportunities = null;
        try {
            CSVReader reader = new CSVReader(new FileReader(path));
            HeaderColumnNameMappingStrategy<Opportunity> opportunityStrategy = new HeaderColumnNameMappingStrategy<Opportunity>();
            CsvToBean<Opportunity> csvToBean = new CsvToBean<Opportunity>();
            opportunities = csvToBean.parse(opportunityStrategy, reader);
        } catch (FileNotFoundException e) {
            log.info(e);
        }
        return opportunities;
    }
}
