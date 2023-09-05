package entity;
import java.util.ArrayList;
import map.Element;
import utility.Info;

public class Player extends Element {
    private final String name;
    private int maxHealth;
    private int health;
    private int ammo;
    private State state;
    private ArrayList<Item> items;
    private int maxItem;
    private int damage;
    //private int ammoUsed; nombre de munitions utilisées, au bout d'un certain nombre il faut recharger 

    public Player(int x, int y, String name) {
        super(x, y, "\033[38;2;255;200;241m", "😀 ");
        this.name = name;
        this.maxHealth = 100;
        this.health = 100;
        this.ammo = 10;
        this.state = State.ALIVE;
        this.addInfo(Info.IMMOVABLE);
        initInventory();
    }

    public String toString() {
        return this.getColor() + this.getSymbol();
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getDamage() {
        return damage;
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

    public ArrayList<Item> getItems() {
        return items;
    }

    public int getMaxItem() {
        return maxItem;
    }

    public void initInventory(){
        this.items = new ArrayList<Item>();
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void setMaxItem(int maxItem) {
        this.maxItem = maxItem;
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

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String statsToString() {
        return this.name + "; hp:" + this.health + "/" + this.maxHealth + ", state: " + this.state.toString()
                + ", ammo: " + this.ammo;
    }

    public void addInventory(Item item){
        if(this.items.size() < maxItem){
            this.items.add(item);
        }
        
    }

    public boolean supInventory(Item item){
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).name().equals(item.name())){
                return items.remove(items.get(i));
            }
        }

        return false;
    }

    public int countItem(Item item){
        int cpt=0;
        for(Item i : items){
            if(i.name().equals(item.name())){
                cpt++;
            }
        }
        return cpt;
    }

    public void afficherInventaire(){
        if(items.size() == 0){
            System.out.println("\n inventaire vide \n");
        }
        else{
            System.out.println("\n vous possédez : \n Clés x" + countItem(Item.KEY) + "\n Soin x" + countItem(Item.HEAL)
            + "\n Grenade x" + countItem(Item.GRENADE) + "\n Munitions x" + countItem(Item.AMO) + "\n");
        }
    }

    public void consommerItem(Item item){
        if(item.name().equals(Item.HEAL.name()) && this.health < this.maxHealth){
            if(supInventory(item)){
                this.health = this.health + Item.HEAL.getH();
                if(this.health > this.maxHealth){
                    this.health = this.health - (this.maxHealth - this.health);
                }
            }
        } else if(item.name().equals(Item.AMO.name())){
            if(supInventory(item)){
                this.ammo = this.ammo + 5;
            }

        }
    }

    public static void main(String[] args) {
        Player p1 = new Player(0, 0, "Patrick");
        System.out.println(p1.toString());
        p1.setAmmo(p1.getAmmo() - 3);
        p1.setHealth(p1.getHealth() - 14);
        System.out.println(p1.toString());
    }

}