package com.epam.training.spring.core.practical.dao.impl;

import com.epam.training.spring.core.practical.basic.Auditorium;
import com.epam.training.spring.core.practical.basic.Event;
import com.epam.training.spring.core.practical.dao.interfaces.EventDao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class MemoryEventDaoImpl implements EventDao {
    private List<Event> events;

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    @Override
    public void create(Event event) {
        events.add(event);
    }

    @Override
    public void remove(Event event) {
        events.remove(event);
    }

    @Override
    public Event getByName(String name) {
        for (Event e :
                events) {
            if (e.getName().equals(name)) {
                return e;
            }
        }
        return null;
    }

    @Override
    public List<Event> getAll() {
        return events;
    }

    @Override
    public List<Event> getForDateRange(LocalDateTime from, LocalDateTime to) {
        return events.stream().filter(e -> e.getDateTime().isAfter(from) && e.getDateTime().isBefore(to)).collect(Collectors.toList());
    }

    //TODO
    @Override
    public List<Event> getNextEvents(LocalDateTime to) {
        return null;
    }

    @Override
    public void assignAuditorium(Event event, Auditorium auditorium, LocalDateTime dateTime) {
        event.setAuditorium(auditorium);
        event.setDateTime(dateTime);
    }
}
