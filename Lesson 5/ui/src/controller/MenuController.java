package controller;

import builder.Builder;
import navigator.Navigator;

import java.util.Scanner;

public class MenuController {
    private Builder builder;
    private Navigator navigator;

    public MenuController() {
        this.builder = new Builder();
        this.navigator = new Navigator(builder.buildMenu());
    }

    public void run() {
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        while (flag) {
            navigator.printMenu();
            Integer index = scanner.nextInt();
            navigator.navigate(index - 1);
        }

        scanner.close();
    }
}
