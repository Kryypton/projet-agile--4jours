package entity;

public enum Item {
    KEY(0, 0, "key", "ouvre un coffre"),
    HEAL(10, 0, "heal", "permet de recupérer des pv"),
    GRENADE(0, 50, "grenade", "inflige beaucoup de dégats"),
    AMO(0, 0, "amo", "donne des munitions supplémentaires"),
    NONE(0,0,"rien", ""),
    SCOPE(0,0,"scope+","augmente la précision de l'arme");

    private final int H;
    private final int DAMAGE;
    private final String NAME;
    private final String DESC;

    private Item(int heal, int damage, String name, String desc) {
        this.H = heal;
        this.DAMAGE = damage;
        this.NAME = name;
        this.DESC = desc;
    }

    public int getH() {
        return this.H;
    }

    public int getDamage() {
        return this.DAMAGE;
    }

    public String getName() {
        return this.NAME;
    }

    public String getDesc() {
        return this.DESC;
    }

    public String toString() {
        return getName() + " : " + getDesc() + " --> " + getH() + " pv, " + getDamage() + " damage.";
    }

    public boolean useItem(Player p) {
        if (this == Item.HEAL) {
            int i = (int)(Math.random()*11)+20;
            p.setHealth(p.getHealth()+i);
            System.out.println("Vous avez été heal de " + i + " HP.\n Vous avez maintenant " + p.getHealth() + "HP.");
            return true;
        }
        else if (this == Item.AMO) {
            int i = (int)(Math.random()*6)+1;
            p.setAmmo(p.getAmmo()+i);
            System.out.println("Vous avez rechargé votre arme de " + i + " munitions.\n Vous avez maintenant " + p.getAmmo() + " munitions.");
            return true;
        }
        System.out.println("Vous ne pouvez pas utiliser cet objet.");
        return false;
    }

    /*
     * test d'affichage
     * 
     * public static void main(String args[]){
     * Item cle = Item.KEY;
     * Item soin = Item.HEAL;
     * Item grenade = Item.GRENADE;
     * Item munitions = Item.AMO;
     * System.out.println(cle.toString());
     * System.out.println(soin.toString());
     * System.out.println(grenade.toString());
     * System.out.println(munitions.toString());
     * }
     */
}
