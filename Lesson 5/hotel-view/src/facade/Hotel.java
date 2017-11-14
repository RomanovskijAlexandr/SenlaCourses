package facade;

import api.IHotel;
import comparators.ClientComporators;
import comparators.OpportunityComparators;
import comparators.RoomComporators;
import entities.Client;
import entities.Entity;
import entities.Opportunity;
import entities.Room;
import handlers.TextHandler;
import org.apache.log4j.Logger;
import services.ClientService;
import services.OpportunityService;
import services.RoomService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Hotel implements IHotel {
    private ClientService clientService;

    private RoomService roomService;

    private OpportunityService opportunityService;

    private static final Logger log = Logger.getLogger(Hotel.class.getName());

    private static Hotel hotel;

    public static Hotel getInstance() {
        if (hotel == null) {
            hotel = new Hotel();
        }
        return hotel;
    }

    private Hotel() {
        clientService = new ClientService();
        roomService = new RoomService();
        opportunityService = new OpportunityService();
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

    public void printEntities(List<? extends Entity> entities) {
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
    @Override
    public void createClient(String name) {
        Client client = new Client(name);
        clientService.save(client);
    }

    @Override
    public void sortClientsByName() {
        clientService.sortClients(new ClientComporators().getNameComparator());
    }

    @Override
    public void sortClientsByDate() {
        clientService.sortClients(new ClientComporators().getDateComparator());
    }

    @Override
    public int getPriceForRoom(Client client) {
        return clientService.getPriceForRoom(client.getId());
    }

    @Override
    public ArrayList<Client> getLastThreeClients() {
        return clientService.getLastThreeClients();
    }

    @Override
    public ArrayList<Opportunity> getClientOpportunities(Client client) {
        return clientService.getClientOpportunities(client.getId());
    }

    @Override
    public void moveOutClientFromRoom(Integer clientId) {
        clientService.moveOutClientFromRoom(clientId);
    }

    @Override
    public void settleClientInRoom(Integer idClient, Integer idRoom) {
        clientService.settleClientInRoom(idClient, idRoom);
    }

    //Opportunity service

    @Override
    public void createOpportunity(String name, Integer price) {
        Opportunity opportunity = new Opportunity(name, price);
        opportunityService.save(opportunity);
    }

    @Override
    public void changeOpportunitiesPrice(Integer opportunityId, Integer price) {
        opportunityService.changeOpportunitiesPrice(opportunityId, price);
    }

    @Override
    public void sortOpportunitiesByPrice() {
        opportunityService.sortOpportunities(new OpportunityComparators().getOpportunityByPriceComparator());
    }

    //Room Service

    @Override
    public void createRoom(Integer number, Integer price, Integer capacity, Integer numOfStars, Date dateEviction, Date dateOfSettle) {
        Room room = new Room(number, price, capacity, numOfStars, dateEviction, dateOfSettle);
        roomService.save(room);
    }

    @Override
    public int numOfFreeRooms() {
        return roomService.numOfFreeRooms();
    }

    @Override
    public ArrayList<Room> getFreeRooms() {
        return roomService.getFreeRooms();
    }

    @Override
    public ArrayList<Room> getFreeRoomsOnDate(Date date) {
        return roomService.getFreeRoomsOnDate(date);
    }

    @Override
    public String getRoomDetails(Integer roomId) {
        return roomService.getRoomDetails(roomId);
    }

    @Override
    public void changeRepairStatus(Integer roomId, Boolean bool) {
        roomService.changeRepairStatus(roomId, bool);
    }

    @Override
    public void changeRoomPrice(Integer roomId, Integer price) {
        roomService.changeRoomPrice(roomId, price);
    }

    @Override
    public void addOpportunity(Integer roomId, Integer opportunityId) {
        roomService.addOpportunity(roomId, opportunityService.getOpportunityRepository().findById(opportunityId));
    }

    @Override
    public void sortRoomsByPrice() {
        roomService.sortRooms(new RoomComporators().getPriceComparator());
    }

    @Override
    public void sortRoomsByCapacity() {
        roomService.sortRooms(new RoomComporators().getCapacityComparator());
    }

    @Override
    public void sortRoomsByStars() {
        roomService.sortRooms(new RoomComporators().getStarsComparator());
    }

    @Override
    public void saveEntities() {
        new TextHandler().writeEntitiesToFile((ArrayList<? extends Entity>) getClientService().findAll(), "D:\\inputClients.txt");
        new TextHandler().writeEntitiesToFile((ArrayList<? extends Entity>) getOpportunityService().findAll(), "D:\\inputOpportunities.txt");
        new TextHandler().writeEntitiesToFile((ArrayList<? extends Entity>) getRoomService().findAll(), "D:\\inputRooms.txt");
    }
}
