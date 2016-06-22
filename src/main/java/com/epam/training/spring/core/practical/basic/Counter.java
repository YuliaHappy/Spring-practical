package com.epam.training.spring.core.practical.basic;

import java.util.HashMap;
import java.util.Map;

public class Counter {
    private int id;
    private String name;
    private Map<User, Long> counter;

    public Counter(String name) {
        this.id = (int) (Math.random() * 1000);
        this.name = name;
        this.counter = new HashMap<>();
    }

    public void add(User user) {

    }
}
