package com.sa.tav.cinema.service;

import com.sa.tav.cinema.dao.ISalesDetailRepository;
import com.sa.tav.cinema.dao.ISalesRepository;
import com.sa.tav.cinema.dao.ITicketsRepository;
import com.sa.tav.cinema.dto.ResponseDto;
import com.sa.tav.cinema.dto.ResponseError;
import com.sa.tav.cinema.dto.ResponseSuccess;
import com.sa.tav.cinema.dto.SalesDto;
import com.sa.tav.cinema.exception.CinemaException;
import com.sa.tav.cinema.model.entity.SalesDetailEntity;
import com.sa.tav.cinema.model.entity.SalesEntity;
import com.sa.tav.cinema.model.entity.TicketsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalesService {

    @Autowired
    ISalesRepository repository;

    @Autowired
    ITicketsRepository ticketsRepository;

    @Autowired
    ISalesDetailRepository detailRepository;

    @Autowired
    ISalesRepository salesRepository;

    public ResponseDto getAll(){
        return new ResponseSuccess(this.repository.findAll());
    }

    public ResponseDto save(SalesDto dto){
        List<SalesDetailEntity> savedSalesDetailList = new ArrayList<>();
        try{
            //Save sale
            SalesEntity sale = this.repository.save(dto.getSale());

            //Save tickets
            List<TicketsEntity> savedTickets = this.ticketsRepository.saveAll(dto.getTickets());

            //Save relations sale -> details
            savedTickets.forEach(ticketsEntity -> {
                SalesDetailEntity entity = new SalesDetailEntity();

                entity.setIdSale(sale.getIdSale());
                entity.setTicket(ticketsEntity);
                entity.setDescription("PAGO -- REALIZADO");
                savedSalesDetailList.add(this.detailRepository.save(entity));
            });

            SalesEntity savedSale = this.salesRepository.findByIdSale(sale.getIdSale());

            if(savedSale.getIdSale() != sale.getIdSale()) throw new CinemaException("Purchase error");

            SalesEntity saleConfirmed = new SalesEntity();
            saleConfirmed.setIdSale(savedSale.getIdSale());
            saleConfirmed.setCustomerName(savedSale.getCustomerName());
            saleConfirmed.setDate(savedSale.getDate());
            saleConfirmed.setTotal(savedSale.getTotal());
            saleConfirmed.setDetails(savedSalesDetailList);

            return new ResponseSuccess(saleConfirmed);


        } catch (Exception ex){
            return new ResponseError(500,ex.getMessage());
        }
    }

    public ResponseDto update(SalesEntity entity){
        return new ResponseSuccess(this.update(entity));
    }

    public ResponseDto delete(int id){
        SalesEntity entity = new SalesEntity();
        entity.setIdSale(id);
        this.repository.delete(entity);
        return new ResponseSuccess();
    }

    public ResponseDto getById(int id){
        return new ResponseSuccess(this.salesRepository.findByIdSale(id));
    }
}
