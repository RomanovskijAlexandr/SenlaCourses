package actions.rooms;

import action.IAction;
import facade.Hotel;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class CloneRoomAction implements IAction {
    private static final Logger log = Logger.getLogger(Hotel.class.getName());

    @Override
    public void execute(Scanner scanner) {
        try {
            Hotel hotel = Hotel.getInstance();
            System.out.println("Input room's id: ");
            Integer id = scanner.nextInt();
            System.out.println("Input new number: ");
            Integer roomNumber = scanner.nextInt();
            System.out.println("Do you want modify this room (y or n): ");
            String str = scanner.nextLine();
            if (str == "y") {
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
                hotel.updateCloneRoom(id, roomNumber, price, capacity, free, repair, numOfStars);
            }else{
                hotel.saveClone(id, roomNumber);
            }
            System.out.println("success");
        } catch (Exception e) {
            log.info(e);
        }
    }
}
