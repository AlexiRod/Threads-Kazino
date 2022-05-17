package rodionov208.classes;

import rodionov208.utils.RandomGenerator;

/**
 * Класс честного игрока.
 * @author Родионов Алексей БПИ208.
 */
public class HonestPlayer extends Player {
    /**
     * Конструктор с именем.
     * @param name имя игрока.
     */
    public HonestPlayer(String name) {
        super(name);
    }

    /**
     * Метод для совершения хода - взятия карты из колоды.
     * @return Время, которое игроку надо отдохнуть после хода.
     */
    protected int makeTurn() {
        synchronized (Game.class) {
            score += RandomGenerator.generateCard();
            return RandomGenerator.generateTimeAfterGettingCard();
        }
    }

    /**
     * Переопределенный метод, симулирующий игру честного игрока.
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
     * Метод для списания с баланса игрока украденного шулером количества очков.
     * @param stolenScores Очки, которые пытается украсть шулер.
     * @return Реальное количество очков, которое получилось украсть.
     */
    public int stealScore(int stolenScores) {
        stolenScores = Integer.min(stolenScores, score);
        score -= stolenScores;
        return stolenScores;
    }

    /**
     * Переопределенное строковое представление
     */
    @Override
    public String toString() {
        return "H | " + name + " | " + score;
    }
}