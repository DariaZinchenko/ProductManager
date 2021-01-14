package ru.netology.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Book extends Product{
    private String author;
    private int pages;
    private int publishedYear;

    public Book(int id, String name, long prise, String author, int pages, int publishedYear) {
        super(id, name, prise);
        this.author = author;
        this.pages = pages;
        this.publishedYear = publishedYear;
    }
}
