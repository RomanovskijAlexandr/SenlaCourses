package actions;

import uiactions.IAction;
import facade.Hotel;

import java.io.IOException;
import java.util.Scanner;

public class ExitAction implements IAction {
    @Override
    public void execute(Scanner scanner) throws IOException {
        System.out.println("Good bye");
        Hotel hotel = Hotel.getInstance();
        hotel.saveEntities();
    }
}
