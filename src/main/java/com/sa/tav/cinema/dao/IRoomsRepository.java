package com.sa.tav.cinema.dao;

import com.sa.tav.cinema.model.entity.RoomsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRoomsRepository extends JpaRepository<RoomsEntity, Integer> {

    @Query(value = "SELECT * " +
            "FROM rooms " +
            "WHERE idRoom " +
            "NOT IN (" +
            "SELECT idRoom " +
            "FROM functions " +
            "WHERE state != 'N')", nativeQuery = true)
    List<RoomsEntity> findRoomNotFunction();
}
