package comparators.clients;

import entities.Client;

import java.util.Comparator;

public class NameComporator implements Comparator<Client> {
    @Override
    public int compare(Client client1, Client client2) {
        if (client1 != null && client2 != null)
            return client1.getName().compareTo(client2.getName());
        else if (client1 != null && client2 == null) {
            return 1;
        } else {
            return -1;
        }
    }
}
