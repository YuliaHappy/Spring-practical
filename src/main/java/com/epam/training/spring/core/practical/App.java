package com.epam.training.spring.core.practical;

import com.epam.training.spring.core.practical.services.AuditoriumService;
import com.epam.training.spring.core.practical.services.EventService;
import com.epam.training.spring.core.practical.services.UserService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
    private UserService userService;
    private AuditoriumService auditoriumService;
    private EventService eventService;
    private String emailUser;
    private String nameEvent;

    public App(UserService userService, AuditoriumService auditoriumService,
               EventService eventService) {
        this.userService = userService;
        this.auditoriumService = auditoriumService;
        this.eventService = eventService;
    }

    public UserService getUserService() {
        return userService;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public String getNameEvent() {
        return nameEvent;
    }

    public AuditoriumService getAuditoriumService() {
        return auditoriumService;
    }

    public EventService getEventService() {
        return eventService;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public void setNameEvent(String nameEvent) {
        this.nameEvent = nameEvent;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        App app = (App) ctx.getBean("app");

        String s = String.format("User name with email (%s): %s", app.getEmailUser(),
                app.getUserService().getUserByEmail(app.getEmailUser()).getName());
        System.out.println(s);

        Reporter reporter = new Reporter();
        System.out.println(reporter.createReporter(app.getUserService(), app.getAuditoriumService(),
                app.getEventService()));

        app.getEventService().getByName(app.getNameEvent());

        ctx.close();
    }
}
