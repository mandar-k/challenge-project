package com.robotics.inc.inventory.web.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class HealthStatus {
    private String status;
    private String currentTime;


    public HealthStatus(String status) {
        this.status = status;
    }


}
