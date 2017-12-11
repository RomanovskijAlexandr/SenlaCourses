package handlers;

import entities.Client;
import entities.Opportunity;
import entities.Room;
import entities.RoomHistory;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringHandler {
    private static final Logger log = Logger.getLogger(StringHandler.class.getName());

    public Client getClientFromString(String object) {
        Client client = new Client();
        client.setName(object);
        return client;
    }

    public Room getRoomFromString(String object) {
        Room room = new Room();
        int j = 0;
        for (String str : object.split(" ")) {
            if (j == 0)
                room.setNumber(Integer.parseInt(str));
            if (j == 1)
                room.setPrice(Integer.parseInt(str));
            if (j == 2)
                room.setFree(Boolean.parseBoolean(str));
            if (j == 3)
                room.setRepair(Boolean.parseBoolean(str));
            if (j == 4)
                room.setCapacity(Integer.parseInt(str));
            if (j == 5)
                room.setNumOfStars(Integer.parseInt(str));
            if (j == 6)
                room.setDateEviction(parseDate(str, "yyyy-MM-dd"));
            if (j == 7)
                room.setDateOfSettle(parseDate(str, "yyyy-MM-dd"));
            j++;
        }
        return room;
    }


    public Opportunity getOpportunityFromString(String object) {
        Opportunity opportunity = new Opportunity();
        int j = 0;
        for (String str : object.split(" ")) {
            if (j == 0)
                opportunity.setName(str);
            if (j == 1)
                opportunity.setPrice(Integer.parseInt(str));
            j++;
        }

        return opportunity;
    }

    public RoomHistory getRoomHistoryFromString(String object) {
        RoomHistory roomHistory = new RoomHistory();
        int j = 0;
        for (String str : object.split(" ")) {
            if (j == 0)
                roomHistory.setClientId(Integer.parseInt(str));
            if (j == 1)
                roomHistory.setRoomId(Integer.parseInt(str));
            if (j == 2)
                roomHistory.setDateEviction(parseDate(str, "yyyy-MM-dd"));
            if (j == 3)
                roomHistory.setDateOfSettle(parseDate(str, "yyyy-MM-dd"));
            j++;
        }
        return roomHistory;
    }

    public Date parseDate(String date, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        try {
            return formatter.parse(date);
        } catch (ParseException e) {
            log.info("Parse exception in ", e);
        }
        return null;
    }
}
