package actions.clients;

import api.IAction;
import facade.Hotel;

import java.util.Scanner;

public class OpportunityClientAction implements IAction {
    @Override
    public void execute() {
        Hotel hotel = Hotel.getInstance();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input client's id: ");
        hotel.moveOutClientFromRoom(scanner.nextInt());
        System.out.println("Success");
        scanner.close();
    }
}
