package repository;

import entities.Entity;
import entities.RoomHistory;
import handlers.serialize.Reader;
import storage.PropertiesStorage;

import java.util.List;

public class RoomHistoryRepository implements IRepository {

    private List<RoomHistory> roomHistories;

    private PropertiesStorage propertiesStorage;

    private static RoomHistoryRepository roomHistoryRepository;

    private String path = null;

    public static RoomHistoryRepository getInstance() {
        if (roomHistoryRepository == null) {
            roomHistoryRepository = new RoomHistoryRepository();
        }
        return roomHistoryRepository;
    }

    private RoomHistoryRepository() {
        propertiesStorage = PropertiesStorage.getInstance();
        roomHistories = (List<RoomHistory>) new Reader().readEntitiesFromFile(propertiesStorage.getProperties().getProperty("inputRoomHistories"));
    }

    public List<RoomHistory> getRoomHistories() {
        return roomHistories;
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
}