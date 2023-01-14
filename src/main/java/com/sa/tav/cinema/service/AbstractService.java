package com.sa.tav.cinema.service;

import com.sa.tav.cinema.exception.CinemaException;
import com.sa.tav.cinema.model.entity.AbstractEntity;
import com.sa.tav.cinema.util.ICreateService;
import com.sa.tav.cinema.util.IDeleteService;
import com.sa.tav.cinema.util.IFindAllService;
import com.sa.tav.cinema.util.IUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class AbstractService<T extends AbstractEntity, U extends JpaRepository> implements IFindAllService<T>, ICreateService<T>, IUpdateService<T>, IDeleteService<T> {

    @Autowired
    private U repository;

    protected final List<T> _getAll() throws CinemaException {

        try{
            return this.repository.findAll();
        }catch (Exception ex){
            throw new CinemaException(ex.getMessage());
        }
    }

    protected final T _save(T entity) throws CinemaException{
        try{
            return (T) this.repository.save(entity);
        }catch (Exception ex){
            throw new CinemaException(ex.getMessage());
        }
    }

    protected final T _update(T entity) throws CinemaException {
        try{
            return (T) this.repository.save(entity);
        }catch (Exception ex){
            throw new CinemaException(ex.getMessage());
        }
    }

    protected final boolean _delete (int id) throws CinemaException{
        try{
            this.repository.deleteById(id);
            return true;
        }catch (Exception ex){
            throw new CinemaException(ex.getMessage());
        }
    }


}
