package com.robotics.inc.inventory.model;

import com.robotics.inc.inventory.util.DateUtils;
import com.robotics.inc.inventory.web.model.RobotFunction;
import com.robotics.inc.inventory.web.model.RobotState;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.couchbase.core.mapping.Document;

import java.util.Date;
import java.util.List;


@Document
@Data
@Getter
@Setter
public class Robot {

    @Id
    private Long robotId;

    private String name;

    private Date yearBuilt;

    private Double mass;

    private String color;

    private RobotState robotState;

    private List<RobotFunction> robotFunctions;

    @CreatedDate
    private String createdAt = DateUtils.getDateInString(new Date());

    @LastModifiedDate
    private String updatedAt = DateUtils.getDateInString(new Date());
}
