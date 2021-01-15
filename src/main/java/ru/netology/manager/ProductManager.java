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
            if (product.matches(text)) {
                result.save(product);
            }
        }
        return result.findAll();
    }

}
