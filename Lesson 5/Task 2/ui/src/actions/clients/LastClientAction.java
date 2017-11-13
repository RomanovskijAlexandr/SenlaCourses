package actions.clients;

import api.IAction;
import facade.Hotel;

public class LastClientAction implements IAction {
    @Override
    public void execute() {
        Hotel hotel = Hotel.getInstance();
        hotel.getLastThreeClients();
        System.out.println("Success");
    }
}
