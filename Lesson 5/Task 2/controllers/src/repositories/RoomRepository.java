package repositories;

import api.IRepository;
import com.danco.training.TextFileWorker;
import entities.Entity;
import entities.Room;
import handlers.TextHandler;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class RoomRepository implements IRepository{
    private ArrayList<Room> rooms;

    public static int lastIdRoom = 0;

    private String path = "D:\\inputRooms.txt";

    public RoomRepository() {
        rooms = new TextHandler().getRooms(new TextFileWorker(path).readFromFile(), path);
    }

    public ArrayList<Room> getRooms() {
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
    public ArrayList<Room> findAll() {
        return rooms;
    }

    @Override
    public void save(Entity entity) {
        this.rooms.add((Room) entity);
    }

    @Override
    public long count() {
        return rooms.size();
    }
}
