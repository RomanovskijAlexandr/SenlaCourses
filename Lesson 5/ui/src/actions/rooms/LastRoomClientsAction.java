package actions.rooms;

import action.IAction;
import facade.Hotel;
import org.apache.log4j.Logger;
import printer.Printer;

import java.util.Scanner;

public class LastRoomClientsAction implements IAction {
    private static final Logger log = Logger.getLogger(Hotel.class.getName());

    @Override
    public void execute() {
        try {
            Hotel hotel = Hotel.getInstance();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input room's id: ");
            Printer.printEntities(hotel.getLastThreeClients(scanner.nextInt()));
            System.out.println("Success");
        } catch (Exception e) {
            log.info(e);
        }
    }
}
