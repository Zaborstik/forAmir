package src;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumbersProcessorTest {

    @org.junit.Test
    public void testMin() {
        int[] numbers = {5, 10, 3, 8};
        assertEquals(3, NumbersProcessor.getMin(numbers));
    }

    @org.junit.Test
    public void testEmptyArray() {
        int[] numbers = {};
        assertEquals(0, NumbersProcessor.getMin(numbers));
    }

    @org.junit.Test
    public void testNegativeNumbers() {
        int[] numbers = {-5, -10, -3, -8};
        assertEquals(-10, NumbersProcessor.getMin(numbers));
    }

    @org.junit.Test
    public void testRandomData() {
        int[] numbers = {5, 10, 3, 8, 15, 20};
        assertEquals(3, NumbersProcessor.getMin(numbers));
    }

    @org.junit.Test
    public void testLargeData() {
        int[] numbers = new int[1000000];
        Arrays.fill(numbers, 5); // Заполнение массива числами 5
        assertEquals(5, NumbersProcessor.getMin(numbers));
    }
}
