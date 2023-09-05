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
}
