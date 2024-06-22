package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@RestController
public class FibonacciController {

    private static final Logger logger = LoggerFactory.getLogger(FibonacciController.class);

    @Autowired
    private FibonacciService fibonacciService;

    @GetMapping("/fibonacci")
    public ResponseEntity<Map<String, Object>> getFibonacciNumber(@RequestParam int index) {
        try {
            BigInteger value = fibonacciService.getFibonacciNumber(index);
            Map<String, Object> result = new HashMap<>();
            result.put("index", index);
            result.put("value", value);
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            logger.error("Invalid request for Fibonacci number at index: {}", index, e);
            return ResponseEntity.badRequest().body(Map.of("error", "Invalid index. " + e.getMessage()));
        } catch (Exception e) {
            logger.error("Unexpected error occurred", e);
            return ResponseEntity.internalServerError().body(Map.of("error", "An unexpected error occurred. Please try again later."));
        }
    }
}
