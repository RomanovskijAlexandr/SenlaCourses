package actions.clients;

import uiactions.IAction;
import facade.Hotel;

import java.io.IOException;
import java.util.Scanner;

public class SortNameAction implements IAction {
    @Override
    public void execute(Scanner scanner) throws IOException {
        Hotel hotel = Hotel.getInstance();
        hotel.sortClientsByName();
        System.out.println("Success");
    }
}
