package map;

public class Door {
    private int posX;
    private int posY;
    private Room directionRoom;

    public Door(int posX, int posY, Room directionRoom) {
        this.posX = posX;
        this.posY = posY;
        this.directionRoom = directionRoom;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public Room getDirectionRoom() {
        return directionRoom;
    }
}
