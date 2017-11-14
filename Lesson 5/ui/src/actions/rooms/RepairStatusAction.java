package actions.rooms;

import api.IAction;
import facade.Hotel;

import java.util.Scanner;

public class RepairStatusAction implements IAction {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
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
    }
}
