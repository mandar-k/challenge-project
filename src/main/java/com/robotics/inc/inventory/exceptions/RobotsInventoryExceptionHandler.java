package com.robotics.inc.inventory.exceptions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.robotics.inc.inventory.web.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@Slf4j
public class RobotsInventoryExceptionHandler {

    private static final ObjectMapper objectMapper = new ObjectMapper();


    @ExceptionHandler({NoRobotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleNoRobotFound(final NoRobotFoundException ex) {
        log.error("NoRobotFoundException: ", ex);
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorMessage(ex.getMessage());
        errorResponse.setHttpStatusCode(HttpStatus.NOT_FOUND);
        return errorResponse;
    }

}
