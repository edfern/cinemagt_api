package com.sa.tav.cinema.controller;


import com.sa.tav.cinema.dto.ResponseDto;
import com.sa.tav.cinema.model.entity.FunctionsEntity;
import com.sa.tav.cinema.service.FunctionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "functions")
public class FunctionsController {

    @Autowired
    FunctionsService service;

    @GetMapping()
    ResponseDto getAll(){
        return this.service.getAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    ResponseDto create(@RequestBody FunctionsEntity entity){
        return this.service.save(entity);
    }

    @PutMapping(value = "/update")
    ResponseDto update(@RequestBody FunctionsEntity entity){
        return this.service.save(entity);
    }

    @DeleteMapping(value = "{id}")
    ResponseDto delete(@PathVariable int id){
        return this.service.delete(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    ResponseDto getById(@PathVariable int id){
        return this.service.getById(id);
    }
}
