package facade;

import entities.Client;
import entities.Opportunity;
import entities.Room;

import java.util.Date;
import java.util.List;

public interface IHotel {
    public void createClient(String name);

    public void sortClientsByName();

    public void sortClientsByDate();

    public int getPriceForRoom(Client client);

    public List<Client> getLastThreeClients(Integer roomId);

    public List<Opportunity> getClientOpportunities(Client client);

    public void moveOutClientFromRoom(Integer clientId);

    public void settleClientInRoom(Integer idClient, Integer idRoom, Date dateEviction, Date dateOfSettle);

    //Opportunity service

    public void createOpportunity(String name, Integer price);

    public void changeOpportunitiesPrice(Integer opportunityId, Integer price);

    public void sortOpportunitiesByPrice();

    //Room Service

    public void createRoom(Integer number, Integer price, Integer capacity, Integer numOfStars, Date dateEviction, Date dateOfSettle);

    public int numOfFreeRooms();

    public List<Room> getFreeRooms();

    public List<Room> getFreeRoomsOnDate(Date date);

    public String getRoomDetails(Integer roomId);

    public void changeRepairStatus(Integer roomId, Boolean bool);

    public void changeRoomPrice(Integer roomId, Integer price);

    public void addOpportunity(Integer roomId, Integer opportunityId);

    public void sortRoomsByPrice();

    public void sortRoomsByCapacity();

    public void sortRoomsByStars();

    public void saveEntities();

    public void updateRoom(Integer roomId, Integer price, Integer capacity, Boolean free, Boolean repair, Integer numOfStars);

    public void exportClientsCSV();

    public void exportRoomsCSV();

    void exportOpportunitiesCSV();

    void importClientsCSV();

    void importRoomsCSV();

    void importOpportunitiesCSV();
}
