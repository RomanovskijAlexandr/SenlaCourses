package facade;

import comparators.clients.DateComparator;
import comparators.clients.NameComporator;
import comparators.opportunities.PriceComparator;
import comparators.rooms.CapacityComparator;
import comparators.rooms.StarsComparator;
import entities.Client;
import entities.Opportunity;
import entities.Room;
import handlers.csv.CsvReader;
import handlers.csv.CsvWriter;
import handlers.serialize.Writer;
import org.apache.log4j.Logger;
import repository.RoomRepository;
import services.ClientService;
import services.OpportunityService;
import services.RoomHistoryService;
import services.RoomService;
import storage.PropertiesStorage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Hotel implements IHotel {
    private ClientService clientService;

    private RoomService roomService;

    private OpportunityService opportunityService;

    private RoomHistoryService roomHistoryService;

    private PropertiesStorage propertiesStorage;

    private static final Logger log = Logger.getLogger(Hotel.class.getName());

    private static Hotel hotel;

    public static Hotel getInstance() {
        if (hotel == null) {
            hotel = new Hotel();
        }
        return hotel;
    }

    private Hotel() {
        propertiesStorage = PropertiesStorage.getInstance();
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

    public RoomHistoryService getRoomHistoryService() {
        return roomHistoryService;
    }


    //Client Service
    @Override
    public void createClient(String name) {
        try {
            Client client = new Client(name);
            clientService.save(client);
        } catch (Exception e) {
            log.info(e);
        }
    }

    @Override
    public void sortClientsByName() {
        try {
            clientService.sortClients(new NameComporator());
        } catch (Exception e) {
            log.info(e);
        }
    }

    @Override
    public void sortClientsByDate() {
        try {
            clientService.sortClients(new DateComparator());
        } catch (Exception e) {
            log.info(e);
        }
    }

    @Override
    public int getPriceForRoom(Client client) {
        try {
            return clientService.getPriceForRoom(client.getId());
        } catch (Exception e) {
            log.info(e);
            return Integer.parseInt(null);
        }
    }

    @Override
    public List<Client> getLastThreeClients(Integer roomId) {
        try {
            int tmp = 0;
            tmp = Integer.parseInt(propertiesStorage.getProperties().getProperty("numberOfRoomClients"));
            Room room = roomService.findById(roomId);
            List<Client> clients = new ArrayList<>();
            for (int i = roomService.getLastSortClients(roomId).size() - 1; i >= 0; i--) {
                if (tmp != 0)
                    clients.add(roomService.getLastSortClients(roomId).get(i));
                tmp--;
            }
            return clients;
        } catch (Exception e) {
            log.info(e);
            return null;
        }
    }

    @Override
    public List<Opportunity> getClientOpportunities(Client client) {
        try {
            return clientService.getClientOpportunities(client.getId());
        } catch (Exception e) {
            log.info(e);
            return null;
        }
    }

    @Override
    public void moveOutClientFromRoom(Integer clientId) {
        try {
            clientService.moveOutClientFromRoom(clientId);
        } catch (Exception e) {
            log.info(e);
        }
    }

    @Override
    public void settleClientInRoom(Integer idClient, Integer idRoom, Date dateEviction, Date dateOfSettle) {
        try {
            Room room = RoomRepository.getInstance().findById(idRoom);
            clientService.settleClientInRoom(idClient, idRoom, dateEviction, dateOfSettle);
        } catch (Exception e) {
            log.info(e);
        }
    }

    //Opportunity service

    @Override
    public void createOpportunity(String name, Integer price) {
        try {
            Opportunity opportunity = new Opportunity(name, price);
            opportunityService.save(opportunity);
        } catch (Exception e) {
            log.info(e);
        }
    }

    @Override
    public void changeOpportunitiesPrice(Integer opportunityId, Integer price) {
        try {
            opportunityService.changeOpportunitiesPrice(opportunityId, price);
        } catch (Exception e) {
            log.info(e);
        }
    }

    @Override
    public void sortOpportunitiesByPrice() {
        try {
            opportunityService.sortOpportunities(new PriceComparator());
        } catch (Exception e) {
            log.info(e);
        }
    }

    //Room Service

    @Override
    public void createRoom(Integer number, Integer price, Integer capacity, Integer numOfStars, Date dateEviction, Date dateOfSettle) {
        try {
            Room room = new Room(number, price, capacity, numOfStars, dateEviction, dateOfSettle);
            roomService.save(room);
        } catch (Exception e) {
            log.info(e);
        }
    }

    @Override
    public int numOfFreeRooms() {
        try {
            return roomService.numOfFreeRooms();
        } catch (Exception e) {
            log.info(e);
            return Integer.parseInt(null);
        }
    }

    @Override
    public List<Room> getFreeRooms() {
        try {
            return roomService.getFreeRooms();
        } catch (Exception e) {
            log.info(e);
            return null;
        }
    }

    @Override
    public List<Room> getFreeRoomsOnDate(Date date) {
        try {
            return roomService.getFreeRoomsOnDate(date);
        } catch (Exception e) {
            log.info(e);
            return null;
        }
    }

    @Override
    public String getRoomDetails(Integer roomId) {
        try {
            return roomService.getRoomDetails(roomId);
        } catch (Exception e) {
            log.info(e);
            return null;
        }
    }

    @Override
    public void changeRepairStatus(Integer roomId, Boolean bool) {
        try {
            if (propertiesStorage.getProperties().getProperty("changeStatus") == "yes")
                roomService.changeRepairStatus(roomId, bool);
            else System.out.println("You can't change room's status");
        } catch (Exception e) {
            log.info(e);
        }
    }

    @Override
    public void changeRoomPrice(Integer roomId, Integer price) {
        try {
            roomService.changeRoomPrice(roomId, price);
        } catch (Exception e) {
            log.info(e);
        }
    }

    @Override
    public void addOpportunity(Integer roomId, Integer opportunityId) {
        try {
            roomService.addOpportunity(roomId, opportunityService.getOpportunityRepository().findById(opportunityId));
        } catch (Exception e) {
            log.info(e);
        }
    }

    @Override
    public void sortRoomsByPrice() {
        try {
            roomService.sortRooms(new comparators.rooms.PriceComparator());
        } catch (Exception e) {
            log.info(e);
        }
    }

    @Override
    public void sortRoomsByCapacity() {
        try {
            roomService.sortRooms(new CapacityComparator());
        } catch (Exception e) {
            log.info(e);
        }
    }

    @Override
    public void sortRoomsByStars() {
        try {
            roomService.sortRooms(new StarsComparator());
        } catch (Exception e) {
            log.info(e);
        }
    }

    @Override
    public void saveEntities() {
        try {
            new Writer().writeEntities(getClientService().findAll(), propertiesStorage.getProperties().getProperty("inputClients"));
            new Writer().writeEntities(getRoomHistoryService().findAll(), propertiesStorage.getProperties().getProperty("inputRoomHistories"));
            new Writer().writeEntities(getRoomService().findAll(), propertiesStorage.getProperties().getProperty("inputRooms"));
            new Writer().writeEntities(getOpportunityService().findAll(), propertiesStorage.getProperties().getProperty("inputOpportunities"));
        } catch (Exception e) {
            log.info(e);
        }
    }

    @Override
    public void updateRoom(Integer roomId, Integer price, Integer capacity, Boolean free, Boolean repair, Integer numOfStars) {
        try {
            Room room = roomService.findById(roomId);
            roomService.updateRoom(room, price, capacity, free, repair, numOfStars, propertiesStorage.getProperties().getProperty("changeStatus"));
        } catch (Exception e) {
            log.info(e);
        }
    }

    @Override
    public void exportClientsCSV() {
        new CsvWriter().writeEntitiesCSV(getClientService().findAll(), propertiesStorage.getProperties().getProperty("inputClientsCSV"));
    }

    @Override
    public void exportRoomsCSV() {
        new CsvWriter().writeEntitiesCSV(getRoomService().findAll(), propertiesStorage.getProperties().getProperty("inputRoomsCSV"));
    }

    @Override
    public void exportOpportunitiesCSV() {
        new CsvWriter().writeEntitiesCSV(getOpportunityService().findAll(), propertiesStorage.getProperties().getProperty("inputOpportunitiesCSV"));
    }

    @Override
    public void importClientsCSV() {
        List<Client> importList = new CsvReader().readClientsCSV(propertiesStorage.getProperties().getProperty("inputClientsCSV"));
        for (int i = 0; i < getClientService().findAll().size(); i++) {
            for (int j = 0; j < importList.size(); j++) {
                if (importList.get(j).getId() == getClientService().findAll().get(i).getId()) {
                    importList.remove(j);
                }
            }
        }
        if (importList.size() != 0) {
            getClientService().findAll().addAll(importList);
        }
    }

    @Override
    public void importRoomsCSV() {
        List<Room> importList = new CsvReader().readRoomsCSV(propertiesStorage.getProperties().getProperty("inputRoomsCSV"));
        for (int i = 0; i < getRoomService().findAll().size(); i++) {
            for (int j = 0; j < importList.size(); j++) {
                if (importList.get(j).getId() == getRoomService().findAll().get(i).getId()) {
                    importList.remove(j);
                }
            }
        }
        if (importList.size() != 0) {
            getRoomService().findAll().addAll(importList);
        }
    }

    @Override
    public void importOpportunitiesCSV() {
        List<Opportunity> importList = new CsvReader().readOpportunityCSV(propertiesStorage.getProperties().getProperty("inputOpportunitiesCSV"));
        for (int i = 0; i < getOpportunityService().findAll().size(); i++) {
            for (int j = 0; j < importList.size(); j++) {
                if (importList.get(j).getId() == getOpportunityService().findAll().get(i).getId()) {
                    importList.remove(j);
                }
            }
        }
        if (importList.size() != 0) {
            getOpportunityService().findAll().addAll(importList);
        }
    }
}
