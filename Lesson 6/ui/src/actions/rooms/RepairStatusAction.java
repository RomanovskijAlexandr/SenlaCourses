package actions.rooms;

import action.IAction;
import facade.Hotel;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class RepairStatusAction implements IAction {
    private static final Logger log = Logger.getLogger(Hotel.class.getName());

    @Override
    public void execute(Scanner scanner) {
        try {
            Hotel hotel = Hotel.getInstance();
            System.out.println("Input room's id: ");
            Integer roomId = scanner.nextInt();
            System.out.println("Input new room's status (yes or no): ");
            Boolean roomStatus;
            if (scanner.nextLine() == "yes")
                roomStatus = true;
            else
                roomStatus = false;
            hotel.changeRepairStatus(roomId, roomStatus);
            System.out.println("success");
        } catch (Exception e) {
            log.info(e);
        }
    }
}
