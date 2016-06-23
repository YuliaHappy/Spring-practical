package com.epam.training.spring.core.practical.basic;

public class Ticket {
    private String seat;
    private boolean isBought;
    private String nameEvent;
    private double price;

    public Ticket(String seat, String nameEvent) {
        this.seat = seat;
        this.isBought = false;
        this.nameEvent = nameEvent;
        this.price = 0;
    }

    public String getNameEvent() {
        return nameEvent;
    }

    public void setNameEvent(String nameEvent) {
        this.nameEvent = nameEvent;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "seat='" + seat + '\'' +
                ", isBought=" + isBought +
                ", event=" + nameEvent +
                '}';
    }
}
