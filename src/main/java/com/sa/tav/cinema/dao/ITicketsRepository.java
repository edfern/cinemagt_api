package com.sa.tav.cinema.dao;

import com.sa.tav.cinema.model.entity.TicketsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface ITicketsRepository extends JpaRepository<TicketsEntity, Integer> {

    @Query(value = "SELECT t.seat \n" +
            "FROM tickets t\n" +
            "INNER JOIN Functions f\n" +
            "ON f.idFunction = t.idFunction\n" +
            "INNER JOIN movies m\n" +
            "ON m.idMovie = f.idMovie\n" +
            "WHERE f.idFunction = :id \n" +
            "AND t.date = :date", nativeQuery = true)
    List<String> findSeatsByDate(@Param("id") int id, @Param("date") Date date);
}
