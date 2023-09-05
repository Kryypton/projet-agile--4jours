/*public enum Square {

    ENEMY("\033[0;31m"," X ",new Info[]{Info.HURTFUL}),
    WALL("\033[48;2;66;66;66m","   ",new Info[]{Info.IMMOVABLE}),
    PLAYER("\033[38;2;255;200;241m","😀 "),
    UTILITY("\033[0;33m"," + "),
    NONE("\033[0m","   "),
    BORDER("\033[48;2;25;25;25m", "   ",new Info[]{Info.IMMOVABLE}),
    EXIT("\033[42m", "   ");
*/
import java.awt.color;
public class Element {
    private int posX;
    private int posY;
    private Color color;
    private String symbol;
    private Info[] infos;

    public Element(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public String toString() {
        return this.color + this.symbol;
    }

    public boolean isInfo(Info i) {
        boolean b = false;
        for (int j = 0 ; j < this.infos.length ; j++) {
            if (this.infos[j] == i)
                b = true;
        }
        return b;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setInfos(Info[] infos) {
        this.infos = infos;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public Color getColor() {
        return color;
    }

    public String getSymbol() {
        return symbol;
    }

    public Info[] getInfos() {
        return infos;
    }
    
}
