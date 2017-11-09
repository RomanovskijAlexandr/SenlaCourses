package com.senla.lesson5.hotelmanager.handlers;

import com.danco.training.TextFileWorker;
import com.senla.lesson5.hotelmanager.entities.Client;
import com.senla.lesson5.hotelmanager.entities.Entity;
import com.senla.lesson5.hotelmanager.entities.Opportunity;
import com.senla.lesson5.hotelmanager.entities.Room;

import java.io.File;
import java.util.ArrayList;

public class TextHandler {
    private StringHandler stringHandler = new StringHandler();

    private TextFileWorker textFileWorker;

    public TextHandler() {
        this.textFileWorker = new TextFileWorker("D:\\output.txt");
    }

    public ArrayList<Client> getClients(String[] objects, String path) {
        ArrayList<Client> clients = new ArrayList<>();
        if (textFileWorker.readFromFile() != null && new File(path).exists()) {
            for (int i = 0; i < objects.length; i++) {
                clients.add(i, stringHandler.getClientFromString(objects[i]));
            }
            return clients;
        } else return clients = null;
    }

    public ArrayList<Opportunity> getOpportunities(String[] objects, String path) {
        ArrayList<Opportunity> opportunities = new ArrayList<>();
        if (textFileWorker.readFromFile() != null && new File(path).exists()) {
            for (int i = 0; i < objects.length; i++) {
                opportunities.add(i, stringHandler.getOpportunityFromString(objects[i]));
            }
            return opportunities;
        } else return opportunities = null;
    }

    public ArrayList<Room> getRooms(String[] objects, String path) {
        ArrayList<Room> rooms = new ArrayList<>();
        if (textFileWorker.readFromFile() != null && new File(path).exists()) {
            for (int i = 0; i < objects.length; i++) {
                rooms.add(i, stringHandler.getRoomFromString(objects[i]));
            }
            return rooms;
        } else return rooms = null;
    }

    public void writeEntitiesToFile(ArrayList<Entity> entities) {
        String[] strings = new String[entities.size()];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = entities.get(i).getStringForPrintInFile();
        }
        textFileWorker.writeToFile(strings);
    }
}
