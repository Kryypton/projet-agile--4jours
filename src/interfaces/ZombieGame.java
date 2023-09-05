package interfaces;

import java.util.Scanner;
import entity.Player;
import map.Room;

public class ZombieGame {
    public static final Player PLAYER = new Player(12, 12, "Jambon");

    public void start() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Dimensions : ");
        int xy = sc.nextInt();

        System.out.println("Pourcentage d'ennemis : ");
        int enemy = sc.nextInt();
        System.out.println("Pourcentage de murs : ");
        int walls = sc.nextInt();
        System.out.println("Pourcentage de bonus : ");
        int utils = sc.nextInt();

        Room m = new Room(xy);
        m.generateMap(enemy, walls, utils); // 5 12 6
        String str = m.toStringMap();
        System.out.println(str);
        while (true) {
            m.movePlayer();
            System.out.println(m.toStringMap());
        }
    }
}
