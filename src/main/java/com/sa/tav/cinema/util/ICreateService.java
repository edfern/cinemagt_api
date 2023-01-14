package com.sa.tav.cinema.util;

import com.sa.tav.cinema.exception.CinemaException;

public interface ICreateService<T> {
    T create(T entity) throws CinemaException;
}
