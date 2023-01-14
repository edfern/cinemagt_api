package com.sa.tav.cinema.dto;

public class ResponseError extends ResponseDto {
    public ResponseError(int code, String message) {
        super(code, message);
    }

    public ResponseError(){
        super(500,"Internal error");
    }
}
