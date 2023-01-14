package com.sa.tav.cinema.service;

import com.sa.tav.cinema.dao.IFunctionsRepository;
import com.sa.tav.cinema.dao.IRoomsRepository;
import com.sa.tav.cinema.dto.ResponseDto;
import com.sa.tav.cinema.dto.ResponseSuccess;
import com.sa.tav.cinema.exception.CinemaException;
import com.sa.tav.cinema.model.entity.RoomsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomsService extends AbstractService<RoomsEntity, IRoomsRepository> {

    @Autowired
    IRoomsRepository repository;

    public ResponseDto delete(int id){
        RoomsEntity entity = new RoomsEntity();
        entity.setIdRoom(id);
        this.repository.delete(entity);
        return new ResponseSuccess();
    }

    public ResponseDto findRoomNotFunction(){
        return new ResponseSuccess(this.repository.findRoomNotFunction());
    }


    @Override
    public RoomsEntity create(RoomsEntity entity) throws CinemaException {
        return super._save(entity);
    }

    @Override
    public List<RoomsEntity> findAll() throws CinemaException {
        return super._getAll();
    }


    @Override
    public boolean deleteById(int id) throws CinemaException {
        return super._delete(id);
    }

    @Override
    public RoomsEntity update(RoomsEntity entity) throws CinemaException {
        return super._update(entity);
    }
}
