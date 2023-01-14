package com.sa.tav.cinema.controller;

import com.sa.tav.cinema.dto.ResponseDto;
import com.sa.tav.cinema.model.entity.MoviesEntity;
import com.sa.tav.cinema.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping(value = "movies")
public class MoviesController {

    @Autowired
    MoviesService service;

    @GetMapping()
    ResponseDto getAll(){
        return this.service.getAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    ResponseDto create(@RequestBody MoviesEntity entity){
        return this.service.save(entity);
    }

    @PutMapping(value = "/update")
    ResponseDto update(@RequestBody MoviesEntity entity){
        return this.service.save(entity);
    }

    @DeleteMapping(value = "{id}")
    ResponseDto delete(@PathVariable int id){
        return this.service.delete(id);
    }

    @GetMapping( value = "available" ,produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseDto findRoomNotFunction(){
        return this.service.findAvailable();
    }

    @GetMapping( value = "{id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseDto findById(@PathVariable("id") int id){
        return this.service.findById(id);
    }
}
