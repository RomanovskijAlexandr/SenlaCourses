package actions.rooms;

import api.IAction;
import facade.Hotel;

import java.util.Scanner;

public class PriceRoomAction implements IAction {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = Hotel.getInstance();
        System.out.println("Input room's id: ");
        Integer roomId = scanner.nextInt();
        System.out.println("Input new room's price: ");
        Integer roomPrice = scanner.nextInt();
        hotel.changeRoomPrice(roomId, roomPrice);
        System.out.println("success");
    }
}
