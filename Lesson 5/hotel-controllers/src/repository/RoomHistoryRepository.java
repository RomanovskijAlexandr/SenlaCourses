package repository;

import entities.Entity;
import entities.RoomHistory;
import handlers.TextHandler;

import java.util.List;

public class RoomHistoryRepository implements IRepository {

    private List<RoomHistory> roomHistories;

    private static RoomHistoryRepository roomHistoryRepository;

    private String path = null;

    public static RoomHistoryRepository getInstance() {
        if (roomHistoryRepository == null) {
            roomHistoryRepository = new RoomHistoryRepository();
        }
        return roomHistoryRepository;
    }

    private RoomHistoryRepository() {
        roomHistories = new TextHandler().getRoomHistories(path);
    }

    public List<RoomHistory> getRoomHistories() {
        return roomHistories;
    }

    @Override
    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public RoomHistory findById(int id) {
        RoomHistory roomHistory = null;
        for (RoomHistory roomHistoryFind : roomHistories) {
            if (roomHistoryFind.getId() == id) {
                roomHistory = roomHistoryFind;
                break;
            }
        }
        return roomHistory;
    }

    @Override
    public List<RoomHistory> findAll() {
        return roomHistories;
    }

    @Override
    public void save(Entity entity) {
        this.roomHistories.add((RoomHistory) entity);
    }

    @Override
    public long count() {
        return roomHistories.size();
    }

    @Override
    public String getPath() {
        return this.path;
    }
}
