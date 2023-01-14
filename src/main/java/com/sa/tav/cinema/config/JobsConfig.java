package com.sa.tav.cinema.config;

import com.sa.tav.cinema.service.FunctionsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.ParseException;

@Component
public class JobsConfig {
    private static final Logger LOGGER =LoggerFactory.getLogger(JobsConfig.class);

    @Autowired
    FunctionsService service;

    @Scheduled(fixedDelayString = "${task.time-delay}", initialDelayString = "${task.time-initial}")
    public void jobDates() throws ParseException {
        LOGGER.warn(String.format("@%s::jobDates()", this.getClass().getName()));
        this.service.verifyDatesOfFunctionsAvailable();
    }
}
