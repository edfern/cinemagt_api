package com.sa.tav.cinema.dao;

import com.sa.tav.cinema.model.entity.SalesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISalesRepository extends JpaRepository<SalesEntity, Integer> {

    SalesEntity findByIdSale(int idSale);
}
