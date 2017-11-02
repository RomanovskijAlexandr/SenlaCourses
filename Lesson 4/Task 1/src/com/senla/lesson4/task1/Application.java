package com.senla.lesson4.task1;

import com.senla.lesson4.task1.facade.Hotel;

import java.text.ParseException;

public class Application {

    public static void main(String[] args) throws ParseException {
        Hotel hotel = new Hotel();

        hotel.getClientService().settleClientInRoom(0, hotel.getRoomService().getRoomRepository().getRooms()[0]);
        hotel.getClientService().settleClientInRoom(1, hotel.getRoomService().getRoomRepository().getRooms()[1]);
        hotel.getClientService().settleClientInRoom(2, hotel.getRoomService().getRoomRepository().getRooms()[2]);
        hotel.sortClientsByDate();
        hotel.printEntities(hotel.getClientService().getClientRepository().getClients());
        hotel.printEntities(hotel.getClientService().getLastThreeClients());
        System.out.println(hotel.getClientService().getPriceForRoom(0));
        hotel.getTextHandler().writeEntitiesToFile(hotel.getClientService().getClientRepository().getClients());

        hotel.sortOpportunitiesByPrice();
        hotel.printEntities(hotel.getOpportunityService().getOpportunityRepository().getOpportunities());
        hotel.getOpportunityService().changeOpportunitiesPrice(0, 122);
        hotel.printEntities(hotel.getOpportunityService().getOpportunityRepository().getOpportunities());

        System.out.println(hotel.getRoomService().getRoomDetails(1).toString());
        hotel.sortRoomsByCapacity();
        hotel.printEntities(hotel.getRoomService().getRoomRepository().getRooms());
        hotel.sortRoomsByPrice();
        hotel.printEntities(hotel.getRoomService().getRoomRepository().getRooms());
        hotel.getRoomService().changeRoomPrice(0, 234);
        hotel.printEntities(hotel.getRoomService().getRoomRepository().getRooms());
    }
}
