package navigator;

import menus.Menu;

import java.util.Scanner;

public class Navigator {
    private Menu currentMenu;

    public Navigator(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }


    public void printMenu() {
        for (int i = 0; i < currentMenu.getMenuItems().size(); i++) {
            if (currentMenu.getMenuItems().size() != 4)
                System.out.println((i + 1) + ") " + currentMenu.getMenuItems().get(i).toString());
            else {
                if(i!=currentMenu.getMenuItems().size()-1)
                    System.out.println((i + 1) + ") " + currentMenu.getMenuItems().get(i).toString());
                else System.out.println((0 + ") " + currentMenu.getMenuItems().get(i).toString()));
            }
        }
    }

    public void navigate(Integer index, Scanner scanner) {
        if (currentMenu.getMenuItems().get(index) != null) {
            if (currentMenu.getMenuItems().get(index).getAction() != null)
                currentMenu.getMenuItems().get(index).doAction(scanner);
            else
                currentMenu = currentMenu.getMenuItems().get(index).getNextMenu();
        }
    }
}
