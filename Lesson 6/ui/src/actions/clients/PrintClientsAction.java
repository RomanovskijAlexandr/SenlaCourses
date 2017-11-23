package actions.clients;

import action.IAction;
import facade.Hotel;
import printer.Printer;

import java.util.Scanner;

public class PrintClientsAction implements IAction {
    @Override
    public void execute(Scanner scanner) {
        Hotel hotel = Hotel.getInstance();
        Printer.printEntities(hotel.getClientService().findAll());
        System.out.println("Success");
    }
}
