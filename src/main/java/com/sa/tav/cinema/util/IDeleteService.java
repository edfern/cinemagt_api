package com.sa.tav.cinema.util;

import com.sa.tav.cinema.exception.CinemaException;

public interface IDeleteService<T>{
    boolean deleteById(int id) throws CinemaException;
}
