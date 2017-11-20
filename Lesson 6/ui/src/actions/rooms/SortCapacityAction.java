package actions.rooms;

import action.IAction;
import facade.Hotel;

public class SortCapacityAction implements IAction {
    @Override
    public void execute() {
        Hotel hotel = Hotel.getInstance();
        hotel.sortRoomsByCapacity();
        System.out.println("Success");
    }
}
