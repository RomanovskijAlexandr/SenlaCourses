package actions.clients;

import uiactions.IAction;
import facade.Hotel;
import printer.Printer;

import java.io.IOException;
import java.util.Scanner;

public class PrintClientsAction implements IAction {
    @Override
    public void execute(Scanner scanner) throws IOException {
        Hotel hotel = Hotel.getInstance();
        Printer.printEntities(hotel.getClientService().findAll());
        System.out.println("Success");
    }
}
