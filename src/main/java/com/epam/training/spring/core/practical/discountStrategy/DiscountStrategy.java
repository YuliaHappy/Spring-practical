package com.epam.training.spring.core.practical.discountStrategy;

import com.epam.training.spring.core.practical.basic.Event;
import com.epam.training.spring.core.practical.basic.User;

public interface DiscountStrategy {
    double getDiscount(User user, Event event);
}
