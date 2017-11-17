package services;

import entities.*;
import repository.ClientRepository;
import repository.IRepository;
import repository.RoomHistoryRepository;
import repository.RoomRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class ClientService implements IClientService {
    private ClientRepository clientRepository = ClientRepository.getInstance();

    private IRepository roomHistoryRepository = RoomHistoryRepository.getInstance();

    public ClientService() {
    }

    public ClientRepository getClientRepository() {
        return clientRepository;
    }

    @Override
    public int getPriceForRoom(int clientId) {
        Client client = clientRepository.findById(clientId);
        int price = (int) ((client.getRoom().getDateOfSettle().getTime() -
                client.getRoom().getDateEviction().getTime()) / (86400000))
                * client.getRoom().getPrice();
        return price;
    }

    @Override
    public List<Opportunity> getClientOpportunities(int clientId) {
        Client client = clientRepository.findById(clientId);
        return client.getRoom().getOpportunities();
    }

    @Override
    public void moveOutClientFromRoom(int clientId) {
        Client client = clientRepository.findById(clientId);
        client.setRoom(null);
    }

    @Override
    public void settleClientInRoom(int clientId, int roomId, Date dateOfSettle, Date dateEviction) {
        Room room = RoomRepository.getInstance().findById(roomId);
        Client client = clientRepository.findById(clientId);
        if (room.getFree() && !room.getRepair()) {
            RoomHistory roomHistory = new RoomHistory(clientId, roomId, dateOfSettle, dateEviction);
            roomHistoryRepository.save(roomHistory);
            client.setRoom(room);
        }
    }

    @Override
    public void sortClients(Comparator<Client> comparator) {
        Collections.sort(clientRepository.getClients(), comparator);
    }

    //ClientRepository

    public Client findById(int id) {
        return clientRepository.findById(id);
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public void save(Entity entity) {
        clientRepository.save(entity);
    }

    public long count() {
        return clientRepository.count();
    }

    public void setPath(String path) {
        clientRepository.setPath(path);
    }

    public String getPath() {
        return clientRepository.getPath();
    }
}
