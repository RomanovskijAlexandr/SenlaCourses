package repository;

import entities.Client;
import entities.Entity;
import handlers.TextHandler;

import java.util.List;

public class ClientRepository implements IRepository {
    private List<Client> clients;

    private String path = null;

    public static int lastIdClient = 0;

    private static ClientRepository clientRepository;

    public static ClientRepository getInstance() {
        if (clientRepository == null) {
            clientRepository = new ClientRepository();
        }
        return clientRepository;
    }

    private ClientRepository() {
        clients = new TextHandler().getClients(path);
    }

    public List<Client> getClients() {
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
        String str = String.valueOf(entity.getId());
        if (str != null) {
            entity.setId(entity.generateId(lastIdClient));
            lastIdClient++;
        }

        this.clients.add((Client) entity);
    }

    @Override
    public long count() {
        return clients.size();
    }


    @Override
    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String getPath() {
        return this.path;
    }
}

