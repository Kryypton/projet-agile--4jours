public enum Item {
    KEY(0,0,"key","ouvre un coffre"), 
    HEAL(10,0,"heal","permet de recupérer des pv"), 
    GRENADE(0,50,"grenade","inflige beaucoup de dégats"), 
    AMO(0,0,"amo","donne des munitions supplémentaires");

    private final int H;
    private final int DAMAGE;
    private final String NAME;
    private final String DESC;

    private Item(int heal, int damage, String name, String desc){
        this.H = heal;
        this.DAMAGE = damage;
        this.NAME = name;
        this.DESC = desc;
    }

    public int getH(){
        return this.H;
    }

    public int getDamage(){
        return this.DAMAGE;
    }

    public String getName(){
        return this.NAME;
    }

    public String getDesc(){
        return this.DESC;
    }

    public String toString(){
        return getName()+" : "+getDesc()+" --> "+getH()+" pv, "+getDamage()+" damage.";
    }

    /* test d'affichage
    
    public static void main(String args[]){
        Item cle = Item.KEY;
        Item soin = Item.HEAL;
        Item grenade = Item.GRENADE;
        Item munitions = Item.AMO;
        System.out.println(cle.toString());
        System.out.println(soin.toString());
        System.out.println(grenade.toString());
        System.out.println(munitions.toString());
    }
    */
}

