package actions.rooms;

import action.IAction;
import facade.Hotel;

import java.util.Scanner;

public class SortPriceAction implements IAction {
    @Override
    public void execute(Scanner scanner) {
        Hotel hotel = Hotel.getInstance();
        hotel.sortRoomsByPrice();
        System.out.println("Success");
    }
}
