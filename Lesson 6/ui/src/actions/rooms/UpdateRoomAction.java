package actions.rooms;

import action.IAction;
import facade.Hotel;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class UpdateRoomAction implements IAction {
    private static final Logger log = Logger.getLogger(Hotel.class.getName());
    
    @Override
    public void execute() {
        try {
            Scanner scanner = new Scanner(System.in);
            Hotel hotel = Hotel.getInstance();
            System.out.println("Input room's id: ");
            Integer id = scanner.nextInt();
            System.out.println("Input new price: ");
            Integer price = scanner.nextInt();
            System.out.println("Input new capacity: ");
            Integer capacity = scanner.nextInt();
            System.out.println("Input free status (true or false): ");
            Boolean free = scanner.nextBoolean();
            System.out.println("Input repair status (true or false): ");
            Boolean repair = scanner.nextBoolean();
            System.out.println("Input new number of stars: ");
            Integer numOfStars = scanner.nextInt();
            hotel.updateRoom(id, price, capacity, free, repair, numOfStars);
            System.out.println("success");
        } catch (Exception e) {
            log.info(e);
        }
    }
}
