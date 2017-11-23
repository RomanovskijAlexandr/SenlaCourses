package actions.rooms;

import action.IAction;
import facade.Hotel;
import printer.Printer;

import java.util.Scanner;

public class PrintRoomsAction implements IAction {
    @Override
    public void execute(Scanner scanner) {
        Hotel hotel = Hotel.getInstance();
        Printer.printEntities(hotel.getRoomService().findAll());
        System.out.println("Success");
    }
}
