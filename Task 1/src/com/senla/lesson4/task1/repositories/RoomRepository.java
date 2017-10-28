package com.senla.lesson4.task1.repositories;

import com.danco.training.TextFileWorker;
import com.senla.lesson4.task1.handlers.ArrayHandler;
import com.senla.lesson4.task1.handlers.TextHandler;
import com.senla.lesson4.task1.entities.Room;

import java.text.ParseException;

public class RoomRepository {
    private Room[] rooms;

    public RoomRepository() throws ParseException {
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
