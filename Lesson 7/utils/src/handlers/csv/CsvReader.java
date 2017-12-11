package handlers.csv;

import entities.Client;
import entities.Opportunity;
import entities.Room;
import entities.RoomHistory;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CsvReader {
    private static final Logger log = Logger.getLogger(CsvReader.class.getName());

    public List<Client> readClients(String path) {
        List<Client> clients = new ArrayList<>();
        try (BufferedReader csvReader = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
            String line;
            String csvHead = csvReader.readLine();
            while ((line = csvReader.readLine()) != null) {
                if (line.trim().length() == 0) {
                    continue;
                }
                String[] data = line.split(",");
                Client client = new Client();
                client.setId(Integer.parseInt(data[0]));
                client.setName(data[1]);
                clients.add(client);
            }
        } catch (Exception e) {
            log.info(e);
        }
        return clients;
    }

    public List<Room> readRooms(String path) {
        List<Room> rooms = new ArrayList<>();
        try (BufferedReader csvReader = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
            String line;
            String csvHead = csvReader.readLine();
            while ((line = csvReader.readLine()) != null) {
                if (line.trim().length() == 0) {
                    continue;
                }
                String[] data = line.split(",");
                Room room = new Room();
                room.setId(Integer.parseInt(data[0]));
                room.setNumber(Integer.parseInt(data[1]));
                room.setPrice(Integer.parseInt(data[2]));
                room.setFree(Boolean.parseBoolean(data[3]));
                room.setRepair(Boolean.parseBoolean(data[4]));
                room.setCapacity(Integer.parseInt(data[5]));
                room.setNumOfStars(Integer.parseInt(data[6]));
                room.setDateEviction(parseDate(data[7], "yyyy-MM-dd"));
                room.setDateOfSettle(parseDate(data[8], "yyyy-MM-dd"));
                rooms.add(room);
            }
        } catch (Exception e) {
            log.info(e);
        }
        return rooms;
    }

    public List<Opportunity> readOpportunity(String path){
        List<Opportunity> opportunities = new ArrayList<>();
        try (BufferedReader csvReader = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
            String line;
            String csvHead = csvReader.readLine();
            while ((line = csvReader.readLine()) != null) {
                if (line.trim().length() == 0) {
                    continue;
                }
                String[] data = line.split(",");
                Opportunity opportunity = new Opportunity();
                opportunity.setId(Integer.parseInt(data[0]));
                opportunity.setName(data[1]);
                opportunity.setPrice(Integer.parseInt(data[2]));
                opportunities.add(opportunity);
            }
        } catch (Exception e) {
            log.info(e);
        }
        return opportunities;
    }

    public List<RoomHistory> readRoomHistories(String path){
        List<RoomHistory> roomHistories = new ArrayList<>();
        try (BufferedReader csvReader = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
            String line;
            String csvHead = csvReader.readLine();
            while ((line = csvReader.readLine()) != null) {
                if (line.trim().length() == 0) {
                    continue;
                }
                String[] data = line.split(",");
                RoomHistory roomHistory = new RoomHistory();
                roomHistory.setId(Integer.parseInt(data[0]));
                roomHistory.setRoomId(Integer.parseInt(data[1]));
                roomHistory.setClientId(Integer.parseInt(data[2]));
                roomHistory.setDateEviction(parseDate(data[3], "yyyy-MM-dd"));
                roomHistory.setDateOfSettle(parseDate(data[4], "yyyy-MM-dd"));
                roomHistories.add(roomHistory);
            }
        } catch (Exception e) {
            log.info(e);
        }
        return roomHistories;
    }

    public Date parseDate(String date, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        try {
            return formatter.parse(date);
        } catch (ParseException e) {
            log.info(e);
        }
        return null;
    }
}
