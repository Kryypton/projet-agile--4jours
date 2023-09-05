

public class Player extends Element{
    private final String name;
    private int maxHealth;
    private int health;
    private int amo;
    private State state;
    //private List<Item> items;
    //private int amoUsed; nombre de munitions utilisées, au bout d'un certain nombre il faut recharger 
    
    public Player(String name, int posX, int posY){
        super(posX, posY);
        this.name = name;
        this.maxHealth = 100;
        this.health = 100;
        this.amo = 10;
        this.state = State.ALIVE;
        super.setSymbol("p");
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getAmo() {
        return amo;
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
    
    public void setAmo(int amo) {
        this.amo = amo;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String toString(){
        return this.name + "; hp:" + this.health + "/" + this.maxHealth + ", state: " + this.state.toString() + ", amo: " + this.amo;
    }

    public static void main(String[] args) {
        Player p1 = new Player("Patrick", 5,5);
        System.out.println(p1.toString());
        p1.setAmo(p1.getAmo() - 3);
        p1.setHealth(p1.getHealth() - 14);
        System.out.println(p1.toString());
    }
    
    
}