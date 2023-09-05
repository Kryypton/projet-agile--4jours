import java.util.ArrayList;
import java.util.Scanner;
public class ZombieGame {
    public static final Player PLAYER = new Player(12,12,"Jambon");
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Dimensions : ");
        int xy = sc.nextInt();


        System.out.println("Pourcentage d'ennemis : ");
        int enemy = sc.nextInt();
        System.out.println("Pourcentage de murs : ");
        int walls = sc.nextInt();
        System.out.println("Pourcentage de bonus : ");
        int utils = sc.nextInt();


        Map m = new Map(xy);
        m.generateMap(enemy,walls,utils); // 5 12 6
        String str = m.toStringMap();
        System.out.println(str);
        while (true) {
            m.movePlayer();
            System.out.println(m.toStringMap());
        }
    }
}
