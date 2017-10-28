package com.senla.lesson4.task1.interfaces;

import com.senla.lesson4.task1.entities.Opportunity;
import com.senla.lesson4.task1.entities.Room;

import java.util.Date;

public interface IRoomService {

    public int numOfFreeRooms();

    public void sortRoomsByPrice();

    public void sortRoomsByCapacity();

    public void sortRoomsByStars();

    public Room[] getFreeRooms();

    public Room[] getFreeRoomsOnDate(Date date);

    public String getRoomDetails(int roomId);

    public void changeRepairStatus(int roomId, Boolean bool);

    public void changeRoomPrice(int roomId, Integer price);

    public void addOpportunity(int roomId, Opportunity opportunity);
}
