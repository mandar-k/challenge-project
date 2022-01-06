package com.robotics.inc.inventory.web.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum RobotState {

    TESTED("Tested"),
    DESIGNED("Designed"),
    READY("Ready to Ship"),
    DEPLOYED("Deployed"),
    DAMAGED("Damaged");

    private String state;

    RobotState(String robotState) {
        setState(robotState);
    }

    @JsonValue
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}