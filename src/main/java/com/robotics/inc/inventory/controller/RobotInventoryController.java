package com.robotics.inc.inventory.controller;

import com.robotics.inc.inventory.service.RobotInventoryService;
import com.robotics.inc.inventory.web.model.RobotStateCountVO;
import com.robotics.inc.inventory.web.model.RobotVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = {"/robots"})
public class RobotInventoryController {

    @Autowired
    private RobotInventoryService robotInventoryService;

    @GetMapping("/all")
    public List<RobotVO> getAllRobots() {
        log.debug("Received request to get all robots");
        return robotInventoryService.getAllRobots();
    }

    @GetMapping(value = "/getRobotState")
    public RobotVO getRobotState(@RequestParam String robotId) {
        log.debug("Received request to add new robot to inventory");
        return robotInventoryService.getRobotStateById(robotId);
    }

    @GetMapping(value = "/allRobotCount")
    public RobotStateCountVO getAllRobotsCountByState() {
        log.debug("Received request to get all robot count by state");
        return robotInventoryService.getRobotStateCountVO();
    }

    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean addRobotToInventory(@RequestBody RobotVO robotVO) {
        log.debug("Received request to add new robot to inventory");
        return robotInventoryService.addNewRobot(robotVO);
    }

    @PatchMapping(value = "/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public boolean updateRobotToInventory(@RequestParam String robotId,
                                          @RequestBody RobotVO robotVO) {
        log.debug("Received request to update robot into inventory");
        return robotInventoryService.updateRobot(robotId, robotVO);
    }

    @DeleteMapping(value = "/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRobotFromInventory(@RequestParam String robotId) {
        log.debug("Received request to delete robot with Id: {}", robotId);
        robotInventoryService.deleteRobot(robotId);
    }

}
