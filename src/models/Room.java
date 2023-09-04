package models;

import java.util.ArrayList;

public class Room {

    private int maxLengthX;
    private int maxLengthY;
    private Door enterdoor;

    public Room(int maxLengthX, int maxLengthY, Door enterdoor) {
        this.maxLengthX = maxLengthX;
        this.maxLengthY = maxLengthY;
        this.enterdoor = enterdoor;
    }
}