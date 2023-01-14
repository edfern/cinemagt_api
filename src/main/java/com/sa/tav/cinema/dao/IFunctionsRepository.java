package com.sa.tav.cinema.dao;

import com.sa.tav.cinema.model.entity.FunctionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface IFunctionsRepository extends JpaRepository<FunctionsEntity, Integer> {

    @Query(value = "SELECT TOP 10 *" +
            "FROM Functions " +
            "ORDER BY idFunction " +
            "DESC ", nativeQuery = true)
    List<FunctionsEntity> findAll();

    @Query(value = "SELECT * FROM Functions WHERE state != 'N'", nativeQuery = true)
    List<FunctionsEntity> getFunctions();

    FunctionsEntity findByIdFunction(int id);

    List<FunctionsEntity> findAllByEndDateBefore(Date endDate);
}