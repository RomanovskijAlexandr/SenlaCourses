package actions.clients;

import action.IAction;
import facade.Hotel;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class CreateClientAction implements IAction {
    private static final Logger log = Logger.getLogger(Hotel.class.getName());

    @Override
    public void execute() {
        try {
            Scanner scanner = new Scanner(System.in);
            Hotel hotel = Hotel.getInstance();
            System.out.println("Input client's name: ");
            hotel.createClient(scanner.nextLine());
            System.out.println("success");
        } catch (Exception e) {
            log.info(e);
        }
    }
}
