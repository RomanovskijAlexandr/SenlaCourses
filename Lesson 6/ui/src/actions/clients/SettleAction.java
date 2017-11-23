package actions.clients;

import action.IAction;
import facade.Hotel;
import handlers.StringHandler;
import org.apache.log4j.Logger;

import java.util.Date;
import java.util.Scanner;

public class SettleAction implements IAction {
    private static final Logger log = Logger.getLogger(Hotel.class.getName());

    @Override
    public void execute(Scanner scanner) {
        try {
            Hotel hotel = Hotel.getInstance();
            System.out.println("Input client's id: ");
            Integer idClient = scanner.nextInt();
            System.out.println("Input room's id: ");
            Integer idRoom = scanner.nextInt();
            System.out.println("Input room's date of eviction (format: yyyy-MM-dd) : ");
            Date dateOfEviction = new StringHandler().parseDate(scanner.next(), "yyyy-MM-dd");
            System.out.println("Input room's date of settle (format: yyyy-MM-dd) : ");
            Date dateOfSettle = new StringHandler().parseDate(scanner.next(), "yyyy-MM-dd");
            hotel.settleClientInRoom(idClient, idRoom, dateOfEviction, dateOfSettle);
            System.out.println("Success");
        } catch (Exception e) {
            log.info(e);
        }
    }
}
