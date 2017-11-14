package comparators;

import entities.Room;

import java.util.Comparator;

public class RoomComporators {
    private Comparator<Room> priceComparator = new Comparator<Room>() {
        @Override
        public int compare(Room room, Room room1) {
            if (room != null && room1 != null)
                return room.getPrice().compareTo(room1.getPrice());
            else if (room != null && room1 == null) {
                return 1;
            } else {
                return -1;
            }
        }
    };

    private Comparator<Room> capacityComparator = new Comparator<Room>() {
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
    };

    private Comparator<Room> starsComparator = new Comparator<Room>() {
        @Override
        public int compare(Room room, Room room1) {
            if (room != null && room1 != null)
                return room.getNumOfStars().compareTo(room1.getNumOfStars());
            else if (room != null && room1 == null) {
                return 1;
            } else {
                return -1;
            }
        }
    };

    public Comparator<Room> getPriceComparator() {
        return priceComparator;
    }

    public Comparator<Room> getCapacityComparator() {
        return capacityComparator;
    }

    public Comparator<Room> getStarsComparator() {
        return starsComparator;
    }
}
