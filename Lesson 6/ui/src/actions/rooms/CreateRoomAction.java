package actions.rooms;

import action.IAction;
import facade.Hotel;
import handlers.StringHandler;
import org.apache.log4j.Logger;

import java.util.Date;
import java.util.Scanner;

public class CreateRoomAction implements IAction {
    private static final Logger log = Logger.getLogger(Hotel.class.getName());

    @Override
    public void execute(Scanner scanner) {
        try {
            Hotel hotel = Hotel.getInstance();
            System.out.println("Input room's nunmber: ");
            Integer number = scanner.nextInt();
            System.out.println("Input room's price: ");
            Integer price = scanner.nextInt();
            System.out.println("Input room's capacity: ");
            Integer capacity = scanner.nextInt();
            System.out.println("Input room's stars: ");
            Integer numOfStars = scanner.nextInt();
            System.out.println("Input room's date of eviction (format: yyyy-MM-dd) : ");
            Date dateOfEviction = new StringHandler().parseDate(scanner.next(), "yyyy-MM-dd");
            System.out.println("Input room's date of settle (format: yyyy-MM-dd) : ");
            Date dateOfSettle = new StringHandler().parseDate(scanner.next(), "yyyy-MM-dd");
            hotel.createRoom(number, price, capacity, numOfStars, dateOfEviction, dateOfSettle);
            System.out.println("success");
        } catch (Exception e) {
            log.info(e);
        }
    }
}
