package com.epam.training.spring.core.practical.discountStrategy.impl;

import com.epam.training.spring.core.practical.basic.Event;
import com.epam.training.spring.core.practical.basic.User;
import com.epam.training.spring.core.practical.discountStrategy.DiscountStrategy;

import java.util.Date;

public class BirthdayStrategy implements DiscountStrategy {
    @Override
    public double getDiscount(User user, Event event) {
        Date dateNow = new Date();
        return (user.getBirthday().getMonth() == event.getDateTime().getMonthValue() &&
                user.getBirthday().getDay() == event.getDateTime().getDayOfMonth()) ?
                5 : 0;
    }
}
