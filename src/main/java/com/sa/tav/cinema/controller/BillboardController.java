package com.sa.tav.cinema.controller;

import com.sa.tav.cinema.dto.ResponseDto;
import com.sa.tav.cinema.service.BillboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("billboard")
public class BillboardController {

    @Autowired
    BillboardService service;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto getBillboard(){
        return this.service.getBillboard();
    }

}
