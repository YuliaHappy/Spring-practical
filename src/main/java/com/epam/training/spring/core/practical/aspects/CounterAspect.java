package com.epam.training.spring.core.practical.aspects;

import com.epam.training.spring.core.practical.basic.Event;
import com.epam.training.spring.core.practical.basic.Ticket;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import java.util.HashMap;
import java.util.Map;

@Aspect
public class CounterAspect {
    private Map<String, Integer> eventByNameCounter;
    private Map<String, Integer> eventPriceCounter;
    private Map<String, Integer> eventBookedTicketCounter;

    public CounterAspect() {
        eventByNameCounter = new HashMap<>();
        eventPriceCounter = new HashMap<>();
        eventBookedTicketCounter = new HashMap<>();
    }

    public Map<String, Integer> getEventByNameCounter() {
        return eventByNameCounter;
    }

    public Map<String, Integer> getEventPriceCounter() {
        return eventPriceCounter;
    }

    public Map<String, Integer> getEventBookedTicketCounter() {
        return eventBookedTicketCounter;
    }

    @AfterReturning("execution(* com.epam.training.spring.core.practical.services.EventService.getByName(..)) " +
            "&& args(nameEvent)")
    public void countEventGetByName(String nameEvent) {
        addEventToCounter(eventByNameCounter, nameEvent);
        System.out.println("Load method getByName!");
    }

    @AfterReturning("execution(* com.epam.training.spring.core.practical.services.BookingService.getTicketPrice(..)) " +
            "&& args(event, ..)")
    public void countEventGetTicketPrice(Event event) {
        addEventToCounter(eventPriceCounter, event.getName());
    }

    @AfterReturning("execution(* com.epam.training.spring.core.practical.services.BookingService.bookTicket()) " +
            "&& args(.., ticket)")
    public void countEventBookTicket(Ticket ticket) {
        addEventToCounter(eventBookedTicketCounter, ticket.getNameEvent());
    }

    private void addEventToCounter(Map<String, Integer> mapCounter, String eventName) {
        int count = mapCounter.containsKey(eventName) ? mapCounter.get(eventName) : 0;
        mapCounter.put(eventName, ++count);
    }
}
