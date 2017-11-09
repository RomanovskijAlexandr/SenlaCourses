package com.senla.lesson5.hotelmanager.services;

import com.senla.lesson5.hotelmanager.entities.Opportunity;
import com.senla.lesson5.hotelmanager.entities.Room;
import com.senla.lesson5.hotelmanager.iservices.IRoomService;
import com.senla.lesson5.hotelmanager.repositories.RoomRepository;

import java.util.ArrayList;
import java.util.Date;

public class RoomService implements IRoomService {

    private RoomRepository roomRepository = new RoomRepository();

    public RoomService() {
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
    public ArrayList<Room> getFreeRooms() {
        ArrayList<Room> roomsFree = new ArrayList<>();
        for (int i = 0; i < roomRepository.getRooms().size(); i++) {
            if (roomRepository.getRooms().get(i).getFree()) {
                for (int j = 0; j < roomsFree.size(); j++) {
                    roomsFree.set(j, roomRepository.getRooms().get(i));
                }
            }
        }
        return roomsFree;
    }

    @Override
    public ArrayList<Room> getFreeRoomsOnDate(Date date) {
        int count = 0;
        for (Room room : roomRepository.getRooms()) {
            if (date.getTime() >= room.getDateEviction().getTime()) {
                count++;
            }
        }
        ArrayList<Room> freeRooms = new ArrayList<>();
        for (int i = 0; i < roomRepository.getRooms().size(); i++) {
            if (date.getTime() >= roomRepository.getRooms().get(i).getDateEviction().getTime()) {
                for (int j = 0; j < count; j++) {
                    freeRooms.set(j, roomRepository.getRooms().get(i));
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

    @Override
    public void printRooms(ArrayList<Room> rooms) {
        StringBuilder[] sb = new StringBuilder[rooms.size()];
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i) != null)
                sb[i] = new StringBuilder(rooms.get(i).toString());
        }
        for (int i = 0; i < rooms.size(); i++) {
            System.out.println(sb[i].toString());
        }
        System.out.println("\n");
    }
}
