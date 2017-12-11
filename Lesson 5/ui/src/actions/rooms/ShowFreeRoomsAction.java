package actions.rooms;

import action.IAction;
import facade.Hotel;
import printer.Printer;

public class ShowFreeRoomsAction implements IAction {
    @Override
    public void execute() {
        Hotel hotel = Hotel.getInstance();
        Printer.printEntities(hotel.getFreeRooms());
        System.out.println("Success");
    }
}
