package com.robotics.inc.inventory.web.model;

public enum RobotFunction {

    LIGHT_SENSING("light sensing"),
    SOUND_SENSING("sound sensing"),
    TEMPERATURE_SENSING("temperature sensing"),
    PRESSURE_SENSING("pressure sensing"),
    MOBILITY("mobility"),
    DEGREE_OF_FREEDOM("degrees-of-freedom");

    private String function;

    RobotFunction(String function) {
        this.function = function;
    }

    public void setFunction(String function) {
        this.function = function;
    }
}
