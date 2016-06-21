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

    public App(UserService userService, AuditoriumService auditoriumService, EventService eventService) {
        this.userService = userService;
        this.auditoriumService = auditoriumService;
        this.eventService = eventService;
    }

    private String emailUser;

    public UserService getUserService() {
        return userService;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        App app = (App) ctx.getBean("app");

        System.out.println("User name with email (" + app.getEmailUser() + "): "
                    + app.getUserService().getUserByEmail(app.getEmailUser()).getName());

        Reporter reporter = new Reporter();
        System.out.println(reporter.createReporter(app.userService, app.auditoriumService, app.eventService));


        ctx.close();
    }
}
