package rodionov208.classes;

import java.util.ArrayList;

/**
 * Класс основной игры (казино).
 * @author Родионов Алексей БПИ208.
 */
public class Game {

    /**
     * Метод старта игры - определение честных игроков и запуск работы крупье.
     * @param players Список всех игроков.
     */
    public void start(ArrayList<Player> players) {
        System.out.println("Welcome to our ERE Casino, dear players. Let's begin.");
        ArrayList<HonestPlayer> honestPlayers = new ArrayList<>();
        for (Player player : players) {
            if(player.getClass() == HonestPlayer.class) {
                honestPlayers.add((HonestPlayer)player);
            }
        }

        Crook.setHonestPlayers(honestPlayers);
        Croupier croupier = new Croupier(players);

        croupier.startGame();
        croupier.endGame();
    }
}
