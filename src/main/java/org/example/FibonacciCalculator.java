package org.example;

import org.springframework.stereotype.Component;
import java.math.BigInteger;

@Component
public class FibonacciCalculator {

    public BigInteger calculate(long index) {
        if (index < 1) {
            throw new IllegalArgumentException("Index should be greater or equal to 1");
        }

        if (index == 1 || index == 2) {
            return BigInteger.ONE;
        }

        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        BigInteger c = BigInteger.ZERO;

        for (long i = 3; i <= index; i++) {
            c = a.add(b);
            a = b;
            b = c;
        }

        return c;
    }
}
