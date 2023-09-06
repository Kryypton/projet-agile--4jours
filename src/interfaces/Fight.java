package interfaces;

import entity.Ennemi;
import entity.Player;

public class Fight {
    public Player p;
    public Ennemi e;

    public void inflictDamage() {
        if (p.getAmmo() < 0) {

            int damageCaused = p.getDamage();
            if (damageCaused < e.getHealth()) {
                damageCaused = damageCaused - (damageCaused - e.getHealth());

            }
            e.setHealth(e.getHealth() - damageCaused);
            p.setAmmo(p.getAmmo() - 1);
        } else {
            System.out.println("\n ! plus de munitions ! \n ");
        }
    }

    public void receiveDamage() {
        int damageCaused = e.getDamage();
        if (damageCaused < p.getHealth()) {
            damageCaused = damageCaused - (damageCaused - p.getHealth());
        }
        p.setHealth(p.getHealth() - damageCaused);
    }

}
