package com.sa.tav.cinema.dao;

import com.sa.tav.cinema.model.entity.MoviesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMoviesRepository extends JpaRepository<MoviesEntity, Integer> {

    @Query(value = "SELECT * \n" +
            "FROM movies\n" +
            "WHERE idMovie \n" +
            "IN (\n" +
            "SELECT idMovie \n" +
            "FROM functions \n" +
            "WHERE state = 'N'\n" +
            ")\n" +
            "OR idMovie \n" +
            "NOT IN (select idMovie \n" +
            "FROM functions);", nativeQuery = true)
    List<MoviesEntity> findAvailable();
}
