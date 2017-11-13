package actions.opportunities;

import api.IAction;
import facade.Hotel;

public class PrintOpportunitiesAction implements IAction {
    @Override
    public void execute() {
        Hotel hotel = Hotel.getInstance();
        hotel.printEntities(hotel.getOpportunityService().findAll());
        System.out.println("Success");
    }
}
