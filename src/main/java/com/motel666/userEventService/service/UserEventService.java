package com.motel666.userEventService.service;

import com.motel666.userEventService.exception.UserEventNotFoundException;
import com.motel666.userEventService.model.UserEvent;
import com.motel666.userEventService.repository.UserEventRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserEventService {

    @Autowired
    UserEventRepository userEventRepository;

    public UserEvent addUserEvent(UserEvent userEvent) {
        return userEventRepository.save(userEvent);
    }

    public Iterable<UserEvent> getEventWithinTimeframe(Date fromDate, Date toDate) {
        //return userEventRepository.save(userEvent);
        return null;
    }

    public UserEvent getEventsByUserId(Long userId){

        Optional<UserEvent> userEventOptional = userEventRepository.findById(userId);
        if (!userEventOptional.isPresent()) {
            throw new UserEventNotFoundException();
        }
        return userEventOptional.get();
    }

    public List<UserEvent> getEventsByUserName(String userName){
        List<UserEvent> userEvents = userEventRepository.findByUserName(userName);
        if (userEvents==null) {
            throw new UserEventNotFoundException();
        }
        return userEvents;
    }
}
