package com.epam.training.spring.core.practical.basic;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class Event {
    private String name;
    private LocalDateTime dateTime;
    private Rating rating;
    private int basePriceTicket;
    private int vipPriceTicket;
    private Auditorium auditorium;
    private Set<Ticket> tickets;

    public Event(String name, LocalDateTime dateTime, String rating,
                 int basePriceTicket, int vipPriceTicket) {
        this.name = name;
        this.dateTime = dateTime;
        this.rating = Rating.valueOf(rating);
        this.basePriceTicket = basePriceTicket;
        this.vipPriceTicket = vipPriceTicket;
        tickets = new HashSet<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public void setBasePriceTicket(int basePriceTicket) {
        this.basePriceTicket = basePriceTicket;
    }

    public Set<Ticket> getTickets() {
        return tickets;
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
        for (int i = 0; i < auditorium.getCountOfSeats(); i++) {
            tickets.add(new Ticket(Integer.toString(i + 1), this.name));
        }
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", rating=" + rating.toString() +
                ", basePriceTicket=" + basePriceTicket +
                ", dateTime=" + dateTime.toString() +
                ", vipPriceTicket=" + vipPriceTicket +
                ", tickets=" + tickets.toString() +
                '}';
    }
}

