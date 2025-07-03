package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NumbersProcessor {
    public static int getMin(int[] numbers) {
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

    public static void main(String[] args) {
        try {
            System.out.println(getMin(readNumbersFromFile("numbers.txt")));
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
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
