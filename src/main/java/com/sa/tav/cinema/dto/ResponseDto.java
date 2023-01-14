package com.sa.tav.cinema.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class ResponseDto {

    @JsonProperty
    private int code;
    @JsonProperty
    private String message;

    public ResponseDto(int code, String message){
        this.code = code;
        this.message = message;
    }

}
