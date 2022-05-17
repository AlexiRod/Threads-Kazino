package rodionov208.classes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import rodionov208.utils.RandomGenerator;


/**
 * Класс тестирования методов честного игрока.
 * @author Родионов Алексей БПИ208.
 */
class HonestPlayerTest {
    /**
     * Инициализация генератора случайных чисел заданным значением 54 для детерминированной генерации.
     */
    @BeforeAll
    static void initializeRandom() {
        RandomGenerator rnd = new RandomGenerator(54);
    }

    /**
     * Тестирование метода совершения хода - взятия карты.
     */
    @Test
    void testMakeTurn() {
        HonestPlayer player = new HonestPlayer("Honest1");
        assertEquals(player.makeTurn(), 114);
        assertEquals(player.score, 10);
    }

    /**
     * Тестирование попытки украсть меньшего числа очков, чем есть на балансе.
     */
    @Test
    void testStealingAllAmountOfScores() {
        HonestPlayer honest = new HonestPlayer("Honest2");
        honest.score = 10;
        assertEquals(honest.stealScore(6), 6);
        assertEquals(honest.score, 4);
    }

    /**
     * Тестирование попытки украсть большего числа очков, чем есть на балансе.
     */
    @Test
    void testStealingPartAmountOfScores() {
        HonestPlayer honest = new HonestPlayer("Honest3");
        honest.score = 3;
        assertEquals(honest.stealScore(9), 3);
        assertEquals(honest.score, 0);
    }

    /**
     * Тестирование попытки украсть очки при нулевом балансе.
     */
    @Test
    void testStealingZeroScores() {
        HonestPlayer honest = new HonestPlayer("Honest4");
        assertEquals(honest.stealScore(5), 0);
        assertEquals(honest.score, 0);
    }

    /**
     * Тестирование строкового представления.
     */
    @Test
    void testToString() {
        HonestPlayer honest = new HonestPlayer("Honest5");
        honest.score = 54;
        assertEquals(honest.toString(), "H | Honest5 | 54");
    }
}