package rodionov208.utils;

import java.util.Scanner;

/**
 * Утилита для ввода данных с консоли.
 * @author Родионов Алексей БПИ208.
 */
public class ConsoleWorker {
    /**
     * Сканер для консоли.
     */
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Метод чтения строки из консоли.
     * @return Полученная строка.
     */
    public static String readString() {
        return scanner.nextLine();
    }

    /**
     * Метод чтения числа из заданного диапазона.
     * @param min Минимальное число диапазона.
     * @param max Максимальное число диапазона.
     * @return Полученное число.
     */
    public static int readInt(int min, int max) {
        while (true) {
            int val;
            try {
                val = Integer.parseInt(scanner.next());
                if (val >= min && val <= max) {
                    scanner.nextLine();
                    return val;
                }
                System.out.print("The value does not fall within the range " + min + ", " + max + ". Try again: ");
            } catch (Exception e) {
                System.out.print("The value is not an integer type. Try again: ");
            }
        }
    }
}
