package rodionov208.classes;

import rodionov208.utils.RandomGenerator;
import java.util.ArrayList;

/**
 * Класс игрока-шулера.
 * @author Родионов Алексей БПИ208.
 */
public class Crook extends Player {
    /**
     * Список всех честных игроков, у которых шулер будет пытаться воровать.
     */
    private static ArrayList<HonestPlayer> honestPlayers;

    /**
     * Конструктор с именем.
     * @param name имя игрока.
     */
    public Crook(String name) {
        super(name);
    }

    /**
     * Сеттер для массива честных игроков.
     * @param players Массив честных игроков.
     */
    public static void setHonestPlayers(ArrayList<HonestPlayer> players) {
        honestPlayers = players;
    }

    /**
     * Метод для совершения хода - взятия карты из колоды или воровства.
     * @return Время, которое шулеру надо отдохнуть после совершенного хода.
     */
    protected int makeTurn() {
        synchronized (Game.class) {
            if (RandomGenerator.generateCrookDecision()) {
                HonestPlayer player = honestPlayers.get(RandomGenerator.generateInt(honestPlayers.size()));
                score += player.stealScore(RandomGenerator.generateInt(9));
                return RandomGenerator.generateTimeAfterStole();
            } else {
                score += RandomGenerator.generateCard();
                return RandomGenerator.generateTimeAfterGettingCard();
            }
        }
    }

    /**
     * Переопределенный метод, симулирующий игру шулера.
     * Выполнение прекратится в момент, когда флаг этого игрока isInterrupted станет true,
     * то есть в конце игры.
     */
    @Override
    public void run() {
        while (!currentThread().isInterrupted()) {
            int timeToSleep = makeTurn();
            try {
                sleep(timeToSleep);
            } catch (InterruptedException ex) {
                interrupt();
            }
        }
    }


    /**
     * Переопределенное строковое представление
     */
    @Override
    public String toString() {
        return "C | " + name + " | " + score;
    }
}