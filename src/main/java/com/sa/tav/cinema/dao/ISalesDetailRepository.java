package com.sa.tav.cinema.dao;

import com.sa.tav.cinema.model.entity.SalesDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISalesDetailRepository extends JpaRepository<SalesDetailEntity, Integer> {
}
