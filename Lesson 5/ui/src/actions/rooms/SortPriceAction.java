package actions.rooms;

import api.IAction;
import facade.Hotel;

public class SortPriceAction implements IAction {
    @Override
    public void execute() {
        Hotel hotel = Hotel.getInstance();
        hotel.sortRoomsByPrice();
        System.out.println("Success");
    }
}
