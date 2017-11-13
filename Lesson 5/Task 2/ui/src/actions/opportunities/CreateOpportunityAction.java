package actions.opportunities;

import api.IAction;
import facade.Hotel;

import java.util.Scanner;

public class CreateOpportunityAction implements IAction {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = Hotel.getInstance();
        System.out.println("Input opportunity's name: ");
        String name = scanner.nextLine();
        System.out.println("Input opportunity's price: ");
        Integer price = scanner.nextInt();
        hotel.createOpportunity(name, price);
        System.out.println("success");
        scanner.close();
    }
}
