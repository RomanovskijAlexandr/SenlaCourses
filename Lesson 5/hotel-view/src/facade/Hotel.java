package facade;

import comparators.clients.DateComparator;
import comparators.clients.NameComporator;
import comparators.opportunities.PriceComparator;
import comparators.rooms.CapacityComparator;
import comparators.rooms.StarsComparator;
import entities.Client;
import entities.Entity;
import entities.Opportunity;
import entities.Room;
import handlers.TextHandler;
import org.apache.log4j.Logger;
import paths.FilePath;
import repository.RoomRepository;
import services.ClientService;
import services.OpportunityService;
import services.RoomHistoryService;
import services.RoomService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Hotel implements IHotel {
    private ClientService clientService;

    private RoomService roomService;

    private OpportunityService opportunityService;

    private RoomHistoryService roomHistoryService;

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
        roomHistoryService = new RoomHistoryService();
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
            Room room = roomService.findById(roomId);
            List<Client> clients = new ArrayList<>();
            for (int i = roomService.getLastSortClients(roomId).size() - 1; i >= 0; i--) {
                if (tmp != 3)
                    clients.add(roomService.getLastSortClients(roomId).get(i));
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
            roomService.changeRepairStatus(roomId, bool);
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
            if (clientService.getPath() != null && opportunityService.getPath() != null && roomService.getPath() != null && roomHistoryService.getPath() != null) {
                new TextHandler().writeEntitiesToFile((ArrayList<? extends Entity>) getClientService().findAll(), clientService.getPath());
                new TextHandler().writeEntitiesToFile((ArrayList<? extends Entity>) getOpportunityService().findAll(), opportunityService.getPath());
                new TextHandler().writeEntitiesToFile((ArrayList<? extends Entity>) getRoomService().findAll(), roomService.getPath());
                new TextHandler().writeEntitiesToFile((ArrayList<? extends Entity>) getRoomHistoryService().findAll(), roomHistoryService.getPath());
            } else {
                new TextHandler().writeEntitiesToFile((ArrayList<? extends Entity>) getClientService().findAll(), FilePath.clientPath);
                new TextHandler().writeEntitiesToFile((ArrayList<? extends Entity>) getOpportunityService().findAll(), FilePath.opportunityPath);
                new TextHandler().writeEntitiesToFile((ArrayList<? extends Entity>) getRoomService().findAll(), FilePath.roomPath);
                new TextHandler().writeEntitiesToFile((ArrayList<? extends Entity>) getRoomHistoryService().findAll(), FilePath.roomHistoryPath);
            }
        } catch (Exception e) {
            log.info(e);
        }
    }

    @Override
    public void changePaths(String clientPath, String roomPath, String opportunityPath, String roomHistoryPath) {
        try {
            getClientService().setPath(clientPath);
            getRoomService().setPath(roomPath);
            getOpportunityService().setPath(opportunityPath);
            getRoomHistoryService().setPath(roomHistoryPath);
        } catch (Exception e) {
            log.info(e);
        }
    }
}
