package rodionov208.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Класс тестирования методов честного игрока.
 * @author Родионов Алексей БПИ208.
 */
class RandomGeneratorTest {
    /**
     * Инициализация генератора случайных чисел заданным значением 54 для детерминированной генерации.
     */
    @BeforeAll
    static void initializeFields() {
        RandomGenerator rnd = new RandomGenerator(54);
    }

    /**
     * Тестирование детерминированной генерации времени для сна после взятия карты.
     */
    @Test
    void testGenerateTimeAfterGettingCard() {
        assertEquals(RandomGenerator.generateTimeAfterGettingCard(), 114);
    }

    /**
     * Тестирование детерминированной генерации времени для сна после воровства очков.
     */
    @Test
    void testGenerateTimeAfterStole() {
        assertEquals(RandomGenerator.generateTimeAfterStole(), 225);
    }

    /**
     * Тестирование детерминированной генерации взятия карты из колоды.
     */
    @Test
    void testGenerateCard() {
        assertEquals(RandomGenerator.generateCard(), 10);
    }

    /**
     * Тестирование детерминированной генерации числа из случайного диапазона.
     */
    @Test
    void testGenerateInt() {
        assertEquals(RandomGenerator.generateInt(10), 0);
    }

    /**
     * Тестирование детерминированного принятия решения шулером.
     */
    @Test
    void testGenerateCrookDecision() {
        assertFalse(RandomGenerator.generateCrookDecision());
    }
}