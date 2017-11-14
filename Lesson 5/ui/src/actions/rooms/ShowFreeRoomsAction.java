package actions.rooms;

import api.IAction;
import facade.Hotel;

public class ShowFreeRoomsAction implements IAction {
    @Override
    public void execute() {
        Hotel hotel = Hotel.getInstance();
        hotel.printEntities(hotel.getFreeRooms());
        System.out.println("Success");
    }
}
