package com.epam.training.spring.core.practical.services;

import com.epam.training.spring.core.practical.basic.Auditorium;
import com.epam.training.spring.core.practical.dao.interfaces.AuditoriumDao;

import java.util.List;
import java.util.Set;

public class AuditoriumService {
    AuditoriumDao auditoriumDao;

    public AuditoriumService(AuditoriumDao auditoriumDao) {
        this.auditoriumDao = auditoriumDao;
    }

    public List<Auditorium> getAuditoriums() {
        return auditoriumDao.getAll();
    }

    public Set<Integer> getSeatsNumber(Auditorium auditorium) {
        return auditoriumDao.getSeatsNumber(auditorium);
    }

    public Set<Integer> getVipSeats(Auditorium auditorium) {
        return auditoriumDao.getVipSeats(auditorium);
    }
}
