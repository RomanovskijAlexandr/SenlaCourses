package services;

import api.IClientService;
import comparators.ClientComporators;
import entities.Client;
import entities.Entity;
import entities.Opportunity;
import entities.Room;
import repositories.ClientRepository;
import repositories.RoomRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ClientService implements IClientService {
    private ClientRepository clientRepository = new ClientRepository();

    public ClientService() {
    }

    public ClientRepository getClientRepository() {
        return clientRepository;
    }

    @Override
    public int getPriceForRoom(int clientId) {
        int price = (int) ((clientRepository.findById(clientId).getRoom().getDateOfSettle().getTime() -
                clientRepository.findById(clientId).getRoom().getDateEviction().getTime()) / (86400000))
                * clientRepository.findById(clientId).getRoom().getPrice();
        return price;
    }

    @Override
    public ArrayList<Client> getLastThreeClients() {
        ArrayList<Client> clients1 = new ArrayList<>(3);
        sortClients(new ClientComporators().getDateComparator());
        ArrayList<Client> clients = clientRepository.getClients();
        clients1.add(0, clients.get(clients.size() - 3));
        clients1.add(1, clients.get(clients.size() - 2));
        clients1.add(2, clients.get(clients.size() - 1));
        return clients1;
    }

    @Override
    public ArrayList<Opportunity> getClientOpportunities(int clientId) {
        return clientRepository.findById(clientId).getRoom().getOpportunities();
    }

    @Override
    public void moveOutClientFromRoom(int clientId) {
        clientRepository.findById(clientId).setRoom(null);
    }

    @Override
    public void settleClientInRoom(int clientId, int roomId) {
        Room room = new RoomRepository().findById(roomId);
        if (room.getFree() && !room.getRepair()){
            clientRepository.findById(clientId).setRoom(room);

        }
    }

    @Override
    public void sortClients(Comparator<Client> comparator){
        Collections.sort(clientRepository.getClients(), comparator);
    }

    //ClientRepository

    public Client findById(int id){
        return clientRepository.findById(id);
    }

    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    public void save(Entity entity){
        clientRepository.save(entity);
    }

    public long count(){
        return clientRepository.count();
    }
}
