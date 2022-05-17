package rodionov208.classes;

import rodionov208.utils.ConsoleWorker;
import java.util.ArrayList;

/**
 * Класс крупье для проведения игры.
 * @author Родионов Алексей БПИ208.
 */
public class Croupier extends Thread {
    /**
     * Список всех игроков.
     */
    private static ArrayList<Player> players;

    /**
     * Конструктор со списком играющих.
     * @param allPlayers Список игроков.
     */
    Croupier(ArrayList<Player> allPlayers) {
        players = allPlayers;
    }

    /**
     * Метод для запуска игры - запуск всех потоков-игроков и сон на 10 секунд.
     */
    public void startGame() {
        System.out.println("My name is mr. Croupier. Now we start the game!");
        for (Player player : players) {
            player.start();
        }

        try {
            sleep(10000);
        } catch (InterruptedException ex) {
            System.out.println("Croupier was interrupted! " + ex.getMessage());
        }
    }

    /**
     * Метод для остановки игры - остановка каждого потока-игрока и вывод победителя.
     */
    public void endGame() {
        for (Player player : players) {
            player.interrupt();
        }

        System.out.println("Game is end. Winner(s):");
        for (Player winner : getWinners()) {
            System.out.println(winner);
        }

        joinPlayers();
        System.out.print("Show table with all players? 1 - yes, 2 - no: ");
        if(ConsoleWorker.readInt(1, 2) == 2) {
            return;
        }

        System.out.println("All players:\nRole | Name | Score");
        players.sort((p1, p2) -> p2.score - p1.score);
        for (Player player : players) {
            System.out.println(player);
            //player.stop();
        }

    }

    void joinPlayers() {
        for (Player player : players) {
            try {
                player.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Метод определения одного или нескольких победителей по очкам.
     * @return Список победителей.
     */
    public ArrayList<Player> getWinners() {
        int maxScore = Integer.MIN_VALUE;
        ArrayList<Player> winners = new ArrayList<>();
        for (Player player : players) {
            maxScore = Integer.max(maxScore, player.score);
        }

        for (Player player : players) {
            if(player.score == maxScore) {
                winners.add(player);
            }
        }
        return winners;
    }
}
