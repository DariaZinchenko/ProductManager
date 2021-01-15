package ru.netology.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {

    @ParameterizedTest(name = "{index} {0}")
    @CsvSource({
      "Find Smartphone by name, Smartphone 2, true",
      "Find Smartphone by producer, Producer 2, true",
      "Find nothing, Author 34, false"})
    public void matchesTest(String testName, String text, boolean expected) {
        Smartphone smartphone = new Smartphone(2, "Smartphone 2", 15000, "Producer 2");

        boolean actual = smartphone.matches(text);

        assertEquals(expected, actual);
    }

}