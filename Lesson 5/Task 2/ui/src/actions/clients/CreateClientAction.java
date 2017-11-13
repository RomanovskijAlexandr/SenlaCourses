package actions.clients;

import api.IAction;
import facade.Hotel;

import java.util.Scanner;

public class CreateClientAction implements IAction {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = Hotel.getInstance();
        System.out.println("Input client's name: ");
        hotel.createClient(scanner.nextLine());
        System.out.println("success");
        scanner.close();
    }
}
