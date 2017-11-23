package repository;

import entities.Client;
import entities.Entity;
import handlers.serialize.Reader;
import storage.PropertiesStorage;

import java.util.List;

public class ClientRepository implements IRepository {
    private List<Client> clients;

    public static int lastIdClient = 0;

    private PropertiesStorage propertiesStorage;

    private static ClientRepository clientRepository;

    private String path = null;

    public static ClientRepository getInstance() {
        if (clientRepository == null) {
            clientRepository = new ClientRepository();
        }
        return clientRepository;
    }

    private ClientRepository() {
        propertiesStorage = PropertiesStorage.getInstance();
        if(path==null)
            path = propertiesStorage.getProperties().getProperty("inputClients");
        clients = (List<Client>) new Reader().readEntitiesFromFile(path);
    }

    @Override
    public void setPath(String path) {
        this.path = path;
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
}

