package actions.clients;

import action.IAction;
import facade.Hotel;

public class SortDateAction implements IAction {
    @Override
    public void execute() {
        Hotel hotel = Hotel.getInstance();
        hotel.sortClientsByDate();
        System.out.println("Success");
    }
}
