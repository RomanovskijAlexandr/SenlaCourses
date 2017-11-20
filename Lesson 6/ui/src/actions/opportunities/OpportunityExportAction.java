package actions.opportunities;

import action.IAction;
import facade.Hotel;

public class OpportunityExportAction implements IAction {
    @Override
    public void execute() {
        Hotel hotel = Hotel.getInstance();
        hotel.exportOpportunitiesCSV();
    }
}
