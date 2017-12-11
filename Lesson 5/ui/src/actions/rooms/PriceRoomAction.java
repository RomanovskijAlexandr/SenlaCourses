package actions.rooms;

import action.IAction;
import facade.Hotel;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class PriceRoomAction implements IAction {
    private static final Logger log = Logger.getLogger(Hotel.class.getName());

    @Override
    public void execute() {
        try {
            Scanner scanner = new Scanner(System.in);
            Hotel hotel = Hotel.getInstance();
            System.out.println("Input room's id: ");
            Integer roomId = scanner.nextInt();
            System.out.println("Input new room's price: ");
            Integer roomPrice = scanner.nextInt();
            hotel.changeRoomPrice(roomId, roomPrice);
            System.out.println("success");
        } catch (Exception e) {
            log.info(e);
        }
    }
}
