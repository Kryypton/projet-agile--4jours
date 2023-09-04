package models;

import java.util.ArrayList;

public class Room {

    private int maxLengthX;
    private int maxLengthY;
    private ArrayList<Room> nextRoom;

    public Room(int maxLengthX, int maxLengthY, ArrayList<Room> nextRoom) {
        this.maxLengthX = maxLengthX;
        this.maxLengthY = maxLengthY;
        this.nextRoom = nextRoom;
    }
}