package com.epam.training.spring.core.practical.dao.interfaces;

import com.epam.training.spring.core.practical.basic.Auditorium;
import com.epam.training.spring.core.practical.basic.Event;

import java.time.LocalDateTime;
import java.util.List;

public interface EventDao {
    void create(Event event);
    void remove(Event event);
    Event getByName(String name);
    List<Event> getAll();
    List<Event> getForDateRange(LocalDateTime from, LocalDateTime to);
    List<Event> getNextEvents(LocalDateTime to);
    void assignAuditorium(Event event, Auditorium auditorium, LocalDateTime dateTime);
}
