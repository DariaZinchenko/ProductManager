package ru.netology.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

class BookTest {

   /* @Test
    public void shouldHaveAllFieldsAndMethodFromSuperClass(){
        Book book = new Book();
    }*/

    @Test
    public void shouldUseEquals(){
        Book book1 = new Book(1, "kniga", 100, "Author", 500, 2020);
        Book book2 = new Book(1, "kniga", 100, "Author", 500, 2020);

        assertEquals(book1, book2);
    }

    @ParameterizedTest(name = "{index} {0}")
    @CsvSource({
      "Find Book by name, Book 1, true",
      "Find Book by author, Author 1, true",
      "Find nothing, Author 34, false"})
    public void matchesTest(String testName, String text, boolean expected) {
        Book book = new Book(1, "Book 1", 200, "Author 1", 140, 2017);
        boolean actual = book.matches(text);

        assertEquals(expected, actual);
    }
}