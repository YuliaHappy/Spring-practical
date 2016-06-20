package com.epam.training.spring.core.practical.dao.impl;

import com.epam.training.spring.core.practical.basic.Event;
import com.epam.training.spring.core.practical.basic.Ticket;
import com.epam.training.spring.core.practical.dao.interfaces.BookingDao;

import java.util.Map;
import java.util.Set;

public class MemoryBookingDaoImpl implements BookingDao {
    private Map<Event, Set<Ticket>> bookings;

    public void setBookings(Map<Event, Set<Ticket>> bookings) {
        this.bookings = bookings;
    }

    @Override
    public boolean isBook(Ticket ticket) {
        Set<Ticket> tickets = bookings.get(ticket.getEvent());
        return !ticket.isBought() && tickets.contains(ticket);
    }

    @Override
    public void bookTicket(Ticket ticket) {
        bookings.get(ticket.getEvent()).add(ticket);
    }
}
