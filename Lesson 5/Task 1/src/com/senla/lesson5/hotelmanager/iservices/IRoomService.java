package com.senla.lesson5.hotelmanager.iservices;

import com.senla.lesson5.hotelmanager.entities.Opportunity;
import com.senla.lesson5.hotelmanager.entities.Room;

import java.util.ArrayList;
import java.util.Date;

public interface IRoomService {

    public int numOfFreeRooms();

    public ArrayList<Room> getFreeRooms();

    public ArrayList<Room> getFreeRoomsOnDate(Date date);

    public String getRoomDetails(int roomId);

    public void changeRepairStatus(int roomId, Boolean bool);

    public void changeRoomPrice(int roomId, Integer price);

    public void addOpportunity(int roomId, Opportunity opportunity);

    public void printRooms(ArrayList<Room> rooms);
}
