package com.sa.tav.cinema.service;

import com.sa.tav.cinema.config.JobsConfig;
import com.sa.tav.cinema.dao.IFunctionsRepository;
import com.sa.tav.cinema.dto.ResponseDto;
import com.sa.tav.cinema.dto.ResponseSuccess;
import com.sa.tav.cinema.model.entity.FunctionsEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;


@Service
public class FunctionsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FunctionsService.class);

    @Autowired
    IFunctionsRepository repository;

    public ResponseDto getAll(){
        LOGGER.info(String.format("@%s::getAll()", this.getClass().getName()));
        LOGGER.info("getAll method");
        return new ResponseSuccess(this.repository.findAll());
    }

    public ResponseDto save(FunctionsEntity entity){
        return new ResponseSuccess(this.repository.save(entity));
    }

    public ResponseDto update(FunctionsEntity entity){
        return new ResponseSuccess(this.update(entity));
    }

    public ResponseDto delete(int id){
        FunctionsEntity entity = new FunctionsEntity();
        entity.setIdFunction(id);
        this.repository.delete(entity);
        return new ResponseSuccess();
    }

    public ResponseDto getById(int id){
        return new ResponseSuccess(this.repository.findByIdFunction(id));
    }

    public void verifyDatesOfFunctionsAvailable() throws ParseException {
        LOGGER.info(String.format("@%s::verifyDatesOfFunctionsAvailable()", this.getClass().getName()));
        LOGGER.info("Checking today's dates");


        java.util.Date date = new java.util.Date();

        List<FunctionsEntity> functions = this.repository.findAllByEndDateBefore(new Date(date.getTime()));

        if(functions.isEmpty()){
            LOGGER.info("No functions to modify");
        }else{
            functions.forEach(functionsEntity -> {

                functionsEntity.setState("N");
                FunctionsEntity entity = this.repository.save(functionsEntity);

                //LOGGER.info(String.format("Modified the function with the id: %d"), entity.getIdFunction());

            });
        }

    }

    public void verifyDatesOfFunctionsComingSoon() throws ParseException {
        LOGGER.info(String.format("@%s::verifyDatesOfFunctionsComingSoon()", this.getClass().getName()));
        LOGGER.info("Checking release dates");


        java.util.Date date = new java.util.Date();

        List<FunctionsEntity> functions = this.repository.findAllByEndDateBefore(new Date(date.getTime()));

        if(functions.isEmpty()){
            LOGGER.info("No functions to modify");
        }else{
            functions.forEach(functionsEntity -> {

                functionsEntity.setState("N");
                FunctionsEntity entity = this.repository.save(functionsEntity);

                //LOGGER.info(String.format("Modified the function with the id: %d"), entity.getIdFunction());

            });
        }

    }
}
