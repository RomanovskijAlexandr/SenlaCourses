package com.senla.lesson4.task1.handlers;

import com.senla.lesson4.task1.entities.Client;
import com.senla.lesson4.task1.entities.Opportunity;
import com.senla.lesson4.task1.entities.Room;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringHandler {

    public Client getClientFromString(String object) throws ParseException {
        Client client = new Client();
        client.setName(object);
        return client;
    }

    public Room getRoomFromString(String object) throws ParseException {
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
        DateFormat dateFormat = new SimpleDateFormat();
        for (String str : object.split(" ")) {
            if (j == 0)
                opportunity.setName(str);
            if (j == 1)
                opportunity.setPrice(Integer.parseInt(str));
            j++;
        }

        return opportunity;
    }

    private Date parseDate(String date, String format) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.parse(date);
    }
}
