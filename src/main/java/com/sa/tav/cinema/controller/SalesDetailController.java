package com.sa.tav.cinema.controller;

import com.sa.tav.cinema.dto.ResponseDto;
import com.sa.tav.cinema.model.entity.SalesDetailEntity;
import com.sa.tav.cinema.service.SalesDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("salesdetail")
public class SalesDetailController {

    @Autowired
    SalesDetailService service;

    @GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseDto getAll(){
        return this.service.getAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseDto create(@RequestBody SalesDetailEntity entity){
        return this.service.save(entity);
    }

    @PutMapping(value = "/update")
    ResponseDto update(@RequestBody SalesDetailEntity entity){
        return this.service.save(entity);
    }

    @DeleteMapping(value = "{id}")
    ResponseDto delete(@PathVariable int id){
        return this.service.delete(id);
    }
}
