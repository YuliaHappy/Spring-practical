package com.epam.training.spring.core.practical.basic;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Auditorium {
    private int id;
    private String name;
    private int countOfSeats;
    private Set<VipSeat> vipSeats;

    public Auditorium(int id, String name, int countOfSeats) {
        this.id = id;
        this.name = name;
        this.countOfSeats = countOfSeats;
        vipSeats = new HashSet<>();
    }

    public void setVipSeats(Set<VipSeat> vipSeats) {
        this.vipSeats = vipSeats;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCountOfSeats() {
        return countOfSeats;
    }

    public Set<VipSeat> getVipSeats() {
        return vipSeats;
    }

    public Set<Integer> getAllSeats() {
        return IntStream.range(1, countOfSeats + 1).boxed().collect(Collectors.toSet());
    }

    public boolean isVip(int seat) {
        return vipSeats.contains(seat);
    }

    @Override
    public String toString() {
        return "Auditorium{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", countOfSeats=" + countOfSeats +
                ", vipSeats=" + vipSeats.toString() +
                '}';
    }
}
