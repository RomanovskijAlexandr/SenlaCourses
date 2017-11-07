package com.senla.lesson5.task1.handlers;

import com.danco.training.TextFileWorker;
import com.senla.lesson5.task1.entities.Client;
import com.senla.lesson5.task1.entities.Entity;
import com.senla.lesson5.task1.entities.Opportunity;
import com.senla.lesson5.task1.entities.Room;

public class TextHandler {
    private StringHandler stringHandler = new StringHandler();

    private TextFileWorker textFileWorker;

    public TextHandler() {
        this.textFileWorker = new TextFileWorker("D:\\output.txt");
    }

    public Client[] getClients(String[] objects) {
        Client[] clients = new Client[objects.length];
        for (int i = 0; i < clients.length; i++) {
            clients[i] = stringHandler.getClientFromString(objects[i]);
        }
        return clients;
    }

    public Opportunity[] getOpportunities(String[] objects) {
        Opportunity[] opportunities = new Opportunity[objects.length];
        for (int i = 0; i < opportunities.length; i++) {
            opportunities[i] = stringHandler.getOpportunityFromString(objects[i]);
        }
        return opportunities;
    }

    public Room[] getRooms(String[] objects) {
        Room[] rooms = new Room[objects.length];
        for (int i = 0; i < rooms.length; i++) {
            rooms[i] = stringHandler.getRoomFromString(objects[i]);
        }
        return rooms;
    }

    public void writeEntitiesToFile(Entity[] entities) {
        String[] strings = new String[entities.length];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = entities[i].getStringForPrintInFile();
        }
        textFileWorker.writeToFile(strings);

    }
}
