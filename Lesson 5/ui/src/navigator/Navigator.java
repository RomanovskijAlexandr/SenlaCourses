package navigator;

import menus.Menu;

public class Navigator {
    private Menu currentMenu;

    public Navigator(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }


    public void printMenu() {
        for (int i = 0; i < currentMenu.getMenuItems().size(); i++) {
            System.out.println((i + 1) + ") " + currentMenu.getMenuItems().get(i).toString());
        }
    }

    public void navigate(Integer index) {
        if (currentMenu.getMenuItems().get(index) != null) {
            if (currentMenu.getMenuItems().get(index).getAction() != null)
                currentMenu.getMenuItems().get(index).doAction();
            else
                currentMenu = currentMenu.getMenuItems().get(index).getNextMenu();
        }
    }
}
