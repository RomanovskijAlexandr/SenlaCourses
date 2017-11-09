package com.senla.lesson5.hotelmanager.repositories;

import com.danco.training.TextFileWorker;
import com.senla.lesson5.hotelmanager.entities.Client;
import com.senla.lesson5.hotelmanager.handlers.TextHandler;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ClientRepository {
    private ArrayList<Client> clients;

    private String path = "D:\\inputClients.txt";

    public static int lastIdClient = 0;

    private static final Logger log = Logger.getLogger(ClientRepository.class.getName());

    public ClientRepository() {
        clients = new TextHandler().getClients(new TextFileWorker(path).readFromFile(), path);
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public Client findById(int id) {
        Client client = null;
        for (Client clientFind : clients) {
            if (clientFind.getId() == id) {
                client = clientFind;
                break;
            }
        }
        return client;
    }

    public List<Client> findAll() {
        return clients;
    }

    public void save(Client client) {
        this.clients.add(client);
    }

    public long count() {
        return clients.size();
    }
}

