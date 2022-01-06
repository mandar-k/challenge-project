package com.robotics.inc.inventory.repository;


import com.robotics.inc.inventory.model.Robot;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RobotRepository extends CouchbaseRepository<Robot, String> {
    Optional<Robot> findByRobotId(String robotId);
}

