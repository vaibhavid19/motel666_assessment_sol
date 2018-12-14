package com.motel666.userEventService.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.motel666.userEventService.model.UserEvent;
import com.motel666.userEventService.service.UserEventService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.*;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class UserControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Mock
    UserEventService userEventService;

    @Before
    public void setUp(){}

    @Test
    public void test_addUserEvent() throws Exception {
        UserEvent testEvent = new UserEvent("TESTUSER");
        testEvent.setUserId(10L);
        when(userEventService.addUserEvent(testEvent)).thenReturn(testEvent);

        String json = mapper.writeValueAsString(testEvent);
        mockMvc.perform(MockMvcRequestBuilders
                .post("/user/events/add")
                .contentType(MediaType.APPLICATION_JSON)
                 .content(json))
                .andExpect(status().isOk());
        verify(userEventService,times(1)).addUserEvent(isA(UserEvent.class));
        verifyNoMoreInteractions(userEventService);
    }

    @Test
    public void test_getEventWithinTimeframe() throws Exception {
        UserEvent testEvent = new UserEvent("TESTUSER");
        testEvent.setUserId(10L);
        List<UserEvent> events = new ArrayList<>();
        events.add(testEvent);
        Date testDate = new Date();

        when(userEventService.getEventWithinTimeframe(testDate, testDate)).thenReturn(events);

        String json = mapper.writeValueAsString(testEvent);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/user/events/get/timeframe/", testDate, testDate)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk());
        verify(userEventService,times(1)).getEventWithinTimeframe(isA(Date.class), isA(Date.class));
        verifyNoMoreInteractions(userEventService);
    }

    @Test
    public void test_getEventsByUserId() throws Exception {
        UserEvent testEvent = new UserEvent("TESTUSER");
        testEvent.setUserId(10L);
        List<UserEvent> events = new ArrayList<>();
        events.add(testEvent);
        when(userEventService.getEventsByUserName("TESTUSER")).thenReturn(events);
        Date testDate = new Date();

        String json = mapper.writeValueAsString(testEvent);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/user/events/get/user/TESTUSER")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk());
        verify(userEventService,times(1)).getEventsByUserName("TESTUSER");
        verifyNoMoreInteractions(userEventService);
    }

    

}
