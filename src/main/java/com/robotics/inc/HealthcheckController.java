package com.codility.tasks.spring.healthcheck;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import java.time.ZonedDateTime;

@RestController
class HealthcheckController {

    @GetMapping(value = "/healthcheck")
    public void healthcheck() {
        return;
    }

    @PutMapping(value = "/healthcheck")
    public void healthcheckPut() {
        return;
    }

    @PostMapping(value = "/healthcheck")
    public void healthcheckPost() {
        return;
    }


    @DeleteMapping(value = "/healthcheck")
    public void healthcheckDelete() {
        return;
    }

}


/**



**/
