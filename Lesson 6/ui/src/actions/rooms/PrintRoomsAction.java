package actions.rooms;

import uiactions.IAction;
import facade.Hotel;
import printer.Printer;

import java.io.IOException;
import java.util.Scanner;

import static facade.Hotel.getInstance;

public class PrintRoomsAction implements IAction {
    @Override
    public void execute(Scanner scanner) throws IOException {
        Hotel hotel = getInstance();
        Printer.printEntities(hotel.getRoomService().findAll());
        System.out.println("Success");
    }
}
