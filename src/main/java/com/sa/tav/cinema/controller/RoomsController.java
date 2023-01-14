package com.sa.tav.cinema.controller;

import com.sa.tav.cinema.dto.ResponseDto;
import com.sa.tav.cinema.dto.ResponseError;
import com.sa.tav.cinema.dto.ResponseSuccess;
import com.sa.tav.cinema.exception.CinemaException;
import com.sa.tav.cinema.model.entity.RoomsEntity;
import com.sa.tav.cinema.service.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "rooms")
public class RoomsController {

    @Autowired
    RoomsService service;

    @RequestMapping(method = RequestMethod.GET)
    ResponseDto getAll(){
        try {
            return new ResponseSuccess(this.service.findAll());
        }catch (CinemaException ex){
            return new ResponseError(500,ex.getMessage());
        }
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    ResponseDto create(@RequestBody RoomsEntity entity){
        try {
            return new ResponseSuccess(this.service.create(entity));
        }catch (CinemaException ex){
            return new ResponseError(500,ex.getMessage());
        }
    }

    @PutMapping(value = "/update")
    ResponseDto update(@RequestBody RoomsEntity entity){
        try {
            return new ResponseSuccess(this.service.update(entity));
        }catch (CinemaException ex){
            return new ResponseError(500,ex.getMessage());
        }
    }

    @DeleteMapping(value = "{id}")
    ResponseDto delete(@PathVariable int id){
        try {
            this.service.deleteById(id);
            return new ResponseSuccess();
        }catch (CinemaException ex){
            return new ResponseError(500,ex.getMessage());
        }
    }

    @GetMapping( value = "findRoomNotFunction" ,produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseDto findRoomNotFunction(){
        return this.service.findRoomNotFunction();
    }
}
