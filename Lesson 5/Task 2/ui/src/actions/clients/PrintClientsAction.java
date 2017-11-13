package actions.clients;

import api.IAction;
import facade.Hotel;

public class PrintClientsAction implements IAction {
    @Override
    public void execute() {
        Hotel hotel = Hotel.getInstance();
        hotel.printEntities(hotel.getClientService().findAll());
        System.out.println("Success");
    }
}
