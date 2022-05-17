package rodionov208.classes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import rodionov208.utils.RandomGenerator;

import java.util.ArrayList;

/**
 * Класс тестирования методов шулера.
 * @author Родионов Алексей БПИ208.
 */
class CrookTest {
    /**
     * Список честных игроков.
     */
    private static ArrayList<HonestPlayer> honestPlayers = new ArrayList<>();

    /**
     * Инициализация генератора случайных чисел заданным значением 31 для детерминированной генерации.
     * Инициализация списка честных игроков.
     */
    @BeforeAll
    static void initializeFields() {
        RandomGenerator rnd = new RandomGenerator(31);
        HonestPlayer honest1 = new HonestPlayer("Honest1");
        HonestPlayer honest2 = new HonestPlayer("Honest2");
        honest1.score = 10;
        honest2.score = 20;
        honestPlayers.add(honest1);
        honestPlayers.add(honest2);
    }

    /**
     * Тестирование метода совершения хода с несколькими исходами - воровством и взятием карты.
     */
    @Test
    void testMakeTurn() {
        Crook crook = new Crook("Crook1");
        Crook.setHonestPlayers(honestPlayers);

        // Stealing 0 from honest1
        assertEquals(crook.makeTurn(), 290);
        assertEquals(crook.score, 0);
        assertEquals(honestPlayers.get(0).score, 10);

        // Stealing 4 from honest2
        assertEquals(crook.makeTurn(), 261);
        assertEquals(crook.score, 4);
        assertEquals(honestPlayers.get(1).score, 16);

        // Getting card 1
        assertEquals(crook.makeTurn(), 144);
        assertEquals(crook.score, 5);
    }

    /**
     * Тестирование строкового представления.
     */
    @Test
    void testToString() {
        Crook crook = new Crook("Crook1");
        crook.score = 31;
        assertEquals(crook.toString(), "C | Crook1 | 31");
    }
}