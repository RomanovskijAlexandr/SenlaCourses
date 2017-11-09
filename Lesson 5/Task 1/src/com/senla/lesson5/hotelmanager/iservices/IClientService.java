package com.senla.lesson5.hotelmanager.iservices;

import com.senla.lesson5.hotelmanager.entities.Client;
import com.senla.lesson5.hotelmanager.entities.Opportunity;
import com.senla.lesson5.hotelmanager.entities.Room;

import java.text.ParseException;
import java.util.ArrayList;

public interface IClientService {

    public int getPriceForRoom(int clientId);

    public ArrayList<Client> getLastThreeClients() throws ParseException;

    public ArrayList<Opportunity> getClientOpportunities(int clientId);

    public void moveOutClientFromRoom(int clientId);

    public void settleClientInRoom(int clientId, Room room);

    public void printClients(ArrayList<Client> clients);
}
