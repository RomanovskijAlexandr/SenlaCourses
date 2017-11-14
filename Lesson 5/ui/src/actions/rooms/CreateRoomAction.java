package actions.rooms;

import api.IAction;
import facade.Hotel;
import handlers.StringHandler;

import java.util.Date;
import java.util.Scanner;

public class CreateRoomAction implements IAction {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
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
        Scanner scanner1 = new Scanner(System.in);
        //String date = scanner1.nextLine();
        Date dateOfEviction = new StringHandler().parseDate(scanner1.nextLine(), "yyyy-MM-dd");

        System.out.println("Input room's date of settle (format: yyyy-MM-dd) : ");
        Date dateOfSettle = new StringHandler().parseDate(scanner1.nextLine(), "yyyy-MM-dd");
        hotel.createRoom(number, price, capacity, numOfStars, dateOfEviction, dateOfSettle);
        System.out.println("success");
    }
}
