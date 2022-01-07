package com.robotics.inc.inventory.controller;

import com.robotics.inc.BaseUnitService;
import com.robotics.inc.inventory.service.RobotInventoryService;
import com.robotics.inc.inventory.web.model.RobotVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class RobotInventoryControllerTest extends BaseUnitService {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private RobotInventoryController robotInventoryController;

    @Mock
    private RobotInventoryService robotInventoryService;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(robotInventoryController).build();
    }

    @Test
    void getAllRobots() throws Exception {
        when(robotInventoryService.getAllRobots()).thenReturn(List.of(loadRobotVO()));

        mockMvc.perform(get("/robots/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
        verify(robotInventoryService, times(1));
    }

    @Test
    void getAllRobotsCountByState() throws Exception {
        when(robotInventoryService.getRobotStateCountVO()).thenReturn(loadRobotStateCountVO());

        mockMvc.perform(get("/robots/allRobotCount"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));

        verify(robotInventoryService, times(1));
    }
}