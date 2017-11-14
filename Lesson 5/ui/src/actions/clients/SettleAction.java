package actions.clients;

import api.IAction;
import facade.Hotel;

import java.util.Scanner;

public class SettleAction implements IAction {
    @Override
    public void execute() {
        Hotel hotel = Hotel.getInstance();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input client's id: ");
        Integer idClient = scanner.nextInt();
        System.out.println("Input room's id: ");
        Integer idRoom = scanner.nextInt();
        hotel.settleClientInRoom(idClient, idRoom);
        System.out.println("Success");
    }
}
