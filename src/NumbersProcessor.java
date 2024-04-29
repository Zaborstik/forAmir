package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NumbersProcessor {
    public static int _min(int[] numbers) {
        if (numbers.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int num : numbers) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    public static int _max(int[] numbers) {
        if (numbers.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int num : numbers) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static int _sum(int[] numbers) {
        if (numbers.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }

    public static long _mult(int[] numbers) {
        if (numbers.length == 0) {
            return 0;
        }
        long mult = 1;
        for (int num : numbers) {
            mult *= num;
        }
        return mult;
    }

    public static void main(String[] args) {
        try {
            int[] numbers = readNumbersFromFile("numbers.txt");

            int min = _min(numbers);
            int max = _max(numbers);
            int sum = _sum(numbers);
            long mult = _mult(numbers);

            System.out.println("Минимальное число: " + min);
            System.out.println("Максимальное число: " + max);
            System.out.println("Сумма всех чисел: " + sum);
            System.out.println("Произведение всех чисел: " + mult);
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
        }
    }

    static int[] readNumbersFromFile(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        int count = 0;
        while (scanner.hasNextInt()) {
            count++;
            scanner.nextInt();
        }
        int[] numbers = new int[count];
        scanner = new Scanner(file);
        for (int i = 0; i < count; i++) {
            numbers[i] = scanner.nextInt();
        }
        scanner.close();
        return numbers;
    }
}
