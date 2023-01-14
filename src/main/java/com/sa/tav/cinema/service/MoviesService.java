package com.sa.tav.cinema.service;

import com.sa.tav.cinema.dao.IMoviesRepository;
import com.sa.tav.cinema.dto.ResponseDto;
import com.sa.tav.cinema.dto.ResponseSuccess;
import com.sa.tav.cinema.model.entity.MoviesEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FunctionsService.class);

    @Autowired
    IMoviesRepository repository;

    public ResponseDto getAll(){
        return new ResponseSuccess(this.repository.findAll());
    }

    public ResponseDto save(MoviesEntity entity){
        return new ResponseSuccess(this.repository.save(entity));
    }

    public ResponseDto update(MoviesEntity entity){
        return new ResponseSuccess(this.update(entity));
    }

    public ResponseDto delete(int id){
        MoviesEntity entity = new MoviesEntity();
        entity.setIdMovie(id);
        this.repository.delete(entity);
        return new ResponseSuccess();
    }

    public ResponseDto findAvailable(){
        return new ResponseSuccess(this.repository.findAvailable());
    }

    public ResponseDto findById(int id){
        LOGGER.info(String.format("@%s::findById(%s)", this.getClass().getName(), id));
        return new ResponseSuccess(this.repository.findById(id).get());
    }
}
