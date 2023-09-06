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

    public String useChest(Player player){
        if (this.item==null) return "Ce coffre est vide...";
        else if (player.getMaxItem() == player.getItems().size()){
            return "Votre inventaire est plein...";
        }
        else {
            player.addInventory(this.getItem());
            String itemName = this.getItem().name();
            this.setItem(null);
            return "Vous avez obtenu: "+itemName+" !";
        }
    }

}
