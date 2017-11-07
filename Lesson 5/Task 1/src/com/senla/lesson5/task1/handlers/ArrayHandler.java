package com.senla.lesson5.task1.handlers;

import com.senla.lesson5.task1.entities.Entity;
import org.apache.log4j.Logger;

import java.util.Arrays;

public class ArrayHandler {
    private static final Logger log = Logger.getLogger(ArrayHandler.class.getName());

    public boolean checkArrayForNewElement(Entity[] entities) {
       try {
           boolean flag = false;
           for (Entity entity : entities) {
               if (entity == null)
                   flag = true;
           }
           if (!flag) {
               resizeArray(entities);
           }
           return flag;

       }catch (IndexOutOfBoundsException ex){
           log.info("Index Out Of Bounds Exception in " + this.getClass().getName(), ex);
           throw ex;
       }
    }

    public int getPosition(Entity[] entities) {
        try {
            int position = -1;
            for (int i = 0; i < entities.length; i++) {
                if (entities[i] == null) {
                    position = i;
                    break;
                }
            }
            return position;
        }catch (IndexOutOfBoundsException ex){
            log.info("Index Out Of Bounds Exception in " + this.getClass().getName(), ex);
            throw ex;
        }
    }

    public Entity[] resizeArray(Entity[] entities) {
            Entity[] entitiesResize = Arrays.copyOf(entities, entities.length + 1);
            return entitiesResize;
    }
}
