package com.epam.training.spring.core.practical.discountStrategy.impl;

import com.epam.training.spring.core.practical.basic.Event;
import com.epam.training.spring.core.practical.basic.User;
import com.epam.training.spring.core.practical.discountStrategy.DiscountStrategy;

public class NumberTicketStrategy implements DiscountStrategy {
    @Override
    public double getDiscount(User user, Event event) {
        return (user.getBookedTickets().size() + 1) % 10 == 0 ? 50 : 0;
    }
}
