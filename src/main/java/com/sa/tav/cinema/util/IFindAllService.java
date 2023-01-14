package com.sa.tav.cinema.util;

import com.sa.tav.cinema.exception.CinemaException;
import com.sa.tav.cinema.model.entity.AbstractEntity;

import java.util.List;

public interface IFindAllService<T> {
    List<T> findAll() throws CinemaException;
}
