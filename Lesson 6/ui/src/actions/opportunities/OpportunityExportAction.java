package actions.opportunities;

import action.IAction;
import facade.Hotel;

import java.util.Scanner;

public class OpportunityExportAction implements IAction {
    @Override
    public void execute(Scanner scanner) {
        Hotel hotel = Hotel.getInstance();
        hotel.exportOpportunitiesCSV();
    }
}
