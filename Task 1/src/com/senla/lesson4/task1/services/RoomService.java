package com.senla.lesson4.task1.services;

import com.senla.lesson4.task1.comparators.RoomComporators;
import com.senla.lesson4.task1.entities.Opportunity;
import com.senla.lesson4.task1.entities.Room;
import com.senla.lesson4.task1.interfaces.IRoomService;
import com.senla.lesson4.task1.repositories.RoomRepository;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;

public class RoomService implements IRoomService {

    private RoomRepository roomRepository = new RoomRepository();

    public RoomService() throws ParseException {
    }

    public RoomRepository getRoomRepository() {
        return roomRepository;
    }

    @Override
    public int numOfFreeRooms() {
        int count = 0;
        for (Room room : roomRepository.getRooms()) {
            if (room.getFree()) {
                count++;
            }
        }
        return count;
    }

    @Override
    public void sortRoomsByPrice() {
        Arrays.sort(roomRepository.getRooms(), new RoomComporators().getPriceComparator());
    }

    @Override
    public void sortRoomsByCapacity() {
        Arrays.sort(roomRepository.getRooms(), new RoomComporators().getCapacityComparator());
    }

    @Override
    public void sortRoomsByStars() {
        Arrays.sort(roomRepository.getRooms(), new RoomComporators().getStarsComparator());
    }

    @Override
    public Room[] getFreeRooms() {
        Room[] roomsFree = new Room[numOfFreeRooms()];
        for (int i = 0; i < roomRepository.getRooms().length; i++) {
            if (roomRepository.getRooms()[i].getFree()) {
                for (int j = 0; j < roomsFree.length; j++) {
                    roomsFree[j] = roomRepository.getRooms()[i];
                }
            }
        }
        return roomsFree;
    }

    @Override
    public Room[] getFreeRoomsOnDate(Date date) {
        int count = 0;
        for (Room room : roomRepository.getRooms()) {
            if (date.getTime() >= room.getDateEviction().getTime()) {
                count++;
            }
        }
        Room[] freeRooms = new Room[count];
        for (int i = 0; i < roomRepository.getRooms().length; i++) {
            if (date.getTime() >= roomRepository.getRooms()[i].getDateEviction().getTime()) {
                for (int j = 0; j < count; j++) {
                    freeRooms[j] = roomRepository.getRooms()[i];
                }
            }
        }
        return freeRooms;
    }

    @Override
    public String getRoomDetails(int roomId) {
        return roomRepository.findById(roomId).toString();
    }

    @Override
    public void changeRepairStatus(int roomId, Boolean bool) {
        roomRepository.findById(roomId).setRepair(bool);
    }

    @Override
    public void changeRoomPrice(int roomId, Integer price) {
        roomRepository.findById(roomId).setPrice(price);
    }

    @Override
    public void addOpportunity(int roomId, Opportunity opportunity) {
        roomRepository.findById(roomId).setOpportunity(opportunity);
    }
}
