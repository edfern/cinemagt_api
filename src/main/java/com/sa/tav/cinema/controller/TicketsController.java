package com.sa.tav.cinema.controller;

import com.sa.tav.cinema.dto.ResponseDto;
import com.sa.tav.cinema.model.entity.TicketsEntity;
import com.sa.tav.cinema.service.TicketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@CrossOrigin
@RequestMapping("tickets")
public class TicketsController {

    @Autowired
    TicketsService service;

    @GetMapping()
    ResponseDto getAll(){
        return this.service.getAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    ResponseDto create(@RequestBody TicketsEntity entity){
        System.out.println(entity);
        return this.service.save(entity);
    }

    @PutMapping(value = "/update")
    ResponseDto update(@RequestBody TicketsEntity entity){
        return this.service.save(entity);
    }

    @DeleteMapping(value = "{id}")
    ResponseDto delete(@PathVariable int id){
        return this.service.delete(id);
    }

    @RequestMapping(value = "{id}/{date}", method = RequestMethod.GET)
    ResponseDto findSeatsByDate(@PathVariable("id") int id, @PathVariable("date")Date date){
        return this.service.findSeatsByDate(id, date);
    }
}
