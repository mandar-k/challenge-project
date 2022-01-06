package com.robotics.inc.inventory.web.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RobotVO {

    private Long robotId;

    private String name;


    private Date yearBuilt;

    private Double mass;

    private String color;

    private RobotState robotState;

    private List<RobotFunction> robotFunctions;
}