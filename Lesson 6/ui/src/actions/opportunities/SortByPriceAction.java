package actions.opportunities;

import uiactions.IAction;
import facade.Hotel;

import java.io.IOException;
import java.util.Scanner;

public class SortByPriceAction implements IAction {
    @Override
    public void execute(Scanner scanner) throws IOException {
        Hotel hotel = Hotel.getInstance();
        hotel.sortOpportunitiesByPrice();
        System.out.println("Success");
    }
}
