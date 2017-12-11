package repository;

import entities.Entity;
import entities.Room;
import handlers.serialize.Reader;
import storages.IRepository;
import storage.PropertiesStorage;

import java.io.IOException;
import java.util.List;

public class RoomRepository implements IRepository {
    private List<Room> rooms;

    public static int lastIdRoom = 0;

    private PropertiesStorage propertiesStorage;

    private String path = null;

    private static RoomRepository roomRepository;

    public static RoomRepository getInstance() throws IOException {
        if (roomRepository == null) {
            roomRepository = new RoomRepository();
        }
        return roomRepository;
    }

    private RoomRepository() throws IOException {
        propertiesStorage = PropertiesStorage.getInstance();
        if(path==null)
            path = propertiesStorage.getProperties().getProperty("inputRooms");
        rooms = (List<Room>) new Reader().readEntitiesFromFile(path);
    }

    public List<Room> getRooms() {
        return rooms;
    }

    @Override
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

    @Override
    public List<Room> findAll() {
        return rooms;
    }

    @Override
    public void save(Entity entity) {
        String str = String.valueOf(entity.getId());
        if (str != null) {
            entity.setId(entity.generateId(lastIdRoom));
            lastIdRoom++;
        }
        this.rooms.add((Room) entity);
    }

    @Override
    public long count() {
        return rooms.size();
    }

    @Override
    public void setPath(String path) {
        this.path = path;
    }
}
