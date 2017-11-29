package controller;

import actions.ExitAction;
import builder.Builder;
import navigator.Navigator;

import java.io.IOException;
import java.util.Scanner;

public class MenuController {
    private Builder builder;
    private Navigator navigator;

    public MenuController() {
        this.builder = new Builder();
        this.navigator = new Navigator(builder.buildMenu());
    }

    public void run() throws IOException {
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        while (flag) {
            navigator.printMenu();
            Integer index = scanner.nextInt();
            if (index != 0)
                navigator.navigate(index - 1, scanner);
            else {
                new ExitAction().execute(scanner);
                flag = false;
            }
        }
        scanner.close();
    }
}
