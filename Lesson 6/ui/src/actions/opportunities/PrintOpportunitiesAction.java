package actions.opportunities;

import uiactions.IAction;
import facade.Hotel;
import printer.Printer;

import java.io.IOException;
import java.util.Scanner;

public class PrintOpportunitiesAction implements IAction {
    @Override
    public void execute(Scanner scanner) throws IOException {
        Hotel hotel = Hotel.getInstance();
        Printer.printEntities(hotel.getOpportunityService().findAll());
        System.out.println("Success");
    }
}
