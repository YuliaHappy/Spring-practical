package com.epam.training.spring.core.practical.services;

import com.epam.training.spring.core.practical.basic.Event;
import com.epam.training.spring.core.practical.dao.interfaces.EventDao;

import java.time.LocalDateTime;
import java.util.List;

public class EventService {
    private EventDao eventDao;

    public EventService() {
    }

    public EventService(EventDao eventDao) {
        this.eventDao = eventDao;
    }

    public void create(Event event) {
        eventDao.create(event);
    }

    public void remove(Event event) {
        eventDao.remove(event);
    }

    public Event getByName(String name) {
        return eventDao.getByName(name);
    }

    public List<Event> getAll() {
        return eventDao.getAll();
    }

    public List<Event> getForDateRange(LocalDateTime from, LocalDateTime to) {
        return eventDao.getForDateRange(from, to);
    }

    public List<Event> getNextEvents(LocalDateTime to) {
        return eventDao.getNextEvents(to);
    }

    public void createEvents(List<Event> events) {
        for (Event event :
                events) {
            eventDao.create(event);
        }
    }
}
