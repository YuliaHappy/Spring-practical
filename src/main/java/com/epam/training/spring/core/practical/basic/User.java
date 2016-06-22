package com.epam.training.spring.core.practical.basic;

import java.util.*;

public class User {
    private int id;
    private String name;
    private String email;
    private Set<Ticket> bookedTickets;
    private boolean isRegistered;

    private Date birthday;

    public User(String name, String email, Date birthday) {
        this.id = new Random().nextInt();
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.bookedTickets = new HashSet();
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

    public Set<Ticket> getBookedTickets() {
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
                ", bookedTickets=" + bookedTickets.toString() +
                ", isRegistered=" + isRegistered +
                ", birthday=" + birthday +
                '}';
    }

    public void update(String name, String email,
                       Set<Ticket> bookedTickets, boolean isRegistered) {
        this.name = name;
        this.email = email;
        this.bookedTickets = bookedTickets;
        this.isRegistered = isRegistered;
    }
}
