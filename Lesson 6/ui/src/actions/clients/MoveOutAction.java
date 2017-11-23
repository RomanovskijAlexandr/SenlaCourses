package actions.clients;

import action.IAction;
import facade.Hotel;

import java.util.Scanner;

public class MoveOutAction implements IAction {
    @Override
    public void execute(Scanner scanner) {
        Hotel hotel = Hotel.getInstance();
        System.out.println("Input client's id: ");
        hotel.moveOutClientFromRoom(scanner.nextInt());
        System.out.println("Sccess");
    }
}
