package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class ProductManagerTest {

    @Mock
    private ProductRepository repository;
    @InjectMocks
    private ProductManager manager;

    private Product first = new Book(1, "Book 1", 200, "Author 1", 140, 2017);
    private Product second = new Smartphone(2, "Smartphone 2", 15000, "Producer 2");

    @ParameterizedTest(name = "{index} {0}")
    @CsvSource({
      "Find Book by name, Book 1",
      "Find Book by author, Author 1"})
    public void findBookSearchByTest(String testName, String text) {
        Product[] returned = new Product[] {first, second};
        doReturn(returned).when(repository).findAll();

        manager = new ProductManager(repository);

        Product[] actual = manager.searchBy(text);
        Product[] expected  = new Product[] {first};

        assertArrayEquals(expected, actual);
    }

    @ParameterizedTest(name = "{index} {0}")
    @CsvSource({
      "Find Smartphone by name, Smartphone 2",
      "Find Smartphone by producer, Producer 2"})
    public void findSmartphoneSearchByTest(String testName, String text) {
        Product[] returned = new Product[] {first, second};
        doReturn(returned).when(repository).findAll();

        manager = new ProductManager(repository);

        Product[] actual = manager.searchBy(text);
        Product[] expected = new Product[] {second};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void findNothingSearchByTest() {
        Product[] returned = new Product[] {first, second};
        doReturn(returned).when(repository).findAll();

        manager = new ProductManager(repository);

        Product[] actual = manager.searchBy("Name 3");
        Product[] expected = new Product[0];

        assertArrayEquals(expected, actual);
    }
}