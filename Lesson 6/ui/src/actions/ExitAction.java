package actions;

import action.IAction;
import facade.Hotel;

public class ExitAction implements IAction {
    @Override
    public void execute() {
        System.out.println("Good bye");
        Hotel hotel = Hotel.getInstance();
        hotel.saveEntities();
        System.exit(0);
    }
}
