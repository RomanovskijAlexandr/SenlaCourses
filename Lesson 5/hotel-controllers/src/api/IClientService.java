package api;


import entities.Client;
import entities.Opportunity;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;

public interface IClientService {

    public int getPriceForRoom(int clientId);

    public ArrayList<Client> getLastThreeClients() throws ParseException;

    public ArrayList<Opportunity> getClientOpportunities(int clientId);

    public void moveOutClientFromRoom(int clientId);

    public void settleClientInRoom(int clientId, int roomId);

    public void sortClients(Comparator<Client> comparator);
}
