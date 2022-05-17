package rodionov208.classes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import rodionov208.utils.RandomGenerator;

import java.util.ArrayList;
import java.util.Comparator;


/**
 * Класс тестирования методов крупье.
 * @author Родионов Алексей БПИ208.
 */
class CroupierTest {
    /**
     * Список всех игроков.
     */
    private static final ArrayList<Player> players = new ArrayList<>();
    private static Croupier croupier;

    /**
     * Инициализация генератора случайных чисел заданным значением 31 для детерминированной генерации.
     * Инициализация списка игроков, честных игроков для шулера и крупье.
     */
    @BeforeAll
    static void initializeFields() {
        RandomGenerator rnd = new RandomGenerator(31);
        HonestPlayer honest1 = new HonestPlayer("Honest1");
        HonestPlayer honest2 = new HonestPlayer("Honest2");
        Crook crook = new Crook("Crook1");

        players.add(honest1);
        players.add(honest2);
        players.add(crook);

        ArrayList<HonestPlayer> honestPlayers = new ArrayList<>();
        honestPlayers.add(honest1);
        honestPlayers.add(honest2);
        Crook.setHonestPlayers(honestPlayers);

        croupier = new Croupier(players);
    }

    /**
     * Тестирование метода запуска игры.
     */
    @Test
    void testStartGame() {
        boolean wasException = false;
        try {
            croupier.startGame();
        } catch (Exception ex) {
            wasException = true;
        }
        assertFalse(wasException);
    }

    /**
     * Тестирование метода нахождения победителя.
     */
    @Test
    void testGetWinners() {
        for (Player player : players) {
            player.stop();
        }

        players.sort(Comparator.comparingInt(p -> p.score));
        Player winner = players.get(players.size() - 1);
        assertEquals(croupier.getWinners().get(0).toString(), winner.toString());
    }
}