package com.senla.lesson4.task1.repositories;

import com.danco.training.TextFileWorker;
import com.senla.lesson4.task1.handlers.ArrayHandler;
import com.senla.lesson4.task1.handlers.TextHandler;
import com.senla.lesson4.task1.entities.Client;

import java.text.ParseException;

public class ClientRepository {
    private Client[] clients;

    public ClientRepository() throws ParseException {
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

