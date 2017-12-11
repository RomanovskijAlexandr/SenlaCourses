package handlers;

import com.danco.training.TextFileWorker;
import entities.*;
import paths.FilePath;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static repository.ClientRepository.lastIdClient;
import static repository.OpportunityRepository.lastIdOpportunities;
import static repository.RoomRepository.lastIdRoom;

public class TextHandler {
    private StringHandler stringHandler = new StringHandler();

    private TextFileWorker textFileWorker;

    public List<Client> getClients(String path) {
        if (path == null)
            path = FilePath.clientPath;
        List<Client> clients = new ArrayList<>();
        Boolean flag = new File(path).exists();
        if (new File(path).exists()) {
            String[] objects = new TextFileWorker(path).readFromFile();
            for (int i = 0; i < objects.length; i++) {
                Client client = stringHandler.getClientFromString(objects[i]);
                client.setId(lastIdClient);
                lastIdClient++;
                clients.add(i, client);
            }
            return clients;
        } else return clients = null;
    }

    public List<Opportunity> getOpportunities(String path) {
        if (path == null)
            path = FilePath.opportunityPath;
        List<Opportunity> opportunities = new ArrayList<>();
        if (new File(path).exists()) {
            String[] objects = new TextFileWorker(path).readFromFile();
            for (int i = 0; i < objects.length; i++) {
                Opportunity opportunity = stringHandler.getOpportunityFromString(objects[i]);
                opportunity.setId(lastIdOpportunities);
                lastIdOpportunities++;
                opportunities.add(i, opportunity);
            }
            return opportunities;
        } else return opportunities = null;
    }

    public List<Room> getRooms(String path) {
        if (path == null)
            path = FilePath.roomPath;
        List<Room> rooms = new ArrayList<>();
        if (new File(path).exists()) {
            String[] objects = new TextFileWorker(path).readFromFile();
            for (int i = 0; i < objects.length; i++) {
                Room room = stringHandler.getRoomFromString(objects[i]);
                room.setId(room.generateId(lastIdRoom));
                lastIdRoom++;
                rooms.add(i, room);
            }
            return rooms;
        } else return rooms = null;
    }

    public List<RoomHistory> getRoomHistories(String path) {
        if (path == null)
            path = FilePath.roomHistoryPath;
        List<RoomHistory> roomHistories = new ArrayList<>();
        if (new File(path).exists()) {
            String[] objects = new TextFileWorker(path).readFromFile();
            for (int i = 0; i < objects.length; i++) {
                roomHistories.add(i, stringHandler.getRoomHistoryFromString(objects[i]));
            }
            return roomHistories;
        } else return roomHistories = null;

    }

    public void writeEntitiesToFile(ArrayList<? extends Entity> entities, String path) {
        String[] strings = new String[entities.size()];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = entities.get(i).getStringForPrintInFile();
        }
        new TextFileWorker(path).writeToFile(strings);
    }


}
