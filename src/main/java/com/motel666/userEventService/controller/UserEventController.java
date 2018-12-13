package com.motel666.userEventService.controller;

import com.motel666.userEventService.model.UserEvent;
import com.motel666.userEventService.service.UserEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("user")
public class UserEventController {

    @Autowired
    UserEventService userEventService;

    //    As an end-user (i.e., using the web reservation app), my user actions are reported in the background.
    @PostMapping("/events/add")//
    public UserEvent addUserEvent(@RequestBody UserEvent userEvent) {
        return userEventService.addUserEvent(userEvent);
    }

    //    As a reporting user, I can request a list of user events (for all users) that took place within a given timeframe.
    @GetMapping("/events/get/timeframe/{fromDate}/{toDate}")//
    public Iterable<UserEvent> getEventWithinTimeframe(@PathVariable Date fromDate, @PathVariable Date toDate) {
        return userEventService.getEventWithinTimeframe(fromDate, toDate);
    }

    //    As a reporting user, I can request a list of all user events for a single user, specified by their user id.
    @GetMapping("/events/get/user/{userId}")//
    public Iterable<UserEvent> getEventsByUserId(@PathVariable Long userId) {
        return userEventService.getEventsByUserId(userId);
    }
}
