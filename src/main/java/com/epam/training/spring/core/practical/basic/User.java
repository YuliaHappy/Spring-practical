package com.epam.training.spring.core.practical.basic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
    private int id;
    private String name;
    private String email;
    private List<Ticket> bookedTickets;
    private boolean isRegistered;

    private Date birthday;

    public User(String name, String email, Date birthday) {
        this.id = (int) (Math.random() * 1000);
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.bookedTickets = new ArrayList<Ticket>();
        isRegistered = false;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRegistered(boolean registered) {
        isRegistered = registered;
    }

    public void addBookedTicket(Ticket ticket) {
        bookedTickets.add(ticket);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Ticket> getBookedTickets() {
        return bookedTickets;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public Date getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", bookedTickets=" + bookedTickets +
                ", isRegistered=" + isRegistered +
                ", birthday=" + birthday +
                '}';
    }
}
