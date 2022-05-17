package rodionov208.utils;

import java.util.Random;

/**
 * Утилита генератора случайных чисел.
 * @author Родионов Алексей БПИ208.
 */
public class RandomGenerator {
    /**
     * Поле генератора случайных чисел
     */
    private static Random random = new Random();

    /**
     * Конструктор с инициализацией генератора сидом.
     * @param seed Семя :)
     */
    public RandomGenerator(int seed) {
        random = new Random(seed);
    }

    /**
     * Генерация целого числа от 0 до заданного значения.
     * @param bound Верхняя граница
     * @return Сгенерированное число.
     */
    public static int generateInt(int bound) {
        return random.nextInt(bound);
    }

    /**
     * Метод генерации времени для отдыха после взятия карты.
     * @return Случайное число в диапазоне [100, 200].
     */
    public static int generateTimeAfterGettingCard() {
        return random.nextInt(101) + 100;
    }

    /**
     * Метод генерации времени для отдыха после воровства баланса.
     * @return Случайное число в диапазоне [180, 300].
     */
    public static int generateTimeAfterStole() {
        return random.nextInt(121) + 180;
    }

    /**
     * Метод генерации случайного значения взятой карты.
     * @return Значение взятой из колоды карты.
     */
    public static int generateCard() {
        return random.nextInt(10) + 1;
    }

    /**
     * Метод генерации принятия решения шулером для своего хода.
     * @return true, если шулер решает воровать баланс, false, если решает брать карту.
     */
    public static boolean generateCrookDecision() { return random.nextInt(10) < 4; }
}
