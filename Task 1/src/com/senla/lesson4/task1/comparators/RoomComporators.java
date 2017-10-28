package com.senla.lesson4.task1.comparators;

import com.senla.lesson4.task1.entities.Room;

import java.util.Comparator;

public class RoomComporators {
    private Comparator<Room> priceComparator = new Comparator<Room>() {
        @Override
        public int compare(Room room, Room room1) {
            return room.getPrice().compareTo(room1.getPrice());
        }
    };

    private Comparator<Room> capacityComparator = new Comparator<Room>() {
        @Override
        public int compare(Room room, Room room1) {
            return room.getCapacity().compareTo(room1.getCapacity());
        }
    };

    private Comparator<Room> starsComparator = new Comparator<Room>() {
        @Override
        public int compare(Room room, Room room1) {
            return room.getNumOfStars().compareTo(room1.getNumOfStars());
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
