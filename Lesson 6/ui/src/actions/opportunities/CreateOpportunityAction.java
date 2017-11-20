package actions.opportunities;

import action.IAction;
import facade.Hotel;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class CreateOpportunityAction implements IAction {
    private static final Logger log = Logger.getLogger(Hotel.class.getName());

    @Override
    public void execute() {
        try {
            Scanner scanner = new Scanner(System.in);
            Hotel hotel = Hotel.getInstance();
            System.out.println("Input opportunity's name: ");
            String name = scanner.nextLine();
            System.out.println("Input opportunity's price: ");
            Integer price = scanner.nextInt();
            hotel.createOpportunity(name, price);
            System.out.println("success");
        } catch (Exception e) {
            log.info(e);
        }
    }
}
