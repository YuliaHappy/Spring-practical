package com.epam.training.spring.core.practical.aspects;

import com.epam.training.spring.core.practical.basic.User;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import java.util.HashMap;
import java.util.Map;

@Aspect
public class DiscountAspect {
    private Map<String, Integer> discountCounter;
    private Map<String, Integer> discountUserCounter;

    public DiscountAspect() {
        discountCounter = new HashMap<>();
        discountUserCounter = new HashMap<>();
    }

    public Map<String, Integer> getDiscountCounter() {
        return discountCounter;
    }

    public Map<String, Integer> getDiscountUserCounter() {
        return discountUserCounter;
    }

    @AfterReturning(pointcut = "execution(* com.epam.training.spring.core.practical.discountStrategy.impl.BirthdayStrategy.getDiscount(..)) " +
            "&& args(user, ..)", returning = "discount")
    public void countBirthdayDiscount(User user, double discount) {
        if (discount != 0) {
            addDiscountToCounter(discountCounter, "Birthday discount");
            addDiscountToCounter(discountUserCounter, user.getName());
        }
    }

    @AfterReturning(pointcut = "execution(* com.epam.training.spring.core.practical.discountStrategy.impl.NumberTicketStrategy.getDiscount(..)) " +
            "&& args(user, ..)", returning = "discount")
    public void countNumberTicketDiscount(User user, double discount) {
        if (discount != 0) {
            addDiscountToCounter(discountCounter, "Birthday discount");
            addDiscountToCounter(discountUserCounter, user.getName());
        }
    }

    private void addDiscountToCounter(Map<String, Integer> mapCounter, String discountName) {
        int count = mapCounter.containsKey(discountName) ? mapCounter.get(discountName) : 0;
        mapCounter.put(discountName, ++count);
    }
}
