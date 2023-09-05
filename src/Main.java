import models.Door;
import models.SpawnRoom;

public class Main {
    public static void main(String[] args) {
        SpawnRoom spawn = new SpawnRoom(20, 10);

        Door MarchandDoor = new Door(2, 5, spawn);
        spawn.setDoor(MarchandDoor);
        System.out.println(spawn.toString());
    }
}
