package actions.clients;

import uiactions.IAction;
import facade.Hotel;

import java.io.IOException;
import java.util.Scanner;

public class MoveOutAction implements IAction {
    @Override
    public void execute(Scanner scanner) throws IOException {
        Hotel hotel = Hotel.getInstance();
        System.out.println("Input client's id: ");
        hotel.moveOutClientFromRoom(scanner.nextInt());
        System.out.println("Sccess");
    }
}
