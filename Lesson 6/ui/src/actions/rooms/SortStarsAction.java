package actions.rooms;

import uiactions.IAction;
import facade.Hotel;

import java.io.IOException;
import java.util.Scanner;

public class SortStarsAction implements IAction {
    @Override
    public void execute(Scanner scanner) throws IOException {
        Hotel hotel = Hotel.getInstance();
        hotel.sortRoomsByStars();
        System.out.println("Success");
    }
}
