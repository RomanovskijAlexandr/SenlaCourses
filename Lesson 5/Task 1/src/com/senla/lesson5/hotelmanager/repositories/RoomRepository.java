package com.senla.lesson5.hotelmanager.repositories;

import com.danco.training.TextFileWorker;
import com.senla.lesson5.hotelmanager.entities.Room;
import com.senla.lesson5.hotelmanager.handlers.TextHandler;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class RoomRepository {
    private ArrayList<Room> rooms;

    public static int lastIdRoom = 0;

    private static final Logger log = Logger.getLogger(RoomRepository.class.getName());

    private String path = "D:\\inputRooms.txt";

    public RoomRepository() {
        rooms = new TextHandler().getRooms(new TextFileWorker(path).readFromFile(), path);
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public Room findById(int id) {
        Room room = null;
        for (Room roomFind : rooms) {
            if (roomFind.getId() == id) {
                room = roomFind;
                break;
            }
        }
        return room;
    }

    public ArrayList<Room> findAll() {
        return rooms;
    }

    public void save(Room room) {
        this.rooms.add(room);
    }

    public long count() {
        return rooms.size();
    }
}
