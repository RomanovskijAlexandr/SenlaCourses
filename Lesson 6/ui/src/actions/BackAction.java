package actions;

import action.IAction;
import controller.MenuController;

public class BackAction implements IAction {
    @Override
    public void execute() {
        new MenuController().run();
    }
}
