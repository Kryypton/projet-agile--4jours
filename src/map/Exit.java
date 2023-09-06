package map;
import utility.Info;

public class Exit extends Element {
    public static int incrementID = 1;
    int IDmap;
    public Exit(int x, int y) {
        super(x, y,"\033[42m","   ");
        this.addInfo(Info.EXIT);
    }

    public void setID(int i) {
        this.IDmap = i;
    }

    public int getID() {
        return this.IDmap;
    }
}
