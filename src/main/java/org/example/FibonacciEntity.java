package org.example;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "fibonacci_entity")
public class FibonacciEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "`index`", unique = true, nullable = false)
    private Integer index;

    @Column(nullable = false)
    private BigInteger value;

    // Конструктор для инициализации объекта с индексом и значением
    public FibonacciEntity(int index, BigInteger value) {
        this.index = index;
        this.value = value;
    }

    // Пустой конструктор для JPA
    public FibonacciEntity() {
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public BigInteger getValue() {
        return value;
    }

    public void setValue(BigInteger value) {
        this.value = value;
    }
}
