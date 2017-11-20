package actions.rooms;

import action.IAction;
import facade.Hotel;

public class RoomImportAction implements IAction {
    @Override
    public void execute() {
        Hotel hotel = Hotel.getInstance();
        hotel.importRoomsCSV();
    }
}
