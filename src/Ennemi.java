public enum Ennemi{
    ZOMBIE(50,30,2,5), RAT(20,10,3,3), COCKROACH(5,2,3,1);

    private int health;
    private int damage;
    private int range;
    private int cost;
    //ajouter drop, taux de drop

    private Ennemi(int health, int damage, int range, int cost){
        this.health = health;
        this.damage = damage;
        this.range = range;
        this.cost = cost;
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

    
}

