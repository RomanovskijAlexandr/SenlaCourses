package actions.opportunities;

import api.IAction;
import facade.Hotel;

import java.util.Scanner;

public class ChangePriceAction implements IAction {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = Hotel.getInstance();
        System.out.println("Input opportunity's id: ");
        Integer opId = scanner.nextInt();
        System.out.println("Input new opportunity's price: ");
        Integer opPrice = scanner.nextInt();
        hotel.changeOpportunitiesPrice(opId, opPrice);
        System.out.println("success");
        scanner.close();
    }
}
