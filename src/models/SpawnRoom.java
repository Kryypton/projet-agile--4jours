package models;

public class SpawnRoom extends Room {

    private BasicRoom leftRoom;
    private BasicRoom upLeftRoom;
    private BasicRoom upRightRoom;
    private BasicRoom rightRoom;

    public SpawnRoom(int maxLengthX, int maxLengthY) {
        super(maxLengthX, maxLengthY);
        this.leftRoom = new BasicRoom(maxLengthX, maxLengthY, new Door(maxLengthX, maxLengthY/2, this));
        this.upLeftRoom = new BasicRoom(maxLengthX, maxLengthY, new Door(maxLengthX, maxLengthY/3, this));
        this.upRightRoom = new BasicRoom(maxLengthX, maxLengthY, new Door(maxLengthX, maxLengthY, this));
        this.rightRoom = new BasicRoom(maxLengthX, maxLengthY, new Door(maxLengthX/2, maxLengthY, this));
    }

    public BasicRoom getLeftRoom() {
        return leftRoom;
    }

    public BasicRoom getUpLeftRoom() {
        return upLeftRoom;
    }

    public BasicRoom getUpRightRoom() {
        return upRightRoom;
    }

    public BasicRoom getRightRoom() {
        return rightRoom;
    }

    public String toString() {
        StringBuilder map = new StringBuilder();
        for (int x = 0; x<this.maxLengthX; x ++) {
            for (int y = 0; y<this.maxLengthY; y ++) {
                if (x==this.enterdoor.getPosX() && y==this.enterdoor.getPosY()) {
                    map.append("P");
                } else {
                    map.append("O");
                }
            }
            map.append("\n");
        }
        return map.toString();
    }
}

