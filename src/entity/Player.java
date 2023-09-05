package entity;

import map.Element;

public class Player extends Element {
    private final String name;
    private int maxHealth;
    private int health;
    private int ammo;
    private State state;
    // private List<Item> items;
    // private int ammoUsed; nombre de munitions utilisées, au bout d'un certain
    // nombre il faut recharger

    public Player(int x, int y, String name) {
        super(x, y, "\033[38;2;255;200;241m", "😀 ");
        this.name = name;
        this.maxHealth = 100;
        this.health = 100;
        this.ammo = 10;
        this.state = State.ALIVE;
    }

    public String toString() {
        return this.getColor() + this.getSymbol();
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getAmmo() {
        return ammo;
    }

    public State getState() {
        return state;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String statsToString() {
        return this.name + "; hp:" + this.health + "/" + this.maxHealth + ", state: " + this.state.toString()
                + ", ammo: " + this.ammo;
    }

    public static void main(String[] args) {
        Player p1 = new Player(0, 0, "Patrick");
        System.out.println(p1.toString());
        p1.setAmmo(p1.getAmmo() - 3);
        p1.setHealth(p1.getHealth() - 14);
        System.out.println(p1.toString());
    }

}