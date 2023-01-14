package com.sa.tav.cinema.util;

import com.sa.tav.cinema.exception.CinemaException;

public interface IUpdateService<T> {
    T update(T entity) throws CinemaException;
}
