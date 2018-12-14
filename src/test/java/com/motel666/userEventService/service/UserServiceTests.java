package com.motel666.userEventService.service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.motel666.userEventService.model.UserEvent;
import com.motel666.userEventService.repository.UserEventRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserServiceTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Mock
    UserEventRepository userEventRepository;

    @InjectMocks
    UserEventService userEventService;

    @Test
    public void test_addUserEventServiceTest() throws Exception {
        UserEvent testEvent = new UserEvent();
        when(userEventService.addUserEvent(testEvent))
                .thenReturn(testEvent);
        when(userEventRepository.save(testEvent))
                .thenReturn(testEvent);
        userEventService.addUserEvent(testEvent);
        verify(userEventRepository, times(1)).save(testEvent);
        verifyNoMoreInteractions(userEventRepository);
    }
}
