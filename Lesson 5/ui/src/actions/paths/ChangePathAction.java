package actions.paths;

import action.IAction;
import facade.Hotel;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class ChangePathAction implements IAction {
    private static final Logger log = Logger.getLogger(Hotel.class.getName());

    @Override
    public void execute() {
        try {
            Scanner scanner = new Scanner(System.in);
            Hotel hotel = Hotel.getInstance();
            System.out.println("path example: D:\\inputClients.txt ");
            System.out.println("Change client's path to file: ");
            String clientPath = scanner.nextLine();
            System.out.println("Change room's path to file: ");
            String roomPath = scanner.nextLine();
            System.out.println("Change opportunity's path to file: ");
            String opportunityPath = scanner.nextLine();
            System.out.println("Change room's hidtories path to file: ");
            String roomHistoryPath = scanner.nextLine();
            hotel.changePaths(clientPath, roomPath, opportunityPath, roomHistoryPath);
            System.out.println("success");
        } catch (Exception e) {
            log.info(e);
        }
    }
}
