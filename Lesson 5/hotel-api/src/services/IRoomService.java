package services;

import entities.Opportunity;
import entities.Room;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

public interface IRoomService {

    public int numOfFreeRooms();

    public List<Room> getFreeRooms();

    public List<Room> getFreeRoomsOnDate(Date date);

    public String getRoomDetails(int roomId);

    public void changeRepairStatus(int roomId, Boolean bool);

    public void changeRoomPrice(int roomId, Integer price);

    public void addOpportunity(int roomId, Opportunity opportunity);

    public void sortRooms(Comparator<Room> comparator);
}
