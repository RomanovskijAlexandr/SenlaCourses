package actions.rooms;

import uiactions.IAction;
import facade.Hotel;
import printer.Printer;

import java.io.IOException;
import java.util.Scanner;

public class ShowFreeRoomsAction implements IAction {
    @Override
    public void execute(Scanner scanner) throws IOException {
        Hotel hotel = Hotel.getInstance();
        Printer.printEntities(hotel.getFreeRooms());
        System.out.println("Success");
    }
}
