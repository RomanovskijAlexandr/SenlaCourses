package actions.rooms;

import api.IAction;
import facade.Hotel;

public class PrintRoomsAction implements IAction {
    @Override
    public void execute() {
        Hotel hotel = Hotel.getInstance();
        hotel.printEntities(hotel.getRoomService().findAll());
        System.out.println("Success");
    }
}
