package com.epam.training.spring.core.practical.dao.interfaces;

import com.epam.training.spring.core.practical.basic.Auditorium;

import java.util.List;
import java.util.Set;

public interface AuditoriumDao {
    void add(Auditorium auditorium);
    void remove(Auditorium auditorium);
    Auditorium getById(int id);
    Set<Integer> getSeatsNumber(Auditorium auditorium);
    Set<Integer> getVipSeats(Auditorium auditorium);
    List<Auditorium> getAll();
}
