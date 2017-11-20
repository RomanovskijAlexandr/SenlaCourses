package actions.rooms;

import action.IAction;
import facade.Hotel;

public class RoomExportAction implements IAction {
    @Override
    public void execute() {
        Hotel hotel = Hotel.getInstance();
        hotel.exportRoomsCSV();
    }
}
