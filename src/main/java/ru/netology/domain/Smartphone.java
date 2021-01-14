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
public class Smartphone extends Product{
    private String producer;

    public Smartphone(int id, String name, long prise, String producer) {
        super(id, name, prise);
        this.producer = producer;
    }
}
