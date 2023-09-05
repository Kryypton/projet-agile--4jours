package entity;

import map.Element;

public class Ennemi extends Element {

    private int health;
    private int damage;
    private int range;
    private int cost;
    private EnnemiType type;
    // ajouter drop, taux de drop

    public Ennemi(int x, int y, EnnemiType type) {
        super(x, y, "\033[0;31m", pickEnemySymbol(type));
        this.type = type;
        this.health = type.getHealth();
        this.damage = type.getDamage();
        this.range = type.getRange();
        this.cost = type.getCost();
    }

    public static String pickEnemySymbol(EnnemiType t) {
        if (t == EnnemiType.RAT)
            return " 🪳 ";
        if (t == EnnemiType.COCKROACH)
            return " 🐀 ";
        /* if (t == EnnemiType.ZOMBIE) */ return "   ";
    }

    public String toString() {
        return this.getColor() + this.getSymbol();
    }

    public int getCost() {
        return cost;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public int getRange() {
        return range;
    }

    public EnnemiType getType() {
        return type;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public void setType(EnnemiType type) {
        this.type = type;
    }

}
