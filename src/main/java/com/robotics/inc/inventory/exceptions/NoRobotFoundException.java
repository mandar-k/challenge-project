package com.robotics.inc.inventory.exceptions;

import lombok.Data;

@Data
public class NoRobotFoundException extends RuntimeException {

    private String message;

    public NoRobotFoundException(String e) {
        super(e);
        setMessage(e);
    }
}
