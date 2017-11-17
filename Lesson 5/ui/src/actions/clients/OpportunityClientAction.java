package actions.clients;

import action.IAction;
import facade.Hotel;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class OpportunityClientAction implements IAction {
    private static final Logger log = Logger.getLogger(Hotel.class.getName());

    @Override
    public void execute() {
        try {
            Hotel hotel = Hotel.getInstance();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input client's id: ");
            hotel.moveOutClientFromRoom(scanner.nextInt());
            System.out.println("Success");
        } catch (Exception e) {
            log.info(e);
        }
    }
}
