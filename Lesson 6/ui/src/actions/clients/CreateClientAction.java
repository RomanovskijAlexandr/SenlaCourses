package actions.clients;

import uiactions.IAction;
import facade.Hotel;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class CreateClientAction implements IAction {
    private static final Logger log = Logger.getLogger(Hotel.class.getName());

    @Override
    public void execute(Scanner scanner) {
        try {
            Hotel hotel = Hotel.getInstance();
            System.out.println("Input client's name: ");
            hotel.createClient(scanner.next());
            System.out.println("success");
        } catch (Exception e) {
            log.info(e);
        }
    }
}
