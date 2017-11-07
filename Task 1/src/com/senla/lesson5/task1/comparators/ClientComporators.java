package com.senla.lesson5.task1.comparators;

import com.senla.lesson5.task1.entities.Client;

import java.util.Comparator;

public class ClientComporators {
    private Comparator<Client> nameComparator = new Comparator<Client>() {
        @Override
        public int compare(Client client1, Client client2) {
            return client1.getName().compareTo(client2.getName());
        }
    };

    private Comparator<Client> dateComparator = new Comparator<Client>() {
        @Override
        public int compare(Client client1, Client client2) {
            return client1.getRoom().getDateEviction().compareTo(client2.getRoom().getDateEviction());
        }
    };

    public Comparator<Client> getNameComparator() {
        return nameComparator;
    }

    public Comparator<Client> getDateComparator() {
        return dateComparator;
    }
}
