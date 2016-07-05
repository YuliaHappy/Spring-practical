package com.epam.training.spring.core.practical.strategy.discount.impl;

import com.epam.training.spring.core.practical.basic.Event;
import com.epam.training.spring.core.practical.basic.User;
import com.epam.training.spring.core.practical.strategy.discount.DiscountStrategy;

import java.util.Random;

public class NumberTicketStrategy implements DiscountStrategy {
    @Override
    public double getDiscount(User user, Event event) {
        return (new Random().nextInt() + 1) % 10 == 0 ? 50 : 0;
    }
}
