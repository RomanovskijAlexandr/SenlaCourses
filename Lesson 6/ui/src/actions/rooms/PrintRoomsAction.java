package actions.rooms;

import action.IAction;
import facade.Hotel;
import printer.Printer;

public class PrintRoomsAction implements IAction {
    @Override
    public void execute() {
        Hotel hotel = Hotel.getInstance();
        Printer.printEntities(hotel.getRoomService().findAll());
        System.out.println("Success");
    }
}
