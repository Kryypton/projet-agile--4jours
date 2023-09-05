package interfaces;

import java.io.File;
import java.util.Scanner;

public class Menu {
    public static Scanner sc = new Scanner(System.in);

    public static String menu() {
        String str;
        str = "--------------------------------------------------------------------\n";
        str += "1 - Commencer une nouvelle partie \n";
        str += "2 - Explications\n";
        str += "3 - Credits\n";
        str += "4 - Quitter\n";
        str += "--------------------------------------------------------------------\n";

        return str;
    }

    public static String welcome() {
        String str = "";
        str += "--------------------------------------------------------------------\n";
        str += "                       Bienvenue sur reZidence !\n";
        str += "--------------------------------------------------------------------";
        return str;
    }

    public static void atStart() {
        // cliquez sur entré pour continuer ...
        System.out.println(welcome());
        System.out.println(
                Color.CYAN + "              >>> Appuyez sur entrée pour continuer <<<             " + Color.RESET);
        sc.nextLine();
        System.out.println("--------------------------------------------------------------------\n");
        System.out.println(
                Color.CYAN + "           Veuillez choisir l'une des options ci-dessous :          " + Color.RESET);
        System.out.println(menu());
        int choice = KeyboardInstruction.saisieClavierInt();
        switch (choice) {
            case 1:
                choiceStartAGame();
                break;
            case 2:
                choiceExplain();
                break;
            case 3:
                choiceCredits();
                atStart();
            case 4:
                choiceQuit();
                atStart();
            default:
                System.out.println("Erreur de saisie, veuillez recommencer");
                atStart();
                break;
        }
    }

    public static void choiceStartAGame() {
        System.out.println("--------------------------------------------------------------------\n");
        System.out
                .println(Color.CYAN + "         Vous avez choisi de commencer une nouvelle partie !        "
                        + Color.RESET);
        System.out.println("--------------------------------------------------------------------\n");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ZombieGame game = new ZombieGame();
        game.start();
    }

    public static void choiceExplain() {
        File file = new File("res/text/explain.txt");
        System.out.println("--------------------------------------------------------------------\n");
        System.out.println(Color.CYAN + "         Vous avez choisi de lire les explications !        " + Color.RESET);
        System.out.println("--------------------------------------------------------------------\n");
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            System.out.println("--------------------------------------------------------------------\n");
            System.out.println(
                    Color.CYAN + "               Appuyez sur entrée pour continuer ...                " + Color.RESET);
            Menu.sc.nextLine();
            sc.close();
        } catch (Exception e) {
            System.out.println("Erreur de lecture du fichier / fichier inexistant");
        }
    }

    public static void choiceCredits() {
        File file = new File("res/text/credits.txt");
        System.out.println("--------------------------------------------------------------------\n");
        System.out.println(
                Color.CYAN + "                         Voici les crédits !                        " + Color.RESET);
        System.out.println("--------------------------------------------------------------------\n");
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
                Thread.sleep(200);
            }
            System.out.println("--------------------------------------------------------------------\n");
            System.out.println(
                    Color.CYAN + "               Appuyez sur entrée pour continuer ...               " + Color.RESET);
            Menu.sc.nextLine();
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur de lecture du fichier / fichier inexistant");
        }
    }

    public static void choiceQuit() {
        System.out.println("--------------------------------------------------------------------\n");
        System.out
                .println(Color.RED + "               Vous avez choisi de quitter le jeu !              " + Color.RESET);
        System.out.println("--------------------------------------------------------------------\n");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

}
