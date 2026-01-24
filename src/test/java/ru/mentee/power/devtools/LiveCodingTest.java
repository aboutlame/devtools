package ru.mentee.power.devtools;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class LiveCodingTest {
    @Test
    void shouldPrintFizzBuzzForAllBranches() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;

        try {
            System.setOut(new PrintStream(out));

            LiveCoding.printFizzBuzz(15);

            String expected = String.join(System.lineSeparator(),
                    "1",
                    "2",
                    "Fizz",
                    "4",
                    "Buzz",
                    "Fizz",
                    "7",
                    "8",
                    "Fizz",
                    "Buzz",
                    "11",
                    "Fizz",
                    "13",
                    "14",
                    "FizzBuzz"
            ) + System.lineSeparator();

            assertThat(out.toString()).isEqualTo(expected);
        } finally {
            System.setOut(originalOut);
        }
    }


    @Test
    void shouldReturnSumOfEvenNumbers(){
        assertThat(LiveCoding.sumEven(new int[] {1, 2, 3, 4, 5, 6})).isEqualTo(12);
    }

    @Test
    void shouldReturnZeroIfArrayContainsOnlyOddNumbers() {
        assertThat(LiveCoding.sumEven(new int[]{1, 3, 5, 7})).isZero();
    }

    @Test
    void shouldReturnZeroIfArrayIsEmpty() {
        assertThat(LiveCoding.sumEven(new int[]{})).isZero();
    }

    @Test
    void shouldReturnMaxOfArray() {
        assertThat(LiveCoding.findMax(new int[] {3, 7, 2, 9, 1})).isEqualTo(9);
    }

    @Test
    void shouldReturnMinValueIfArrayIsEmpty() {
        assertThat(LiveCoding.findMax(new int[] {})).isEqualTo(Integer.MIN_VALUE);
    }

    @Test
    void shouldReturnMaxFromNegativeNumbers() {
        assertThat(LiveCoding.findMax(new int[]{-5, -1, -10})).isEqualTo(-1);
    }

    @Test
    void shouldReturnElementIfArrayContainsSingleValue() {
        assertThat(LiveCoding.findMax(new int[]{42})).isEqualTo(42);
    }
}