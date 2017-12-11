package actions;

import uiactions.IAction;
import controller.MenuController;

import java.io.IOException;
import java.util.Scanner;

public class BackAction implements IAction {
    @Override
    public void execute(Scanner scanner) throws IOException {
        new MenuController().run();
    }
}
