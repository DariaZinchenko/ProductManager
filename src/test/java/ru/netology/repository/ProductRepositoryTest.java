package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();

    private Product first = new Book(1, "Book 1", 200, "Author 1", 140, 2017);
    private Product second = new Smartphone(2, "Smartphone 2", 15000, "Producer 2");
    private Product third = new Book(3, "Book 1", 300, "Author 1", 374, 2020);
    private Product fourth = new Smartphone(4, "Smartphone 2", 23735, "Producer 2");

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
    }

    @Test
    public void removeByIdElementExistTest() {
        repository.removeById(3);
        Product[] expected = new Product[]{first, second, fourth};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIdElementNotExistTest() {

        assertThrows(NotFoundException.class, () -> repository.removeById(5));
    }
}