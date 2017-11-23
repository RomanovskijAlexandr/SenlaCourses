package actions.opportunities;

import action.IAction;
import facade.Hotel;
import printer.Printer;

import java.util.Scanner;

public class PrintOpportunitiesAction implements IAction {
    @Override
    public void execute(Scanner scanner) {
        Hotel hotel = Hotel.getInstance();
        Printer.printEntities(hotel.getOpportunityService().findAll());
        System.out.println("Success");
    }
}
