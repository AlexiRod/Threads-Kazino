package rodionov208.utils;

import rodionov208.classes.*;
import java.util.ArrayList;

/**
 * Утилита пользовательского интерфейса.
 * @author Родионов Алексей БПИ208.
 */
public class GameInterface {
    /**
     * Метод запуска пользовательского интерфейса.
     */
    public static void startCardGame(){
        ArrayList<Player> players = new ArrayList<>();
        Game game = new Game();
        System.out.print("1) Enter the amount of honest players in range [1, 50]: ");
        int honestAmount = ConsoleWorker.readInt(1, 50);
        System.out.print("2) Enter the prefix name of each honest player: ");
        String honestName = ConsoleWorker.readString();
        System.out.print("3) Enter the amount of crooks (lvl 15) in range [0, 50]: ");
        int crooksAmount = ConsoleWorker.readInt(0, 50);
        System.out.print("4) Enter the prefix name of each crook (lvl 15): ");
        String crookName = ConsoleWorker.readString();

        for (int i = 1; i <= honestAmount; i++) {
            players.add(new HonestPlayer(honestName + "_" + i));
        }
        for (int i = 1; i <= crooksAmount; i++) {
            players.add(new Crook(crookName + "_" + i));
        }
        game.start(players);
    }
}
