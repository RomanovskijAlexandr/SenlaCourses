package services;

import comparators.clients.DateComparator;
import entities.Client;
import entities.Entity;
import entities.Opportunity;
import entities.Room;
import managers.IRoomService;
import repository.ClientRepository;
import storages.IRepository;
import repository.RoomHistoryRepository;
import repository.RoomRepository;

import java.io.IOException;
import java.util.*;

public class RoomService implements IRoomService {

    private RoomRepository roomRepository = RoomRepository.getInstance();

    private IRepository roomHistoryRepository = RoomHistoryRepository.getInstance();

    private IRepository clientRepository = ClientRepository.getInstance();

    public RoomService() throws IOException {
    }

    public RoomRepository getRoomRepository() {
        return (RoomRepository) roomRepository;
    }

    @Override
    public int numOfFreeRooms() {
        RoomRepository roomRepository = (RoomRepository) this.roomRepository;
        int count = 0;
        for (Room room : roomRepository.getRooms()) {
            if (room.getFree()) {
                count++;
            }
        }
        return count;
    }

    @Override
    public List<Room> getFreeRooms() {
        RoomRepository roomRepository = (RoomRepository) this.roomRepository;
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
    public List<Room> getFreeRoomsOnDate(Date date) {
        int count = 0;
        RoomRepository roomRepository = (RoomRepository) this.roomRepository;
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
        Room room = (Room) roomRepository.findById(roomId);
        return room.toString();
    }

    @Override
    public void changeRepairStatus(int roomId, Boolean bool) {
        Room room = (Room) roomRepository.findById(roomId);
        room.setRepair(bool);
    }

    @Override
    public void changeRoomPrice(int roomId, Integer price) {
        Room room = (Room) roomRepository.findById(roomId);
        room.setPrice(price);
    }

    @Override
    public void addOpportunity(int roomId, Opportunity opportunity) {
        Room room = (Room) roomRepository.findById(roomId);
        room.setOpportunity(opportunity);
    }

    @Override
    public void sortRooms(Comparator<Room> comparator) {
        RoomRepository roomRepository = (RoomRepository) this.roomRepository;
        Collections.sort(roomRepository.getRooms(), comparator);
    }

    public List<Client> getLastSortClients(int roomId) throws IOException {
        List<Integer> clientsID = new ArrayList<>();
        List<Client> clients = new ArrayList<>();
        RoomHistoryRepository roomHistoryRepository = (RoomHistoryRepository) this.roomHistoryRepository;
        ClientRepository clientRepository = (ClientRepository) this.clientRepository;
        RoomRepository roomRepository = RoomRepository.getInstance();

        for (int i = 0; i < roomHistoryRepository.getRoomHistories().size(); i++) {
            if (roomHistoryRepository.getRoomHistories().get(i).getRoomId() == roomId)
                clientsID.add(roomHistoryRepository.getRoomHistories().get(i).getClientId());
        }

        for (int i = 0; i < clientsID.size(); i++) {
            for (int j = 0; j < clientRepository.getClients().size(); j++) {
                if (clientsID.get(i) == clientRepository.getClients().get(j).getId()) {
                    clients.add(clientRepository.getClients().get(j));
                    if (clients.get(i).getRoom() == null)
                        clients.get(i).setRoom(roomRepository.findById(roomId));
                }
            }
        }

        Collections.sort(clients, new DateComparator());

        return clients;
    }

    public void updateRoom(Room room, Integer number, Integer price, Integer capacity, Boolean free, Boolean repair, Integer numOfStars, String status) throws CloneNotSupportedException {

        room.setNumber(number);
        if (price != null)
            room.setPrice(price);

        if (capacity != null)
            room.setCapacity(capacity);

        if (free != null && status != "no")
            room.setFree(free);
        else
            System.out.println("You can't change free status");

        if (repair != null && status != "no")
            room.setFree(repair);
        else
            System.out.println("You can't change repair status");

        if (numOfStars != null)
            room.setNumOfStars(numOfStars);

        save(room);
    }

    public void setPath(String path){
        roomRepository.setPath(path);
    }

    public Room findById(int id) {
        return (Room) roomRepository.findById(id);
    }

    public List<Room> findAll() {
        return (List<Room>) roomRepository.findAll();
    }

    public void save(Entity entity) {
        roomRepository.save(entity);
    }

    public long count() {
        return roomRepository.count();
    }
}
