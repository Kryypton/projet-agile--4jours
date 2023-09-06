
package interfaces;

import java.io.File;

import entity.Player;
import utility.Score;

public class Main {
    public static final Player PLAYER = new Player(12, 12, "Jambon");

    public static void main(String[] args) {
        Menu.loading();
        Menu.atStart();
    }
}
