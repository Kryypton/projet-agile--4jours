package interfaces;

import java.util.Random;

import entity.Ennemi;
import entity.EnnemiType;
import entity.Item;
import entity.Player;

public class Fight {
    public Player p;
    public Ennemi e;

    public Fight(Player p, Ennemi e) {
        this.p = p;
        this.e = e;
    }

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

    public void startFight() {
        while (p.getHealth() > 0 && e.getHealth() > 0) {
            System.out.println("Vous avez :" + p.getHealth() + " points de vie");
            System.out.println("L'ennemi a :" + e.getHealth() + " points de vie");
            System.out.println("Vous avez " + p.getAmmo() + " munitions");
            System.out.println(Color.CYAN + "Que voulez vous faire ?" + Color.RESET);
            System.out.println("1 - Attaquer");
            System.out.println("2 - Fuir");
            System.out.println("3 - Utiliser un objet");
            int choice = KeyboardInstruction.saisieClavierInt();
            switch (choice) {
                case 1:
                    inflictDamage();
                    receiveDamage();
                    break;
                case 2:
                    System.out.println("Vous fuyez le combat");
                    Random r = new Random();
                    int random = r.nextInt(100);
                    if (random < 50) {
                        System.out.println("Vous avez réussi à fuir");
                        return;
                    } else {
                        System.out.println("Vous n'avez pas réussi à fuir");
                        startFight();
                    }
                    break;

                case 3:
                    System.out.println("Quel objet voulez vous utiliser ?");
                    System.out.println(Color.CYAN + "1 - Soin" + Color.RESET);
                    System.out.println(Color.CYAN + "2 - Grenade" + Color.RESET);
                    int choice2 = KeyboardInstruction.saisieClavierInt();
                    switch (choice2) {
                        case 1:
                            if (p.countItem(Item.HEAL) > 0) {
                                p.consommerItem(Item.HEAL);
                                System.out.println("Vous utilisez un soin");
                                System.out.println("Vous avez maintenant " + p.getHealth() + " points de vie");
                            } else {
                                System.out.println("Vous n'avez pas de soin");
                            }
                            break;
                        case 2:
                            if (p.countItem(Item.GRENADE) > 0) {
                                p.consommerItem(Item.GRENADE);
                                System.out.println("Vous utilisez une grenade");
                                e.setHealth(e.getHealth() - Item.GRENADE.getDamage());
                                System.out.println("L'ennemi a maintenant " + e.getHealth() + " points de vie");
                            } else {
                                System.out.println("Vous n'avez pas de grenade");
                            }
                            break;
                        default:
                            System.out.println("Veuillez saisir un choix valide");
                            break;
                    }
                default:
                    System.out.println("Veuillez saisir un choix valide");
                    break;
            }
        }
        if (p.getHealth() <= 0) {
            System.out.println(Color.RED + "Vous avez perdu" + Color.RESET);
        } else {
            System.out.println(Color.GREEN + "Vous avez gagné" + Color.RESET);
        }
    }

    public static void main(String[] args) {
        Player p = new Player(0, 0, "Patrick");
        Ennemi e = new Ennemi(0, 0, EnnemiType.ZOMBIE);
        Fight f = new Fight(p, e);
        f.startFight();
    }
}
