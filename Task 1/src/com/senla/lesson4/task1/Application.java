package com.senla.lesson4.task1;

import com.senla.lesson4.task1.facade.Hotel;

import java.text.ParseException;

public class Application {

    public static void main(String[] args) throws ParseException {
        Hotel hotel = new Hotel();
        hotel.workWithClientEntities();
        hotel.workWithOpportunityEntities();
        hotel.workWithRoomEntities();
    }
}
