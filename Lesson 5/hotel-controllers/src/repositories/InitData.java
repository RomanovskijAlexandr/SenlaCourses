package repositories;

import entities.Client;
import entities.Opportunity;
import entities.Room;
import handlers.StringHandler;
import org.apache.log4j.Logger;

public class InitData {

    private static final Logger log = Logger.getLogger(InitData.class.getName());

    public InitData() {
    }

    public void generateData(ClientRepository clientRepository, RoomRepository roomRepository, OpportunityRepository opportunityRepository) {
        StringHandler stringHandler = new StringHandler();

        Client client = new Client("Jack");
        Client client1 = new Client("Ben");
        Client client2 = new Client("Clark");

        Room room = null;
        Room room1 = null;
        Room room2 = null;
        room = new Room(310, 127, 2, 3, stringHandler.parseDate("2017-09-23", "yyyy-dd-mm"),
                stringHandler.parseDate("2017-09-17", "yyyy-dd-mm"));

        room1 = new Room(315, 93, 1, 4, stringHandler.parseDate("2017-08-21", "yyyy-dd-mm"),
                stringHandler.parseDate("2017-08-13", "yyyy-dd-mm"));

        room2 = new Room(271, 160, 2, 5, stringHandler.parseDate("2017-09-10", "yyyy-dd-mm"),
                stringHandler.parseDate("2017-09-06", "yyyy-dd-mm"));


        Opportunity opportunity = new Opportunity("cook", 200);
        Opportunity opportunity1 = new Opportunity("clean windows", 300);

        room.setOpportunity(opportunity);
        room1.setOpportunity(opportunity1);
        room2.setOpportunity(opportunity);

        client.setRoom(room);
        client1.setRoom(room1);
        client2.setRoom(room2);

        clientRepository.save(client);
        clientRepository.save(client1);
        clientRepository.save(client2);

        roomRepository.save(room);
        roomRepository.save(room1);
        roomRepository.save(room2);

        opportunityRepository.save(opportunity);
        opportunityRepository.save(opportunity1);
    }


}
