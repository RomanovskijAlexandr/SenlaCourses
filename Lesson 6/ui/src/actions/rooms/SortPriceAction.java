package actions.rooms;

import uiactions.IAction;
import facade.Hotel;

import java.io.IOException;
import java.util.Scanner;

public class SortPriceAction implements IAction {
    @Override
    public void execute(Scanner scanner) throws IOException {
        Hotel hotel = Hotel.getInstance();
        hotel.sortRoomsByPrice();
        System.out.println("Success");
    }
}
