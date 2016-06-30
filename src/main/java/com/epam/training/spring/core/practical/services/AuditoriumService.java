package com.epam.training.spring.core.practical.services;

import com.epam.training.spring.core.practical.basic.Auditorium;
import com.epam.training.spring.core.practical.basic.VipSeat;
import com.epam.training.spring.core.practical.dao.interfaces.AuditoriumDao;

import java.util.List;
import java.util.Set;

public class AuditoriumService {
    private AuditoriumDao auditoriumDao;

    public AuditoriumService(AuditoriumDao auditoriumDao) {
        this.auditoriumDao = auditoriumDao;
    }

    public List<Auditorium> getAuditoriums() {
        return auditoriumDao.getAll();
    }

    public Set<Integer> getSeatsNumber(Auditorium auditorium) {
        return auditoriumDao.getSeatsNumber(auditorium);
    }

    public Set<VipSeat> getVipSeats(Auditorium auditorium) {
        return auditoriumDao.getVipSeats(auditorium);
    }

    public Auditorium getAuditoriumById(int id) {
        return auditoriumDao.getById(id);
    }

    public void remove(int id) {
        auditoriumDao.remove(id);
    }

    public void add(Auditorium auditorium) {
        auditoriumDao.add(auditorium);
    }
}
