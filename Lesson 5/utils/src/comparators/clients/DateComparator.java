package comparators.clients;

import entities.Client;

import java.util.Comparator;

public class DateComparator implements Comparator<Client> {
    @Override
    public int compare(Client client1, Client client2) {
        if (client1 != null && client2 != null)
            return client1.getRoom().getDateEviction().compareTo(client2.getRoom().getDateEviction());
        else if (client1 != null && client2 == null) {
            return 1;
        } else {
            return -1;
        }
    }
}
