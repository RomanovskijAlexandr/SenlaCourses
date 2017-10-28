package com.senla.lesson4.task1.facade;

import com.senla.lesson4.task1.entities.Client;
import com.senla.lesson4.task1.entities.Opportunity;
import com.senla.lesson4.task1.entities.Room;
import com.senla.lesson4.task1.handlers.TextHandler;
import com.senla.lesson4.task1.services.ClientService;
import com.senla.lesson4.task1.services.OpportunityService;
import com.senla.lesson4.task1.services.RoomService;

import java.text.ParseException;

public class Hotel {
    private ClientService clientService;

    private RoomService roomService;

    private OpportunityService opportunityService;

    private TextHandler textHandler;

    public Hotel() throws ParseException {
        clientService = new ClientService();
        roomService = new RoomService();
        opportunityService = new OpportunityService();
        textHandler = new TextHandler();
    }

    public void workWithClientEntities() throws ParseException {
        clientService.settleClientInRoom(0, roomService.getRoomRepository().getRooms()[0]);
        clientService.settleClientInRoom(1, roomService.getRoomRepository().getRooms()[1]);
        clientService.settleClientInRoom(2, roomService.getRoomRepository().getRooms()[2]);
        clientService.sortClientsByDateEviction();
        printClients(clientService.getClientRepository().getClients());
        printClients(clientService.getLastThreeClients());
        System.out.println(clientService.getPriceForRoom(0));
        textHandler.writeEntitiesToFile(clientService.getClientRepository().getClients());
    }

    public void workWithRoomEntities() {
        System.out.println(roomService.getRoomDetails(1).toString());
        roomService.sortRoomsByCapacity();
        printRoom(roomService.getRoomRepository().getRooms());
        roomService.sortRoomsByPrice();
        printRoom(roomService.getRoomRepository().getRooms());
        roomService.changeRoomPrice(0, 234);
        printRoom(roomService.getRoomRepository().getRooms());
    }

    public void workWithOpportunityEntities() {
        opportunityService.sortOpportunitiesByPrice();
        printOpportunity(opportunityService.getOpportunityRepository().getOpportunities());
        opportunityService.changeOpportunitiesPrice(0, 122);
        printOpportunity(opportunityService.getOpportunityRepository().getOpportunities());
    }

    private void printClients(Client[] clients) {
        StringBuilder[] sb = new StringBuilder[clients.length];
        for (int i = 0; i < clients.length; i++) {
            sb[i] = new StringBuilder(clients[i].toString());
        }
        for (int i = 0; i < clients.length; i++) {
            System.out.println(sb[i].toString());
        }
        System.out.println("\n");
    }

    private void printOpportunity(Opportunity[] opportunities) {
        StringBuilder[] sb = new StringBuilder[opportunities.length];
        for (int i = 0; i < opportunities.length; i++) {
            sb[i] = new StringBuilder(opportunities[i].toString());
        }
        for (int i = 0; i < opportunities.length; i++) {
            System.out.println(sb[i].toString());
        }
        System.out.println("\n");
    }

    private void printRoom(Room[] rooms) {
        StringBuilder[] sb = new StringBuilder[rooms.length];
        for (int i = 0; i < rooms.length; i++) {
            sb[i] = new StringBuilder(rooms[i].toString());
        }
        for (int i = 0; i < rooms.length; i++) {
            System.out.println(sb[i].toString());
        }
        System.out.println("\n");
    }
}
