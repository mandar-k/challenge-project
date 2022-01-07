package com.robotics.inc.inventory.service;

import com.robotics.inc.inventory.exceptions.NoRobotFoundException;
import com.robotics.inc.inventory.model.Robot;
import com.robotics.inc.inventory.repository.RobotRepository;
import com.robotics.inc.inventory.web.model.RobotState;
import com.robotics.inc.inventory.web.model.RobotStateCountVO;
import com.robotics.inc.inventory.web.model.RobotVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
@Slf4j
public class RobotInventoryService {

    @Autowired
    private RobotRepository robotRepository;

    public List<RobotVO> getAllRobots() {
        log.debug("Request received for all robots in robot inventory");
        List<Robot> robots = robotRepository.findAll();
        if (robots != null && !robots.isEmpty()) {
            return robots.stream().map(robot -> {
                RobotVO robotVo = new RobotVO();
                BeanUtils.copyProperties(robot, robotVo);
                return robotVo;
            }).collect(Collectors.toList());
        }
        return null;
    }

    public boolean addNewRobot(RobotVO robotVO) {
        log.debug("Request received to add new robot with robotId: {}", robotVO.getRobotId());
        Robot robot = new Robot();
        copyProperties(robotVO, robot);
        robotRepository.save(robot);
        return true;
    }

    public RobotVO getRobotStateById(String robotId) {
        log.debug("Request received to get robot by id: {}", robotId);
        Optional<Robot> robot = robotRepository.findByRobotId(robotId);
        return robot.map(value -> {
            RobotVO vo = new RobotVO();
            BeanUtils.copyProperties(value, vo);
            return vo;
        }).orElseThrow(() -> new NoRobotFoundException("Can not find the robot with given Id: " + robotId));
    }

    public RobotStateCountVO getRobotStateCountVO() {
        log.debug("Request received to give robots count by state");
        RobotStateCountVO robotStateCountVO = new RobotStateCountVO();
        Map<RobotState, Long> robotMap = robotRepository.findAll().stream()
                .collect(Collectors.groupingBy(Robot::getRobotState, Collectors.counting()));
        robotStateCountVO.setRobotStateCountMap(robotMap);
        return robotStateCountVO;
    }

    public boolean updateRobot(String robotId, RobotVO robotVO) {
        log.debug("Request received to update robot with robotId: {}", robotVO.getRobotId());
        Optional<Robot> optionalRobot = robotRepository.findByRobotId(robotId);
        if (optionalRobot.isPresent()) {
            Robot robot = optionalRobot.get();
            BeanUtils.copyProperties(robotVO, robot);
            robotRepository.save(robot);
            return true;
        }
        throw new NoRobotFoundException("Can not find the Robot to update with given Id: " + robotId);
    }

    public void deleteRobot(String robotId) {
        log.debug("Deleting robot with Id: {}", robotId);
        robotRepository.deleteById(robotId);
    }
}
