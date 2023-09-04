package models;

public abstract class Room {

    protected int maxLengthX;
    protected int maxLengthY;
    protected Door enterdoor;

    public Room(int maxLengthX, int maxLengthY) {
        this.maxLengthX = maxLengthX;
        this.maxLengthY = maxLengthY;
    }

    public void setDoor(Door door) {
        this.enterdoor = door;
    }

}