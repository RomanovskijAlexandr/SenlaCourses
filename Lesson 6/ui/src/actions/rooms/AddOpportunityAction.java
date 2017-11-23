package actions.rooms;

import action.IAction;
import facade.Hotel;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class AddOpportunityAction implements IAction {
    private static final Logger log = Logger.getLogger(Hotel.class.getName());

    @Override
    public void execute(Scanner scanner) {
        try {
            Hotel hotel = Hotel.getInstance();
            System.out.println("Input new room's id: ");
            Integer roomId = scanner.nextInt();
            System.out.println("Input opportunity's id: ");
            Integer opId = scanner.nextInt();
            hotel.addOpportunity(roomId, opId);
            System.out.println("success");
        } catch (Exception e) {
            log.info(e);
        }
    }
}
