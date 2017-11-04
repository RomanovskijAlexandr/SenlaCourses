package com.senla.lesson4.task1.handlers;

import com.senla.lesson4.task1.entities.Entity;

import java.util.Arrays;

public class ArrayHandler {
    public boolean checkArrayForNewElement(Entity[] entities) {
        boolean flag = false;
        for (Entity entity : entities) {
            if (entity == null)
                flag = true;
        }
        if (!flag) {
            resizeArray(entities);
        }
        return flag;
    }

    public int getPosition(Entity[] entities) {
        int position = -1;
        for (int i = 0; i < entities.length; i++) {
            if (entities[i] == null) {
                position = i;
                break;
            }
        }
        return position;
    }

    public Entity[] resizeArray(Entity[] entities) {
        Entity[] entitiesResize = Arrays.copyOf(entities, entities.length + 1);
        return entitiesResize;
    }
}
