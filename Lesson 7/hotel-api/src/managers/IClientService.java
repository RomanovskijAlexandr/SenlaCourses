package managers;


import entities.Client;
import entities.Opportunity;

import java.io.IOException;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public interface IClientService {

    public int getPriceForRoom(int clientId);

    public List<Opportunity> getClientOpportunities(int clientId);

    public void moveOutClientFromRoom(int clientId);

    public void settleClientInRoom(int clientId, int roomId, Date dateOfSettle, Date dateEviction) throws IOException;

    public void sortClients(Comparator<Client> comparator);
}
