package com.sa.tav.cinema.controller;

import com.sa.tav.cinema.dto.ResponseDto;
import com.sa.tav.cinema.dto.ResponseSuccess;
import com.sa.tav.cinema.dto.SalesDto;
import com.sa.tav.cinema.model.entity.SalesEntity;
import com.sa.tav.cinema.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "sales")
public class SalesController {

    @Autowired
    SalesService service;

    @GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseDto getAll(){
        return this.service.getAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseDto create(@RequestBody SalesDto entity){
        System.out.println(entity);
        return this.service.save(entity);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    ResponseDto getById(@PathVariable int id){
        return this.service.getById(id);
    }


    @PutMapping(value = "/update")
    ResponseDto update(@RequestBody SalesEntity entity){
        return null;
    }

    @DeleteMapping(value = "{id}")
    ResponseDto delete(@PathVariable int id){
        return this.service.delete(id);
    }

}
