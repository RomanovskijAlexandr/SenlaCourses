package actions.rooms;

import action.IAction;
import facade.Hotel;

import java.util.Scanner;

public class RoomImportAction implements IAction {
    @Override
    public void execute(Scanner scanner) {
        Hotel hotel = Hotel.getInstance();
        hotel.importRoomsCSV();
    }
}
