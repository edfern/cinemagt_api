package com.sa.tav.cinema.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseSuccess extends ResponseDto {

    @JsonProperty
    private Object response;

    public ResponseSuccess() {
        super(200, "Success delete");
    }
    public ResponseSuccess(Object response) {
        super(200, "Success");
        this.response = response;
    }
}
