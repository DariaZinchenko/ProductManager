package ru.netology.manager;

import lombok.AllArgsConstructor;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

@AllArgsConstructor
public class ProductManager {

    private ProductRepository repository;

    public void add(Product product) {
        repository.save(product);
    }

    public Product[] searchBy(String text) {
        ProductRepository result = new ProductRepository();
        Product[] products = repository.findAll();

        for (Product product : products) {
            if (matches(product, text)) {
                result.save(product);
            }
        }
        return result.findAll();
    }

    public boolean matches(Product product, String search) {
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getName().equalsIgnoreCase(search)) {
                return true;
            }
            if (book.getAuthor().equalsIgnoreCase(search)) {
                return true;
            }
        }
        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            if (smartphone.getName().equalsIgnoreCase(search)) {
                return true;
            }
            if (smartphone.getProducer().equalsIgnoreCase(search)) {
                return true;
            }
        }
        return false;
    }
}
