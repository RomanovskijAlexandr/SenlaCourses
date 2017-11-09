package com.senla.lesson5.hotelmanager;

import com.senla.lesson5.hotelmanager.facade.Hotel;
import com.senla.lesson5.hotelmanager.repositories.InitData;

import org.apache.log4j.Logger;


public class Application {
    private static final Logger log = Logger.getLogger(Application.class.getName());

    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        new InitData().generateData(hotel.getClientService().getClientRepository(), hotel.getRoomService().getRoomRepository(), hotel.getOpportunityService().getOpportunityRepository());
        log.info("create entities");
        hotel.getClientService().settleClientInRoom(0, hotel.getRoomService().getRoomRepository().getRooms().get(0));
        hotel.getClientService().settleClientInRoom(1, hotel.getRoomService().getRoomRepository().getRooms().get(1));
        hotel.getClientService().settleClientInRoom(2, hotel.getRoomService().getRoomRepository().getRooms().get(2));
        hotel.sortClientsByDate();
        hotel.printClients(hotel.getClientService().getClientRepository().getClients());
        hotel.printClients(hotel.getClientService().getLastThreeClients());
        System.out.println(hotel.getClientService().getPriceForRoom(0));

        hotel.sortOpportunitiesByPrice();
        hotel.printOpportunities(hotel.getOpportunityService().getOpportunityRepository().findAll());
        hotel.getOpportunityService().changeOpportunitiesPrice(0, 122);
        hotel.printOpportunities(hotel.getOpportunityService().getOpportunityRepository().getOpportunities());

        System.out.println(hotel.getRoomService().getRoomDetails(1).toString());
        hotel.sortRoomsByCapacity();
        hotel.printRooms(hotel.getRoomService().getRoomRepository().getRooms());
        hotel.sortRoomsByPrice();
        hotel.printRooms(hotel.getRoomService().getRoomRepository().getRooms());
        hotel.getRoomService().changeRoomPrice(0, 234);
        hotel.printRooms(hotel.getRoomService().getRoomRepository().getRooms());
    }
}
