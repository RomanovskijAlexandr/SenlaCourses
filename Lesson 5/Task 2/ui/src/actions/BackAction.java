package actions;

import api.IAction;
import builder.Builder;
import controller.MenuController;

public class BackAction implements IAction {
    @Override
    public void execute() {
        new MenuController().run();
    }
}
