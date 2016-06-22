package com.epam.training.spring.core.practical.aspects;

import com.epam.training.spring.core.practical.basic.Ticket;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LuckyWinnerAspect {
    private int luckyTicketsCount;

    public LuckyWinnerAspect() {
        luckyTicketsCount = 0;
    }

    public int getLuckyTicketsCount() {
        return luckyTicketsCount;
    }

    @Before("execution(* com.epam.training.spring.core.practical.services.BookingService.bookTicket(..)) " +
            "&&args(.., ticket)")
    public void checkLucky(Ticket ticket) {
        if (isLucky()) {
            ticket.setPrice(0.00);
        }
    }

    private boolean isLucky() {
        int randA = (int) (Math.random() * 1000);
        int randB = (int) (Math.random() * 1000);
        if (randA == randB) {
            luckyTicketsCount ++;
            return true;
        }
        return false;
    }
}
