package printer;

import entities.Entity;

import java.util.List;

public class Printer {
    public static void printEntities(List<? extends Entity> entities) {
        StringBuilder[] sb = new StringBuilder[entities.size()];
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i) != null)
                sb[i] = new StringBuilder(entities.get(i).toString());
        }
        for (int i = 0; i < entities.size(); i++) {
            System.out.println(sb[i].toString());
        }
        System.out.println("\n");
    }
}
