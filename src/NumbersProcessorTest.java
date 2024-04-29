package src;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumbersProcessorTest {

    @org.junit.Test
    public void test_min() {
        int[] numbers = {5, 10, 3, 8};
        assertEquals(3, NumbersProcessor._min(numbers));
    }

    @org.junit.Test
    public void test_max() {
        int[] numbers = {5, 10, 3, 8};
        assertEquals(10, NumbersProcessor._max(numbers));
    }

    @org.junit.Test
    public void test_sum() {
        int[] numbers = {5, 10, 3, 8};
        assertEquals(26, NumbersProcessor._sum(numbers));
    }

    @org.junit.Test
    public void test_mult() {
        int[] numbers = {5, 10, 3, 8};
        assertEquals(1200, NumbersProcessor._mult(numbers));
    }

    @org.junit.Test
    public void testEmptyArray() {
        int[] numbers = {};
        assertEquals(0, NumbersProcessor._min(numbers));
        assertEquals(0, NumbersProcessor._max(numbers));
        assertEquals(0, NumbersProcessor._sum(numbers));
        assertEquals(0, NumbersProcessor._mult(numbers));
    }

    @org.junit.Test
    public void testNegativeNumbers() {
        int[] numbers = {-5, -10, -3, -8};
        assertEquals(-10, NumbersProcessor._min(numbers));
        assertEquals(-3, NumbersProcessor._max(numbers));
        assertEquals(-26, NumbersProcessor._sum(numbers));
        assertEquals(1200, NumbersProcessor._mult(numbers));
    }

    @org.junit.Test
    public void testRandomData() {
        int[] numbers = {5, 10, 3, 8, 15, 20};
        assertEquals(3, NumbersProcessor._min(numbers));
        assertEquals(20, NumbersProcessor._max(numbers));
        assertEquals(61, NumbersProcessor._sum(numbers));
        assertEquals(360000, NumbersProcessor._mult(numbers));
    }

    @org.junit.Test
    public void testLargeData() {
        int[] numbers = new int[1000000];
        Arrays.fill(numbers, 5); // Заполнение массива числами 5
        assertEquals(5, NumbersProcessor._min(numbers));
        assertEquals(5, NumbersProcessor._max(numbers));
        assertEquals(5000000L, NumbersProcessor._sum(numbers));
    }

    @org.junit.Test
    public void testPerformance() throws IOException, InterruptedException {
        int[] sizes = {1000, 10000, 100000, 1000000};
        long[] times = new long[sizes.length];

        for (int i = 0; i < sizes.length; i++) {
            int size = sizes[i];
            String filename = "test_" + size + ".txt";
            generateTestFile(filename, size);

            long startTime = System.nanoTime();
            NumbersProcessor._max(NumbersProcessor.readNumbersFromFile(filename));
            long endTime = System.nanoTime();

            long duration = (endTime - startTime) / 1000000;
            times[i] = duration;

            // Удаление файла после использования
            File file = new File(filename);
            file.delete();
        }
        // Печать результатов
        System.out.println("Время выполнения для разных размеров файла:");
        for (int i = 0; i < sizes.length; i++) {
            System.out.println(sizes[i] + " чисел: " + times[i] + " мс");
        }

        Chart.drawChart(sizes, times);
        Thread.sleep(5000);
    }

    private void generateTestFile(String filename, int size) throws IOException {
        Random random = new Random();
        FileWriter writer = new FileWriter(filename);
        for (int i = 0; i < size; i++) {
            writer.write(random.nextInt(1000) + " ");
        }
        writer.close();
    }
}
