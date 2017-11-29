package entities;

import java.io.Serializable;

public abstract class Entity implements Serializable {
    private int id;

    public int generateId(int lastId) {
        return lastId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract String getStringForPrintInFile();

}
