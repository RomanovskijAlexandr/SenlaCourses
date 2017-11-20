package actions.clients;

import action.IAction;
import facade.Hotel;

public class ClientImportAction implements IAction {
    @Override
    public void execute() {
        Hotel hotel = Hotel.getInstance();
        hotel.importClientsCSV();
    }
}
