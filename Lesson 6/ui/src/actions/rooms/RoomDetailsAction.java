package actions.rooms;

import uiactions.IAction;
import facade.Hotel;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class RoomDetailsAction implements IAction {
    private static final Logger log = Logger.getLogger(Hotel.class.getName());

    @Override
    public void execute(Scanner scanner) {
        try {
            Hotel hotel = Hotel.getInstance();
            System.out.println("Input room's id: ");
            Integer roomId = scanner.nextInt();
            System.out.println(hotel.getRoomDetails(roomId));
            System.out.println("Success");
        } catch (Exception e) {
            log.info(e);
        }
    }
}
