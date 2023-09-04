public class Ennemi{
    private int health;
    private int damage;
    
    public Ennemi(int health, int damage){
        this.health = health;
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setHealth(int health) {
        this.health = health;
    }

}
