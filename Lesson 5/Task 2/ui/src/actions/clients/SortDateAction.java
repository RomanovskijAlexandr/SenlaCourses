package actions.clients;

import api.IAction;
import facade.Hotel;

import java.util.Scanner;

public class SortDateAction implements IAction {
    @Override
    public void execute() {
        Hotel hotel = Hotel.getInstance();
        hotel.sortClientsByDate();
        System.out.println("Success");
    }
}
