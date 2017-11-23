package actions.opportunities;

import action.IAction;
import facade.Hotel;

import java.util.Scanner;

public class SortByPriceAction implements IAction {
    @Override
    public void execute(Scanner scanner) {
        Hotel hotel = Hotel.getInstance();
        hotel.sortOpportunitiesByPrice();
        System.out.println("Success");
    }
}
