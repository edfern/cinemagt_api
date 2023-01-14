package com.sa.tav.cinema.service;

import com.sa.tav.cinema.dao.IFunctionsRepository;
import com.sa.tav.cinema.dto.ResponseDto;
import com.sa.tav.cinema.dto.ResponseSuccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillboardService {

    @Autowired
    IFunctionsRepository functionsRepository;

    public ResponseDto getBillboard(){
        return new ResponseSuccess(this.functionsRepository.getFunctions());
    }
}
