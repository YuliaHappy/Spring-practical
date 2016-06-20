package com.epam.training.spring.core.practical.dao.impl;

import com.epam.training.spring.core.practical.basic.Auditorium;
import com.epam.training.spring.core.practical.dao.interfaces.AuditoriumDao;

import java.util.List;
import java.util.Set;

public class MemoryAuditoriumDaoImpl implements AuditoriumDao{
    private List<Auditorium> auditoriums;

    public MemoryAuditoriumDaoImpl(List<Auditorium> auditoriums) {
        this.auditoriums = auditoriums;
    }

    @Override
    public void add(Auditorium auditorium) {
        auditoriums.add(auditorium);
    }

    @Override
    public void remove(Auditorium auditorium) {
        auditoriums.remove(auditorium);
    }

    @Override
    public Auditorium getById(int id) {
        for (Auditorium a :
                auditoriums) {
            if (a.getId() == id) {
                return a;
            }
         }
        return null;
    }

    @Override
    public Set<Integer> getSeatsNumber(Auditorium auditorium) {
        return auditorium.getAllSeats();
    }

    @Override
    public Set<Integer> getVipSeats(Auditorium auditorium) {
        return auditorium.getVipSeats();
    }

    @Override
    public List<Auditorium> getAll() {
        return auditoriums;
    }
}
