package com.senla.lesson5.task1.repositories;

import com.danco.training.TextFileWorker;
import com.senla.lesson5.task1.entities.Room;
import com.senla.lesson5.task1.handlers.ArrayHandler;
import com.senla.lesson5.task1.handlers.TextHandler;
import org.apache.log4j.Logger;

public class RoomRepository {
    private Room[] rooms;

    private static final Logger log = Logger.getLogger(RoomRepository.class.getName());

    public RoomRepository() {
        rooms = new TextHandler().getRooms(new TextFileWorker("D:\\inputRooms.txt").readFromFile());
    }

    public Room[] getRooms() {
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

    public Room[] findAll() {
        return rooms;
    }

    public void save(Room room) {
        if (!new ArrayHandler().checkArrayForNewElement(rooms)) {
            rooms = (Room[]) new ArrayHandler().resizeArray(rooms);
        }
        rooms[new ArrayHandler().getPosition(rooms)] = room;
    }

    public long count() {
        return rooms.length;
    }
}
