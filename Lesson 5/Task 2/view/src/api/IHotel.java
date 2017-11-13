package api;

import entities.Client;
import entities.Opportunity;
import entities.Room;

import java.util.ArrayList;
import java.util.Date;

public interface IHotel {
    public void createClient(String name);

    public void sortClientsByName();

    public void sortClientsByDate();

    public int getPriceForRoom(Client client);

    public ArrayList<Client> getLastThreeClients();

    public ArrayList<Opportunity> getClientOpportunities(Client client);

    public void moveOutClientFromRoom(Integer clientId);

    public void settleClientInRoom(Integer idClient, Integer idRoom);

    //Opportunity service

    public void createOpportunity(String name, Integer price);

    public void changeOpportunitiesPrice(Integer opportunityId, Integer price);

    public void sortOpportunitiesByPrice();

    //Room Service

    public void createRoom(Integer number, Integer price, Integer capacity, Integer numOfStars, Date dateEviction, Date dateOfSettle);

    public int numOfFreeRooms();

    public ArrayList<Room> getFreeRooms();

    public ArrayList<Room> getFreeRoomsOnDate(Date date);

    public String getRoomDetails(Integer roomId);

    public void changeRepairStatus(Integer roomId, Boolean bool);

    public void changeRoomPrice(Integer roomId, Integer price);

    public void addOpportunity(Integer roomId, Integer opportunityId);

    public void sortRoomsByPrice();

    public void sortRoomsByCapacity();

    public void sortRoomsByStars();

    public void saveEntities();
}
