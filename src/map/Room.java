package map;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import entity.Ennemi;
import entity.EnnemiType;
import entity.Info;
import entity.Player;
import interfaces.ZombieGame;

public class Room {

    private static ArrayList<Room> everyMaps = new ArrayList<Room>();
    private static final Scanner sc = new Scanner(System.in);
    private int levelType;
    private int xy;
    private Element[][] map;
    private Player player;

    public Room(int xy, int lvl) {
        this.xy = xy;
        this.levelType = lvl;
        this.map = new Element[xy][xy];
        this.player = ZombieGame.PLAYER;
    }

    public Room(int xy) {
        this(xy, 0);
    }

    public Room() {
        this(25);
    }

    public String toStringMap() {
        String str = "";
        for (int i = 0; i < this.xy; i++) {
            for (int j = 0; j < this.xy; j++) {
                if (this.map[i][j] == null)
                    str += "   ";
                else
                    str += this.map[i][j].toString() + "\033[0m";
            }
            str += "\n";
        }
        return str;
    }

    public void generateMap(int nbenemy, int nbwall, int nbutil) {
        this.generateEnemies(nbenemy);
        this.generateWalls(nbwall);
        // this.generateUtil(nbutil);
        for (int i = 0; i < this.xy; i++) {
            for (int j = 0; j < this.xy; j++) {
                if (i == 0 || i == this.xy - 1 || j == 0 || j == this.xy - 1)
                    this.map[i][j] = new Border(i, j);
            }
        }
        this.generateExits();
        this.map[this.player.getPosX()][this.player.getPosY()] = this.player;
    }

    private EnnemiType getMapSpawnRate() {
        if (this.levelType == 0)
            return EnnemiType.RAT;
        if (this.levelType == 1)
            if ((int) Math.random() * 2 == 0)
                return EnnemiType.RAT;
            else
                return EnnemiType.COCKROACH;
        return EnnemiType.ZOMBIE;
    }

    private void generateEnemies(int nb) {
        for (int i = 1; i < this.xy - 1; i++) {
            for (int j = 1; j < this.xy - 1; j++) {
                if (this.map[i][j] == null && (int) (Math.random() * 100) <= nb) {
                    this.map[i][j] = new Ennemi(i, j, this.getMapSpawnRate());
                }
            }
        }
    }

    private void generateWalls(int nb) {
        for (int i = 1; i < xy - 1; i++) {
            for (int j = 1; j < xy - 1; j++) {
                if (this.map[i][j] == null && Math.random() * 100 <= nb) {
                    this.map[i][j] = new Wall(i, j);
                }
            }
        }
    }

    /*
     * private void generateUtil(int nb) {
     * for (int i = 1 ; i < xy-1 ; i++) {
     * for (int j = 1 ; j < xy-1 ; j++) {
     * if (this.map[i][j] == null && Math.random()*100 <= nb) {
     * this.map[i][j] = Square.UTILITY;
     * }
     * }
     * }
     * }
     */

    private void generateExits() {
        int exits = (int) (Math.ceil(Math.random() * 4));
        List<Integer> ints = new ArrayList<Integer>();
        ints.add(0);
        ints.add(1);
        ints.add(2);
        ints.add(3);
        Collections.shuffle(ints);
        int k;
        for (int i = 0; i < exits; i++) {
            if (ints.get(0) == 0) {
                k = (int) (Math.random() * this.xy - 1);
                this.map[0][k] = new Exit(0, k);
            } else if (ints.get(0) == 1) {
                k = (int) (Math.random() * this.xy - 1);
                this.map[this.xy - 1][k] = new Exit(this.xy - 1, k);
            } else if (ints.get(0) == 2) {
                k = (int) (Math.random() * this.xy - 1);
                this.map[k][0] = new Exit(k, 0);
            } else {
                k = (int) (Math.random() * this.xy - 1);
                this.map[k][this.xy - 1] = new Exit(k, this.xy - 1);
            }
            ints.remove(0);
        }
    }

    public boolean checkElementValidity(Element s, Info i) {
        if (s == null)
            return false;
        if (s.isInfo(i))
            return true;
        return false;
    }

    public boolean movePlayer() {
        boolean b = true;
        int x = this.player.getPosX();
        int y = this.player.getPosY();
        this.map[x][y] = null;
        System.out.print("Direction : ");
        String movement = sc.nextLine();
        if (movement.equals("z")
                && !(checkElementValidity(this.map[this.player.getPosX() - 1][this.player.getPosY()], Info.IMMOVABLE)))
            this.player.setPosX(this.player.getPosX() - 1);
        else if (movement.equals("q")
                && !(checkElementValidity(this.map[this.player.getPosX()][this.player.getPosY() - 1], Info.IMMOVABLE)))
            this.player.setPosY(this.player.getPosY() - 1);
        else if (movement.equals("s")
                && !(checkElementValidity(this.map[this.player.getPosX() + 1][this.player.getPosY()], Info.IMMOVABLE)))
            this.player.setPosX(this.player.getPosX() + 1);
        else if (movement.equals("d")
                && !(checkElementValidity(this.map[this.player.getPosX()][this.player.getPosY() + 1], Info.IMMOVABLE)))
            this.player.setPosY(this.player.getPosY() + 1);
        if (b)
            this.map[this.player.getPosX()][this.player.getPosY()] = this.player;
        return b;
    }
}
