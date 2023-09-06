package interfaces;

import java.util.Scanner;
import entity.Player;
import map.Room;

public class ZombieGame {
    public static final Player PLAYER = new Player(15, 15, "Jambon");

    public void start() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Dimensions : ");
        int xy = sc.nextInt();

        System.out.println("Proba d'ennemis (entre 1 et 1000) : ");
        int enemy = sc.nextInt();
        System.out.println("Proba de murs (entre 1 et 1000) : ");
        int walls = sc.nextInt();
        System.out.println("Proba de bonus (entre 1 et 1000) : ");
        int utils = sc.nextInt();

        Room m = new Room(xy);
        m.generateMap(enemy, walls, utils); // 5 12 6
        String str = m.toStringMap();
        System.out.println(str);
        boolean game = true;
        while (game) {
            m.movePlayer();
            m.moveEnemies();
            System.out.println(m.toStringMap());
            game = true;
        }
        sc.close();
    }
}
