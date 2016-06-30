package com.epam.training.spring.core.practical.basic;

public class VipSeat {
    private int id;
    private int idAuditorium;
    private int numberSeat;

    public VipSeat(int id, int idAuditorium, int numberSeat) {
        this.id = id;
        this.idAuditorium = idAuditorium;
        this.numberSeat = numberSeat;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getIdAuditorium() {
        return idAuditorium;
    }

    public int getNumberSeat() {
        return numberSeat;
    }

    @Override
    public String toString() {
        return "VipSeat{" +
                "id=" + id +
                ", idAuditorium=" + idAuditorium +
                ", numberSeat=" + numberSeat +
                '}';
    }
}
