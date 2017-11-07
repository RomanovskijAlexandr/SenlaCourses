package com.senla.lesson5.task1.repositories;

import com.danco.training.TextFileWorker;
import com.senla.lesson5.task1.entities.Client;
import com.senla.lesson5.task1.handlers.ArrayHandler;
import com.senla.lesson5.task1.handlers.TextHandler;
import org.apache.log4j.Logger;

public class ClientRepository {
    private Client[] clients;

    private static final Logger log = Logger.getLogger(ClientRepository.class.getName());

    public ClientRepository() {
        clients = new TextHandler().getClients(new TextFileWorker("D:\\inputClients.txt").readFromFile());
    }

    public Client[] getClients() {
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

    public Client[] findAll() {
        return clients;
    }

    public void save(Client client) {
        if (!new ArrayHandler().checkArrayForNewElement(clients)) {
            clients = (Client[]) new ArrayHandler().resizeArray(clients);
        }
        clients[new ArrayHandler().getPosition(clients)] = client;
    }

    public long count() {
        return clients.length;
    }
}

