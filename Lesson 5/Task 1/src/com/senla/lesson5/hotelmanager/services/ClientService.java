package com.senla.lesson5.hotelmanager.services;

import com.senla.lesson5.hotelmanager.comparators.ClientComporators;
import com.senla.lesson5.hotelmanager.entities.Client;
import com.senla.lesson5.hotelmanager.entities.Opportunity;
import com.senla.lesson5.hotelmanager.entities.Room;
import com.senla.lesson5.hotelmanager.iservices.IClientService;
import com.senla.lesson5.hotelmanager.repositories.ClientRepository;

import java.util.ArrayList;
import java.util.Collections;

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
        Collections.sort(clientRepository.getClients(), new ClientComporators().getDateComparator());
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
    public void settleClientInRoom(int clientId, Room room) {
        if (room.getFree() && !room.getRepair())
            clientRepository.findById(clientId).setRoom(room);
    }

    @Override
    public void printClients(ArrayList<Client> clients) {
        StringBuilder[] sb = new StringBuilder[clients.size()];
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i) != null)
                sb[i] = new StringBuilder(clients.get(i).toString());
        }
        for (int i = 0; i < clients.size(); i++) {
            System.out.println(sb[i].toString());
        }
        System.out.println("\n");
    }
}
