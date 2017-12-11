package actions;

import annotationsimpl.CsvEntityImpl;
import entities.Client;
import entities.Opportunity;
import entities.Room;
import entities.RoomHistory;
import facade.Hotel;
import uiactions.IAction;

import java.io.IOException;
import java.util.Scanner;

public class ExitAction implements IAction {
    @Override
    public void execute(Scanner scanner) throws IOException {
        System.out.println("Good bye");
        Hotel hotel = Hotel.getInstance();
        CsvEntityImpl csvEntity = new CsvEntityImpl();
        csvEntity.writeByAnnotation(Client.class);
        csvEntity.writeByAnnotation(Room.class);
        csvEntity.writeByAnnotation(RoomHistory.class);
        csvEntity.writeByAnnotation(Opportunity.class);
    }
}
