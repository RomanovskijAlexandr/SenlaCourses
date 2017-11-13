package services;

import api.IRoomService;
import entities.Entity;
import entities.Opportunity;
import entities.Room;
import repositories.RoomRepository;

import java.util.*;

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
    public void sortRooms(Comparator<Room> comparator){
        Collections.sort(roomRepository.getRooms(), comparator);
    }

    public Room findById(int id){
        return roomRepository.findById(id);
    }

    public List<Room> findAll(){
        return roomRepository.findAll();
    }

    public void save(Entity entity){
        roomRepository.save(entity);
    }

    public long count(){
        return roomRepository.count();
    }
}
