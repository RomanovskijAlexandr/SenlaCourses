package actions.rooms;

import api.IAction;
import facade.Hotel;

import java.util.Scanner;

public class AddOpportunityAction implements IAction {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = Hotel.getInstance();
        System.out.println("Input new room's id: ");
        Integer roomId = scanner.nextInt();
        System.out.println("Input opportunity's id: ");
        Integer opId = scanner.nextInt();
        hotel.addOpportunity(roomId, opId);
        System.out.println("success");
    }
}
