package io.github.dwin357.tools.stream.consumer;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class SimpleTerminalTest {

    private final Random rand = new Random();

    @Test
    public void returnsCachedItemManyTimes() {
        Integer given = rand.nextInt();
        Integer expected = given;
        SimpleTerminal<Integer> tested = new SimpleTerminal<>();

        tested.consume(given);

        Integer measurement;
        Integer repeatedRunCounter = rand.nextInt(5);
        while(repeatedRunCounter >=0) {
            repeatedRunCounter--;
            measurement = tested.peek();
            assertEquals(expected, measurement);
        }
    }

    @Test
    public void returnsLatestNumber() {
        Integer given_1 = rand.nextInt();
        Integer expected_1 = given_1;
        Integer given_2 = rand.nextInt();
        Integer expected_2 = given_2;
        Integer given_3 = rand.nextInt();
        Integer expected_3 = given_3;
        SimpleTerminal<Integer> tested = new SimpleTerminal<>();

        tested.consume(given_1);
        assertEquals(expected_1, tested.peek());

        tested.consume(given_2);
        assertEquals(expected_2, tested.peek());

        tested.consume(given_3);
        assertEquals(expected_3, tested.peek());
    }
}