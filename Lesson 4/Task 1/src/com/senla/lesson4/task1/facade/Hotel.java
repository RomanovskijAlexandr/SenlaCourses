package com.senla.lesson4.task1.facade;

import com.senla.lesson4.task1.comparators.ClientComporators;
import com.senla.lesson4.task1.comparators.OpportunityComparators;
import com.senla.lesson4.task1.comparators.RoomComporators;
import com.senla.lesson4.task1.entities.Entity;
import com.senla.lesson4.task1.handlers.ArrayHandler;
import com.senla.lesson4.task1.handlers.TextHandler;
import com.senla.lesson4.task1.services.ClientService;
import com.senla.lesson4.task1.services.OpportunityService;
import com.senla.lesson4.task1.services.RoomService;

import java.text.ParseException;
import java.util.Arrays;

public class Hotel {
    private ClientService clientService;

    private RoomService roomService;

    private OpportunityService opportunityService;

    private TextHandler textHandler;

    ArrayHandler arrayHandler;

    public Hotel() throws ParseException {
        clientService = new ClientService();
        roomService = new RoomService();
        opportunityService = new OpportunityService();
        textHandler = new TextHandler();
        arrayHandler = new ArrayHandler();
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

    public void sortClientsByName() {
        Arrays.sort(clientService.getClientRepository().getClients(), new ClientComporators().getNameComparator());
    }

    public void sortClientsByDate() {
        Arrays.sort(clientService.getClientRepository().getClients(), new ClientComporators().getDateComparator());
    }

    public void sortOpportunitiesByPrice() {
        Arrays.sort(opportunityService.getOpportunityRepository().getOpportunities(), new OpportunityComparators().getOpportunityByPriceComparator());
    }

    public void sortRoomsByPrice() {
        Arrays.sort(roomService.getRoomRepository().getRooms(), new RoomComporators().getPriceComparator());
    }

    public void sortRoomsByCapacity() {
        Arrays.sort(roomService.getRoomRepository().getRooms(), new RoomComporators().getCapacityComparator());
    }

    public void sortRoomsByStars() {
        Arrays.sort(roomService.getRoomRepository().getRooms(), new RoomComporators().getStarsComparator());
    }

    public void printEntities(Entity[] entities){
        StringBuilder[] sb = new StringBuilder[entities.length];
        for (int i = 0; i < entities.length; i++) {
            sb[i] = new StringBuilder(entities[i].toString());
        }
        for (int i = 0; i < entities.length; i++) {
            System.out.println(sb[i].toString());
        }
        System.out.println("\n");
    }


}
