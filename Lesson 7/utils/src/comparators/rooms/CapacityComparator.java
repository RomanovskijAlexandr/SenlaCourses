package comparators.rooms;

import entities.Room;

import java.util.Comparator;

public class CapacityComparator implements Comparator<Room> {
    @Override
    public int compare(Room room, Room room1) {
        if (room != null && room1 != null)
            return room.getCapacity().compareTo(room1.getCapacity());
        else if (room != null && room1 == null) {
            return 1;
        } else {
            return -1;
        }
    }
}
