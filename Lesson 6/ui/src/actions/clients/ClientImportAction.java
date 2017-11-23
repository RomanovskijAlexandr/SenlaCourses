package actions.clients;

import action.IAction;
import facade.Hotel;

import java.util.Scanner;

public class ClientImportAction implements IAction {
    @Override
    public void execute(Scanner scanner) {
        Hotel hotel = Hotel.getInstance();
        hotel.importClientsCSV();
    }
}
