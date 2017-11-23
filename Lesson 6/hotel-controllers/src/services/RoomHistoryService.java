package services;

import entities.Entity;
import entities.RoomHistory;
import repository.IRepository;
import repository.RoomHistoryRepository;

import java.util.List;

public class RoomHistoryService {
    private IRepository roomHistoryRepository;


    public RoomHistoryService() {
        this.roomHistoryRepository = RoomHistoryRepository.getInstance();
    }

    public RoomHistoryRepository getRoomHistoryRepository() {
        return (RoomHistoryRepository) roomHistoryRepository;
    }


    //RoomHistoryRepository

    public void setPath(String path){
        roomHistoryRepository.setPath(path);
    }

    public RoomHistory findById(int id) {

        return (RoomHistory) roomHistoryRepository.findById(id);
    }


    public List<RoomHistory> findAll() {
        return (List<RoomHistory>) roomHistoryRepository.findAll();
    }


    public void save(Entity entity) {
        roomHistoryRepository.save(entity);
    }


    public long count() {
        return roomHistoryRepository.count();
    }
}
