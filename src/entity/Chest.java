package entity;

import map.Element;

public class Chest extends Element {
    private Item item;

    public Chest(int x, int y, Item item) {
        super(x,y,"\033[38;2;255;128;0m"," + ");
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public boolean useChest(Player player){
        if (this.item == Item.NONE){
            System.out.println("Ce coffre est vide...");
            return true;
        }
        else if (player.getMaxItem() == player.getItems().size()){
            System.out.println("Votre inventaire est plein...");
            return false;
        }
        else {
            player.addInventory(this.getItem());
            String itemName = this.getItem().name();
            this.setItem(null);
            System.out.println("Vous avez obtenu: "+itemName+" !");
            return true;
        }
    }

}
