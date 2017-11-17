package actions.opportunities;

import action.IAction;
import facade.Hotel;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class ChangePriceAction implements IAction {
    private static final Logger log = Logger.getLogger(Hotel.class.getName());

    @Override
    public void execute() {
        try {
            Scanner scanner = new Scanner(System.in);
            Hotel hotel = Hotel.getInstance();
            System.out.println("Input opportunity's id: ");
            Integer opId = scanner.nextInt();
            System.out.println("Input new opportunity's price: ");
            Integer opPrice = scanner.nextInt();
            hotel.changeOpportunitiesPrice(opId, opPrice);
            System.out.println("success");
        } catch (Exception e) {
            log.info(e);
        }
    }
}
