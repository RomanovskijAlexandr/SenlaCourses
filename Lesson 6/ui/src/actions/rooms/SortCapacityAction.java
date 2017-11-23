package actions.rooms;

import action.IAction;
import facade.Hotel;

import java.util.Scanner;

public class SortCapacityAction implements IAction {
    @Override
    public void execute(Scanner scanner) {
        Hotel hotel = Hotel.getInstance();
        hotel.sortRoomsByCapacity();
        System.out.println("Success");
    }
}
