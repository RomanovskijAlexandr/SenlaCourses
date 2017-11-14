package actions.rooms;

import api.IAction;
import facade.Hotel;

import java.util.Scanner;

public class RoomDetailsAction implements IAction {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = Hotel.getInstance();
        System.out.println("Input room's id: ");
        Integer roomId = scanner.nextInt();
        System.out.println(hotel.getRoomDetails(roomId));
        System.out.println("Success");
    }
}
