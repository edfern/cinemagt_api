package com.sa.tav.cinema.service;

import com.sa.tav.cinema.dao.ITicketsRepository;
import com.sa.tav.cinema.dto.ResponseDto;
import com.sa.tav.cinema.dto.ResponseSuccess;
import com.sa.tav.cinema.model.entity.TicketsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class TicketsService {

    @Autowired
    ITicketsRepository repository;

    public ResponseDto getAll(){
        return new ResponseSuccess(this.repository.findAll());
    }

    public ResponseDto save(TicketsEntity entity){
        return new ResponseSuccess(this.repository.save(entity));
    }

    public ResponseDto update(TicketsEntity entity){
        return new ResponseSuccess(this.update(entity));
    }

    public ResponseDto delete(int id){
        TicketsEntity entity = new TicketsEntity();
        entity.setIdTicket(id);
        this.repository.delete(entity);
        return new ResponseSuccess();
    }

    public ResponseDto findSeatsByDate(int id, Date date){
        return new ResponseSuccess(this.repository.findSeatsByDate(id, date));
    }
}
