package com.epam.training.spring.core.practical.services;

import com.epam.training.spring.core.practical.basic.Event;
import com.epam.training.spring.core.practical.basic.Ticket;
import com.epam.training.spring.core.practical.basic.User;

import java.util.Map;
import java.util.Set;

public class BookingService {
    private DiscountService discountService;
    private Map<Event, Set<Ticket>> bookings;

    public BookingService() {
    }

    public BookingService(DiscountService discountService, Map<Event, Set<Ticket>> bookings) {
        this.discountService = discountService;
        this.bookings = bookings;
    }

    public double getTicketPrice(Event event, Set<Integer> seats, User user) {
        int sum = 0;
        for (Integer seat :
                seats) {
            sum += (event.getAuditorium().isVip(seat)) ?
                    event.getVipPriceTicket() : event.getBasePriceTicket();
        }
        double discount = discountService.getDiscount(user, event);
        return sum * (100 - discount) / 100;
    }

    public void bookTicket(User user, Ticket ticket) {
        if (isBook(ticket)) {
            throw new IllegalArgumentException("Ticket already booked!");
        }
        bookings.get(ticket.getEvent()).add(ticket);
        if (user.isRegistered()) {
            user.addBookedTicket(ticket);
        }
    }

    private boolean isBook(Ticket ticket) {
        Set<Ticket> tickets = bookings.get(ticket.getEvent());
        return !ticket.isBought() && tickets.contains(ticket);
    }
}
