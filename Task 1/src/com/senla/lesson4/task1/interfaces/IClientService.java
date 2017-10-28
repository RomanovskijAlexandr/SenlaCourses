package com.senla.lesson4.task1.interfaces;

import com.senla.lesson4.task1.entities.Client;
import com.senla.lesson4.task1.entities.Opportunity;
import com.senla.lesson4.task1.entities.Room;

public interface IClientService {

    public void sortClientsByName();

    public Client[] sortClientsByDateEviction();

    public int getPriceForRoom(int clientId);

    public Client[] getLastThreeClients();

    public Opportunity[] getClientOpportunities(int clientId);

    public void moveOutClientFromRoom(int clientId);

    public void settleClientInRoom(int clientId, Room room);
}
