package interfaces;

import java.util.Scanner;
import entity.Player;
import map.Room;

public class ZombieGame {
    public static final Player PLAYER = new Player(15, 15, "Jambon");

    public void start() {
        Scanner sc = new Scanner(System.in);

        int enemy = 25;
        int walls = 250;
        int utils = 1;

        Room m = new Room(30);
        
        m.generateMap(enemy, walls, utils); // 5 12 6
        String str = m.toStringMap();
        System.out.println(str);
        boolean game = true;
        while (game) {
            if(m.actionPlayer())
                m.moveEnemies();
            System.out.println(m.toStringMap());
            if (Room.levelType == 6) {
                game = false;
                System.out.flush();
                System.out.println("Voilà c'est fini");
            }
        }
        sc.close();
    }
}
