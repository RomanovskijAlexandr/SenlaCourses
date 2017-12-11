package actions.clients;

import action.IAction;
import facade.Hotel;

public class SortNameAction implements IAction {
    @Override
    public void execute() {
        Hotel hotel = Hotel.getInstance();
        hotel.sortClientsByName();
        System.out.println("Success");
    }
}
