package com.sa.tav.cinema.dto;

import com.sa.tav.cinema.model.entity.SalesDetailEntity;
import com.sa.tav.cinema.model.entity.SalesEntity;
import com.sa.tav.cinema.model.entity.TicketsEntity;

import java.util.List;

public class SalesDto {

    private SalesEntity sale;
    private List<TicketsEntity> tickets;


    public SalesEntity getSale() {
        return sale;
    }

    public void setSale(SalesEntity sale) {
        this.sale = sale;
    }

    public List<TicketsEntity> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketsEntity> tickets) {
        this.tickets = tickets;
    }
}
