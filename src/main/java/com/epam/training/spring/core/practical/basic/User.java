package com.epam.training.spring.core.practical.basic;

import javax.persistence.*;
import java.util.*;

@Entity(name = "User")
@Table(name = "user", schema = "bookingservice")
public class User {
    @Id
    @SequenceGenerator(name = "user_seq", sequenceName = "bookingservice.user_id_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "user_seq")
    private int id;

    private String name;

    private String email;

    private boolean isRegistered;

    @Temporal(TemporalType.DATE)
//    @Column(name = "birthday")
    private Date birthday;

    public User() {

    }

    public User(String name, String email, Date birthday) {
        this.name = name;
        this.email = email;
        this.birthday = birthday;
    }

    public User(int id, String name, String email, Date birthday) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRegistered(boolean registered) {
        isRegistered = registered;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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
                ", isRegistered=" + isRegistered +
                ", birthday=" + birthday +
                '}';
    }

    public void update(String name, String email, boolean isRegistered) {
        this.name = name;
        this.email = email;
        this.isRegistered = isRegistered;
    }
}
