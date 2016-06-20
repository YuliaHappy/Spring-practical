package com.epam.training.spring.core.practical.dao.interfaces;

import com.epam.training.spring.core.practical.basic.Ticket;

public interface BookingDao {
    boolean isBook(Ticket ticket);
    void bookTicket(Ticket ticket);
}
