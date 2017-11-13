package repositories;

import api.IRepository;
import com.danco.training.TextFileWorker;

import entities.Client;
import entities.Entity;
import handlers.TextHandler;

import java.util.ArrayList;
import java.util.List;

public class ClientRepository implements IRepository {
    private ArrayList<Client> clients;

    private String path = "D:\\inputClients.txt";

    public static int lastIdClient = 0;

    public ClientRepository() {
        clients = new TextHandler().getClients(new TextFileWorker(path).readFromFile(), path);
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    @Override
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

    @Override
    public List<Client> findAll() {
        return clients;
    }

    @Override
    public void save(Entity entity) {
        this.clients.add((Client) entity);
    }

    @Override
    public long count() {
        return clients.size();
    }
}

