package com.motel666.userEventService.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.motel666.userEventService.model.UserEvent;
import com.motel666.userEventService.service.UserEventService;
import com.vaibhavi.thanksgivingproject.entity.Item;
import com.vaibhavi.thanksgivingproject.repository.ItemRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

    @MockBean
    UserEventService userEventService;

    @Before
    public void setUp(){}

    @Test
    public void createCharacterTest() throws Exception {
        UserEvent testEvent = new UserEvent("testuser");
        when(userEventService.addUserEvent(testEvent)).thenReturn(testEvent);

        String json = mapper.writeValueAsString(testEvent);
        mockMvc.perform(MockMvcRequestBuilders
                .post("/user/events/add")
                .contentType(MediaType.APPLICATION_JSON)
                 .content(json))
                .andExpect(status().isOk());
        verify(userEventService,times(1)).addUserEvent(isA(UserEvent.class);
        verifyNoMoreInteractions(userEventService);
    }

}
