package actions.rooms;

import action.IAction;
import facade.Hotel;
import printer.Printer;

import java.util.Scanner;

public class ShowFreeRoomsAction implements IAction {
    @Override
    public void execute(Scanner scanner) {
        Hotel hotel = Hotel.getInstance();
        Printer.printEntities(hotel.getFreeRooms());
        System.out.println("Success");
    }
}
