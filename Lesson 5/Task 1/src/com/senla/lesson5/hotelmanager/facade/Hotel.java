package com.senla.lesson5.hotelmanager.facade;

import com.senla.lesson5.hotelmanager.comparators.ClientComporators;
import com.senla.lesson5.hotelmanager.comparators.OpportunityComparators;
import com.senla.lesson5.hotelmanager.comparators.RoomComporators;
import com.senla.lesson5.hotelmanager.entities.Client;
import com.senla.lesson5.hotelmanager.entities.Entity;
import com.senla.lesson5.hotelmanager.entities.Opportunity;
import com.senla.lesson5.hotelmanager.entities.Room;
import com.senla.lesson5.hotelmanager.handlers.TextHandler;
import com.senla.lesson5.hotelmanager.services.ClientService;
import com.senla.lesson5.hotelmanager.services.OpportunityService;
import com.senla.lesson5.hotelmanager.services.RoomService;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;

public class Hotel {
    private ClientService clientService;

    private RoomService roomService;

    private OpportunityService opportunityService;

    private TextHandler textHandler;

    private static final Logger log = Logger.getLogger(Hotel.class.getName());

    public Hotel() {
        clientService = new ClientService();
        roomService = new RoomService();
        opportunityService = new OpportunityService();
        textHandler = new TextHandler();
    }

    public ClientService getClientService() {
        return clientService;
    }

    public RoomService getRoomService() {
        return roomService;
    }

    public OpportunityService getOpportunityService() {
        return opportunityService;
    }

    public TextHandler getTextHandler() {
        return textHandler;
    }

    public void printEntities(ArrayList<Entity> entities) {
        StringBuilder[] sb = new StringBuilder[entities.size()];
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i) != null)
                sb[i] = new StringBuilder(entities.get(i).toString());
        }
        for (int i = 0; i < entities.size(); i++) {
            System.out.println(sb[i].toString());
        }
        System.out.println("\n");
    }

    //Client Service

    public void sortClientsByName() {
        Collections.sort(clientService.getClientRepository().getClients(), new ClientComporators().getNameComparator());
    }

    public void sortClientsByDate() {
        Collections.sort(clientService.getClientRepository().getClients(), new ClientComporators().getDateComparator());
    }

    public int getPriceForRoom(Client client) {
        return clientService.getPriceForRoom(client.getId());
    }

    public ArrayList<Client> getLastClients() {
        return clientService.getLastThreeClients();
    }

    public ArrayList<Opportunity> getClientOpportunities(Client client) {
        return clientService.getClientOpportunities(client.getId());
    }

    public void moveOutClientFromRoom(Client client) {
        clientService.moveOutClientFromRoom(client.getId());
    }

    public void settleClientInRoom(Client client, Room room) {
        clientService.settleClientInRoom(client.getId(), room);
    }

    //Opportunity service

    public void changeOpportunitiesPrice(Opportunity opportunity, Integer price) {
        opportunityService.changeOpportunitiesPrice(opportunity.getId(), price);
    }

    public void sortOpportunitiesByPrice() {
        Collections.sort(opportunityService.getOpportunityRepository().getOpportunities(), new OpportunityComparators().getOpportunityByPriceComparator());
    }

    //Room Service

    public String getRoomDetails(Room room) {
        return roomService.getRoomDetails(room.getId());
    }

    public void changeRepairStatus(Room room, Boolean bool) {
        roomService.changeRepairStatus(room.getId(), bool);
    }

    public void changeRoomPrice(Room room, Integer price) {
        roomService.changeRoomPrice(room.getId(), price);
    }

    public void addOpportunity(Room room, Opportunity opportunity) {
        roomService.addOpportunity(room.getId(), opportunity);
    }

    public void sortRoomsByPrice() {
        Collections.sort(roomService.getRoomRepository().getRooms(), new RoomComporators().getPriceComparator());
    }

    public void sortRoomsByCapacity() {
        Collections.sort(roomService.getRoomRepository().getRooms(), new RoomComporators().getCapacityComparator());
    }

    public void sortRoomsByStars() {
        Collections.sort(roomService.getRoomRepository().getRooms(), new RoomComporators().getStarsComparator());
    }
}