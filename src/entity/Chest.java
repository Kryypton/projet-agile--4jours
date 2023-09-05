package entity;

import map.Element;

public class Chest extends Element {
    private Item item;

    public Chest(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
