package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class FibonacciService {

    private final FibonacciRepository repository;
    private final Map<Integer, BigInteger> memoizationMap;

    @Autowired
    public FibonacciService(FibonacciRepository repository) {
        this.repository = repository;
        this.memoizationMap = new ConcurrentHashMap<>();
    }

    public BigInteger getFibonacciNumber(int index) {
        validateIndex(index);
        return memoizationMap.computeIfAbsent(index, this::computeFibonacci);
    }

    private void validateIndex(int index) {
        if (index < 1) {
            throw new IllegalArgumentException("Index should be greater or equal to 1");
        }
    }

    private BigInteger computeFibonacci(int index) {
        return repository.findByIndex(index)
                .map(FibonacciEntity::getValue)
                .orElseGet(() -> calculateAndStoreFibonacci(index));
    }

    private BigInteger calculateAndStoreFibonacci(int index) {
        BigInteger value = calculateFibonacci(index);
        FibonacciEntity entity = new FibonacciEntity(index, value);
        repository.save(entity);
        return value;
    }

    private BigInteger calculateFibonacci(int index) {
        if (index <= 2) {
            return BigInteger.ONE;
        }
        BigInteger a = BigInteger.ONE, b = BigInteger.ONE, c;
        for (int i = 3; i <= index; i++) {
            c = a.add(b);
            a = b;
            b = c;
        }
        return b;
    }
}