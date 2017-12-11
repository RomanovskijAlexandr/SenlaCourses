package handlers.csv;

import entities.Client;
import entities.Opportunity;
import entities.Room;
import entities.RoomHistory;
import org.apache.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

public class CsvWriter {
    private static final Logger log = Logger.getLogger(CsvWriter.class.getName());

    public void writeClients(List<Client> clients, String path){
        try(BufferedWriter csvWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path)))) {
            csvWriter.write("ID,Name\n");
            for (Client client:clients) {
                csvWriter.write(client.getStringForPrintInFile());
                csvWriter.write("\n");
            }
        } catch (Exception e) {
            log.info(e);
        }
    }

    public void writeRooms(List<Room> rooms, String path){
        try(BufferedWriter csvWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path)))) {
            csvWriter.write("ID,Number,Price,StatusFree,StatusRepair,Capacity,NumOfStar,DateOfEviction,DateOfSettle\n");
            for (Room room: rooms) {
                csvWriter.write(room.getStringForPrintInFile());
                csvWriter.write("\n");
            }
        } catch (Exception e) {
            log.info(e);
        }
    }

    public void writeRoomHistories(List<RoomHistory> roomHistories, String path){
        try(BufferedWriter csvWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path)))) {
            csvWriter.write("ID,ClientId,RoomID,DateOfEviction,DateOfSettle\n");
            for (RoomHistory roomHistory: roomHistories) {
                csvWriter.write(roomHistory.getStringForPrintInFile());
                csvWriter.write("\n");
            }
        } catch (Exception e) {
            log.info(e);
        }
    }

    public void writeOpportunities(List<Opportunity> opportunities, String path){
        try(BufferedWriter csvWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path)))) {
            csvWriter.write("ID,Name,Price\n");
            for (Opportunity opportunity: opportunities) {
                csvWriter.write(opportunity.getStringForPrintInFile());
                csvWriter.write("\n");
            }
        } catch (Exception e) {
            log.info(e);
        }
    }

}
