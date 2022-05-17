package rodionov208.classes;

/**
 * Абстрактный класс игрока.
 * @author Родионов Алексей БПИ208.
 */
public abstract class Player extends Thread {
    /**
     * Имя игрока
     */
    protected String name;

    /**
     * Количество очеов игрока
     */
    protected int score;

    /**
     * Конструктор с именем.
     * @param name имя игрока.
     */
    public Player(String name) {
        this.name = name;
        this.score = 0;
    }
}
