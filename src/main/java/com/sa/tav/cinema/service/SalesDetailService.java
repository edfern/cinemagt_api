package com.sa.tav.cinema.service;

import com.sa.tav.cinema.dao.ISalesDetailRepository;
import com.sa.tav.cinema.dto.ResponseDto;
import com.sa.tav.cinema.dto.ResponseSuccess;
import com.sa.tav.cinema.model.entity.SalesDetailEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesDetailService {

    @Autowired
    ISalesDetailRepository repository;

    public ResponseDto getAll(){
        return new ResponseSuccess(this.repository.findAll());
    }

    public ResponseDto save(SalesDetailEntity entity){
        return new ResponseSuccess(this.repository.save(entity));
    }

    public ResponseDto update(SalesDetailEntity entity){
        return new ResponseSuccess(this.update(entity));
    }

    public ResponseDto delete(int id){
        SalesDetailEntity entity = new SalesDetailEntity();
        entity.setIdSaledetail(id);
        this.repository.delete(entity);
        return new ResponseSuccess();
    }
}
