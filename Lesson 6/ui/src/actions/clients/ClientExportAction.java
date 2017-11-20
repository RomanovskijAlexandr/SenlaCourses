package actions.clients;

import action.IAction;
import facade.Hotel;

public class ClientExportAction implements IAction {
    @Override
    public void execute() {
        Hotel hotel = Hotel.getInstance();
        hotel.exportClientsCSV();
    }
}
