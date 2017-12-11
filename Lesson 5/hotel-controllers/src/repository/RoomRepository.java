package repository;

import entities.Entity;
import entities.Room;
import handlers.TextHandler;

import java.util.List;

public class RoomRepository implements IRepository {
    private List<Room> rooms;

    public static int lastIdRoom = 0;

    private String path = null;

    private static RoomRepository roomRepository;

    public static RoomRepository getInstance() {
        if (roomRepository == null) {
            roomRepository = new RoomRepository();
        }
        return roomRepository;
    }

    private RoomRepository() {
        rooms = new TextHandler().getRooms(path);
    }

    public List<Room> getRooms() {
        return rooms;
    }

    @Override
    public void setPath(String path) {
        this.path = path;
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
    public String getPath() {
        return this.path;
    }
}
