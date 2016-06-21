package com.epam.training.spring.core.practical.services;

import com.epam.training.spring.core.practical.basic.Event;
import com.epam.training.spring.core.practical.basic.Ticket;
import com.epam.training.spring.core.practical.basic.User;
import com.epam.training.spring.core.practical.discountStrategy.DiscountStrategy;

import java.util.List;

public class DiscountService {
    private List<DiscountStrategy> discountStrategies;

    public DiscountService(List<DiscountStrategy> discountStrategies) {
        this.discountStrategies = discountStrategies;
    }

    public double getDiscount(User user, Event event) {
        double discount = 0;
        for (DiscountStrategy ds :
                discountStrategies) {
            discount += ds.getDiscount(user, event);
        }
        return discount;
    }
}
