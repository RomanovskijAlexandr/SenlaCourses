package actions.opportunities;

import action.IAction;
import facade.Hotel;

public class SortByPriceAction implements IAction {
    @Override
    public void execute() {
        Hotel hotel = Hotel.getInstance();
        hotel.sortOpportunitiesByPrice();
        System.out.println("Success");
    }
}
