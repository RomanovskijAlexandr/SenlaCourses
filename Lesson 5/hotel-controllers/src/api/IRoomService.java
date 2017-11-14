package api;

import entities.Opportunity;
import entities.Room;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

public interface IRoomService {

    public int numOfFreeRooms();

    public ArrayList<Room> getFreeRooms();

    public ArrayList<Room> getFreeRoomsOnDate(Date date);

    public String getRoomDetails(int roomId);

    public void changeRepairStatus(int roomId, Boolean bool);

    public void changeRoomPrice(int roomId, Integer price);

    public void addOpportunity(int roomId, Opportunity opportunity);

    public void sortRooms(Comparator<Room> comparator);
}
