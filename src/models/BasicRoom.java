package models;

public class BasicRoom extends Room {

    private Door door;

    public BasicRoom(int maxLengthX, int maxLengthY, Door enterdoor) {
        super(maxLengthX, maxLengthY);
        this.door = enterdoor;
    }
    /**
     * Méthode permettant de retourner la map (affichage)
     * @return String map
     */
    public String toString() {
        StringBuilder map = new StringBuilder();
        for (int y = 0; y<this.maxLengthY; y ++) {
            for (int x = 0; x<this.maxLengthX; x ++) {
                if (x==this.door.getPosX() && y==this.door.getPosY()) {
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
