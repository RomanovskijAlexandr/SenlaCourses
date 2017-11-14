package comparators;

import entities.Client;

import java.util.Comparator;

public class ClientComporators {
    private Comparator<Client> nameComparator = new Comparator<Client>() {
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
    };

    private Comparator<Client> dateComparator = new Comparator<Client>() {
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
    };

    public Comparator<Client> getNameComparator() {
        return nameComparator;
    }

    public Comparator<Client> getDateComparator() {
        return dateComparator;
    }
}
