package models;

import java.util.HashMap;

public class Stage {
    private HashMap<Room,Room> connectedRooms = new HashMap<>();
    private int nbRoom;

    public Stage(HashMap<Room, Room> connectedRooms, int nbRoom) {
        this.connectedRooms = connectedRooms;
        this.nbRoom = nbRoom;
    }
}
