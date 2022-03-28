package com.robotics.inc.inventory.exceptions;

import lombok.Data;

@Data
public class BadRequestFormat extends RuntimeException {

    private String message;

    public BadRequestFormat(String e) {
        super(e);
        setMessage(e);
    }
}