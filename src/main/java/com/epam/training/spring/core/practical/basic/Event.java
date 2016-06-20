package com.epam.training.spring.core.practical.basic;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

public class Event {
    private String name;
    private Rating rating;
    private int basePriceTicket;
    private LocalDateTime dateTime;
    private Auditorium auditorium;
    private int vipPriceTicket;

    public Event(String name, LocalDateTime dateTime, Auditorium auditorium,
                 Rating rating, int basePriceTicket, int vipPriceTicket) {
        this.name = name;
        this.dateTime = dateTime;
        this.auditorium = auditorium;
        this.rating = rating;
        this.basePriceTicket = basePriceTicket;
        this.vipPriceTicket = vipPriceTicket;
    }

    public String getName() {
        return name;
    }

    public Rating getRating() {
        return rating;
    }

    public int getBasePriceTicket() {
        return basePriceTicket;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public int getVipPriceTicket() {
        return vipPriceTicket;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Auditorium getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }
}

