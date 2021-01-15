package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    private int id;
    private String name;
    private long prise;

    public boolean matches(String search) {
        if (name.equalsIgnoreCase(search)) {
            return true;
        }
        return false;
    }
}
