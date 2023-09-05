package map;

import entity.Info;

public class Wall extends Element {
    private int maxHealth;
    private int health;

    public Wall(int x, int y) {
        super(x, y, "\033[48;2;69;69;69m", "   ");
        this.maxHealth = 250;
        this.health = 250;
        this.addInfo(Info.IMMOVABLE);
    }
}
