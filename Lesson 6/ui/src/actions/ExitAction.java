package actions;

import action.IAction;
import facade.Hotel;

import java.util.Scanner;

public class ExitAction implements IAction {
    @Override
    public void execute(Scanner scanner) {
        System.out.println("Good bye");
        Hotel hotel = Hotel.getInstance();
        hotel.saveEntities();
    }
}
