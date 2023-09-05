import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class Map {
    private static final Scanner sc = new Scanner(System.in);
    private int levelType;
    private int xy;
    private Square[][] map;
    private Player p;

    public Map(int xy, int lvl) {
        this.xy = xy;
        this.levelType = lvl;
        this.map = new Square[xy][xy];
        this.p = new Player(this.xy);
    }

    public Map(int xy) {
        this(xy,0);
    }
    
    public Map() {
        this(25,25);
    }

    public String toStringMap() {
        String str = "";
        for (int i = 0 ; i < this.xy ; i++) {
            for (int j = 0 ; j < this.xy ; j++) {
                str += this.map[i][j].toString() + "\033[0m";
            }
            str += "\n";
        }
        return str;
    }
    public void generateMap(int nbenemy, int nbwall, int nbutil) { 
        this.generateEnemies(nbenemy);
        this.generateWalls(nbwall);
        this.generateUtil(nbutil);
        for (int i = 0 ; i < this.xy ; i ++) {
            for (int j = 0 ; j < this.xy ; j++) {
                if (i == 0 || i == this.xy-1 || j == 0 || j == this.xy-1)
                    this.map[i][j] = Square.BORDER;
                if (this.map[i][j] == null)
                    this.map[i][j] = Square.NONE;
            }
        }
        this.generateExits();
        this.generatePlayer();
    }
    
    private void generatePlayer() {
        this.map[this.p.getX()][this.p.getY()] = Square.PLAYER;
    }

    private void generateEnemies(int nb) {
        for (int i = 1 ; i < this.xy-1 ; i++) {
            for (int j = 1 ; j < this.xy-1 ; j++) {
                if (this.map[i][j] == null && (int) (Math.random()*100) <= nb) {
                    this.map[i][j] = Square.ENEMY;
                }
            }
        }
    }
    private void generateWalls(int nb) {
        for (int i = 1 ; i < xy-1 ; i++) {
            for (int j = 1 ; j < xy-1 ; j++) {
                if (this.map[i][j] == null && Math.random()*100 <= nb) {
                    this.map[i][j] = Square.WALL;
                }
            }
        }
    }
    private void generateUtil(int nb) {
        for (int i = 1 ; i < xy-1 ; i++) {
            for (int j = 1 ; j < xy-1 ; j++) {
                if (this.map[i][j] == null && Math.random()*100 <= nb) {
                    this.map[i][j] = Square.UTILITY;
                }
            }
        }
    }
    
    private void generateExits() {
        int exits = (int) (Math.ceil(Math.random()*4));
        List<Integer> ints = new ArrayList<Integer>();
        ints.add(0) ; ints.add(1) ; ints.add(2) ; ints.add(3);
        Collections.shuffle(ints);
        for (int i = 0 ; i < exits ; i++) {
            if (ints.get(0) == 0)
                this.map[0][(int) (Math.random()*this.xy-1)] = Square.EXIT;
            else if (ints.get(0) == 1)
                this.map[this.xy-1][(int) (Math.random()*this.xy-1)] = Square.EXIT;
            else if (ints.get(0) == 2)
                this.map[(int) (Math.random()*this.xy-1)][0] = Square.EXIT;
            else
                this.map[(int) (Math.random()*this.xy-1)][this.xy-1] = Square.EXIT;
            ints.remove(0);
        }
    }
    public boolean checkSquareValidity(Square s, Info i) {
        if (s.isInfo(i))
            return true;
        return false;
    }
    public boolean movePlayer() {
        boolean b = true;
        int x = this.p.getX();
        int y = this.p.getY();
        this.map[x][y] = Square.NONE;
        System.out.print("Direction : ");
        String movement = sc.nextLine();
        if (movement.equals("z") && !(checkSquareValidity(this.map[this.p.getX()-1][this.p.getY()], Info.IMMOVABLE)))
            this.p.setX(this.p.getX()-1);
        else if (movement.equals("q") && !(checkSquareValidity(this.map[this.p.getX()][this.p.getY()-1], Info.IMMOVABLE)))
            this.p.setY(this.p.getY()-1);
        else if (movement.equals("s") && !(checkSquareValidity(this.map[this.p.getX()+1][this.p.getY()], Info.IMMOVABLE)))
            this.p.setX(this.p.getX()+1);
        else if (movement.equals("d") && !(checkSquareValidity(this.map[this.p.getX()][this.p.getY()+1], Info.IMMOVABLE)))
            this.p.setY(this.p.getY()+1);
        if (b)
            this.map[p.getX()][p.getY()] = Square.PLAYER;
        return b;
    }
}
