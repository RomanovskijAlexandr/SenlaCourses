package actions.clients;

import action.IAction;
import facade.Hotel;
import printer.Printer;

public class PrintClientsAction implements IAction {
    @Override
    public void execute() {
        Hotel hotel = Hotel.getInstance();
        Printer.printEntities(hotel.getClientService().findAll());
        System.out.println("Success");
    }
}
