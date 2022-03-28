package com.robotics.inc;

import com.robotics.inc.inventory.exceptions.BadRequestFormat;
import com.robotics.inc.inventory.web.model.HealthStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
class HealthcheckController {

    public static String getDateInString(final Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        return dateFormat.format(date);
    }

    @GetMapping(value = "/healthcheck")
    public HealthStatus healthcheck(@RequestParam(value = "format", required = false) String format) {
        if (format.equalsIgnoreCase("short")) {
            return new HealthStatus("OK");
        } else if (format.equalsIgnoreCase("full")) {
            HealthStatus healthStatus = new HealthStatus();
            healthStatus.setStatus("OK");
            healthStatus.setCurrentTime(getDateInString(new Date()));
            return healthStatus;
        }
        throw new BadRequestFormat("bad request");
    }

}
