package com.epam.training.spring.core.practical.controllers;

import com.epam.training.spring.core.practical.basic.Event;
import com.epam.training.spring.core.practical.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = {"/event"})
public class EventController {
    private final String ALL_EVENT = "/allEvents";
    private final String EVENT_ABOUT = "/eventAbout";
    private final String EVENT_DELETE = "/eventDelete";
    private final String EVENT_SAVE = "/eventSave";
    private final String EVENT_PDF = "/pdfEvents";

    @Autowired
    @Qualifier("eventService")
    EventService eventService;

    @RequestMapping(value = ALL_EVENT, method = RequestMethod.GET)
    public ModelAndView getAllEvents() {
        return new ModelAndView("event/allEvents", "events", eventService.getAll());
    }

    @RequestMapping(value = EVENT_ABOUT + "/{name}", method = RequestMethod.GET)
    public ModelAndView getEventById(@PathVariable(value = "name") String name) {
        return new ModelAndView("event/eventAbout", "event", eventService.getByName(name));
    }

    @RequestMapping(value = EVENT_DELETE + "/{name}", method = RequestMethod.GET)
    public ModelAndView deleteEvent(@PathVariable(value = "name") String name) {
        eventService.remove(name);
        return getAllEvents();
    }

    @RequestMapping(value = EVENT_PDF, method = RequestMethod.GET)
    public ModelAndView getAllEventsInPdf() {
        List<Event> events = eventService.getAll();
        return new ModelAndView("pdfViewEvent", "listEvents", events);
    }
}
