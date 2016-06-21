package com.epam.training.spring.core.practical.basic;

public class Ticket {
    private String seat;
    private boolean isBought;
    private Event event;

    public Ticket(String seat, Event event) {
        this.seat = seat;
        this.isBought = false;
        this.event = event;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public boolean isBought() {
        return isBought;
    }

    public void setBought(boolean bought) {
        isBought = bought;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "seat='" + seat + '\'' +
                ", isBought=" + isBought +
                ", event=" + event.getName() +
                '}';
    }
}
