package actions;

import action.IAction;
import controller.MenuController;

import java.util.Scanner;

public class BackAction implements IAction {
    @Override
    public void execute(Scanner scanner) {
        new MenuController().run();
    }
}
