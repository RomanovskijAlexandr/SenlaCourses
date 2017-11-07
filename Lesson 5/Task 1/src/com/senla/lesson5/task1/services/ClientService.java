package com.senla.lesson5.task1.services;

import com.senla.lesson5.task1.comparators.ClientComporators;
import com.senla.lesson5.task1.entities.Client;
import com.senla.lesson5.task1.entities.Opportunity;
import com.senla.lesson5.task1.entities.Room;
import com.senla.lesson5.task1.interfaces.IClientService;
import com.senla.lesson5.task1.repositories.ClientRepository;

import java.util.Arrays;

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
    public Client[] getLastThreeClients() {
        Client[] clients1 = new Client[3];
        Arrays.sort(clientRepository.getClients(), new ClientComporators().getDateComparator());
        Client[] clients = clientRepository.getClients();
        clients1[0] = clients[clients.length - 3];
        clients1[1] = clients[clients.length - 2];
        clients1[2] = clients[clients.length - 1];
        return clients1;
    }

    @Override
    public Opportunity[] getClientOpportunities(int clientId) {
        return clientRepository.findById(clientId).getRoom().getOpportunities();
    }

    @Override
    public void moveOutClientFromRoom(int clientId) {
        clientRepository.findById(clientId).setRoom(null);
    }

    @Override
    public void settleClientInRoom(int clientId, Room room) {
        if (room.getFree() && !room.getRepair())
            clientRepository.findById(clientId).setRoom(room);
    }
}
