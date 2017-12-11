package runner;

import controller.MenuController;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException {
        MenuController menuController = new MenuController();
        menuController.run();
    }
}
