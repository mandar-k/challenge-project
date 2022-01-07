package com.robotics.inc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.robotics.inc.inventory.web.model.RobotStateCountVO;
import com.robotics.inc.inventory.web.model.RobotVO;

import java.io.File;
import java.io.IOException;

public abstract class BaseUnitService {

    private final static String FILE_PATH_ROBOT_VO = "mock/robot-vo.json";
    private final static String FILE_PATH_ROBOT_STATE_VO = "mock/robot-state-count.json";

    private ClassLoader classLoader = this.getClass().getClassLoader();
    private ObjectMapper mapper = new ObjectMapper();

    protected RobotVO loadRobotVO() throws IOException {
        File file = new File(classLoader.getResource(FILE_PATH_ROBOT_VO).getFile());
        return mapper.readValue(file, RobotVO.class);
    }

    protected String loadRobotVOString() throws IOException {
        File file = new File(classLoader.getResource(FILE_PATH_ROBOT_VO).getFile());
        return mapper.writeValueAsString(this.loadRobotVO());
    }

    protected RobotStateCountVO loadRobotStateCountVO() throws IOException {
        File file = new File(classLoader.getResource(FILE_PATH_ROBOT_STATE_VO).getFile());
        return mapper.readValue(file, RobotStateCountVO.class);

    }


}