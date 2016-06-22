package com.epam.training.spring.core.practical;

import com.epam.training.spring.core.practical.services.AuditoriumService;
import com.epam.training.spring.core.practical.services.EventService;
import com.epam.training.spring.core.practical.services.UserService;

public class Reporter {
    public String createReporter(UserService userService, AuditoriumService auditoriumService,
                                 EventService eventService) {
        StringBuilder reporter = new StringBuilder();
        reporter.append(createTitle());
        reporter.append(createSplitter());
        reporter.append(createUserService(userService));
        reporter.append(createSplitter());
        reporter.append(createAuditoriumService(auditoriumService));
        reporter.append(createSplitter());
        reporter.append(createEventService(eventService));
        return reporter.toString();
    }

    private String createUserService(UserService userService) {
        StringBuilder usersReporter = new StringBuilder();
        usersReporter.append("User service: \n");
        userService.getAll().forEach(user -> usersReporter.append(user.toString() + "\n"));
        return  usersReporter.toString();
    }

    private String createAuditoriumService(AuditoriumService auditoriumService) {
        StringBuilder auditoriumsReporter = new StringBuilder();
        auditoriumsReporter.append("Auditorium service: \n");
        auditoriumService.getAuditoriums().forEach(
                auditorium -> auditoriumsReporter.append(auditorium.toString() + "\n"));
        return  auditoriumsReporter.toString();
    }

    private String createEventService(EventService eventService) {
        StringBuilder eventReporter = new StringBuilder();
        eventReporter.append("Event service: \n");
        eventService.getAll().forEach(
                event -> eventReporter.append(event.toString() + "\n"));
        return  eventReporter.toString();
    }

    private String createSplitter() {
        return "--------------------------------------------------------------\n";
    }

    private String createTitle() {
        return "SERVICES\n" +
                "--------------------------------------------------------------\n";
    }
}
