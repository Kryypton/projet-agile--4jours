public enum EnnemiType {
    ZOMBIE(50,30,2,5,'z'), RAT(20,10,3,3,'r'), COCKROACH(5,2,3,1,'c');
    private int health;
    private int damage;
    private int range;
    private int cost;
    private char carT;

    private EnnemiType(int health, int damage, int range, int cost, char carT){
        this.cost = cost;
        this.range = range;
        this.damage = damage;
        this.health = health;
        this.carT = carT;
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

    public char getCarT() {
        return carT;
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

    public void setCarT(char carT) {
        this.carT = carT;
    }

}
