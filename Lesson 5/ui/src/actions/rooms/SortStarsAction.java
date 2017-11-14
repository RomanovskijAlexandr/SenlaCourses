package actions.rooms;

import api.IAction;
import facade.Hotel;

public class SortStarsAction implements IAction {
    @Override
    public void execute() {
        Hotel hotel = Hotel.getInstance();
        hotel.sortRoomsByStars();
        System.out.println("Success");
    }
}
