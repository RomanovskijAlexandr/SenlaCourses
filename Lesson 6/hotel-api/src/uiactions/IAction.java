package uiactions;

import java.io.IOException;
import java.util.Scanner;

public interface IAction {
    public void execute(Scanner scanner) throws IOException;
}
