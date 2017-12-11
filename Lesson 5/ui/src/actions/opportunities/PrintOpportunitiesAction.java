package actions.opportunities;

import action.IAction;
import facade.Hotel;
import printer.Printer;

public class PrintOpportunitiesAction implements IAction {
    @Override
    public void execute() {
        Hotel hotel = Hotel.getInstance();
        Printer.printEntities(hotel.getOpportunityService().findAll());
        System.out.println("Success");
    }
}
