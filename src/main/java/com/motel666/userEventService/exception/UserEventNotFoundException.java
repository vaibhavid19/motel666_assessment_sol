package com.motel666.userEventService.exception;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "User Event Not Found")
public class UserEventNotFoundException extends RuntimeException {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserEventNotFoundException.class);

    public UserEventNotFoundException() {
    }

    public UserEventNotFoundException(String exception) {
        LOGGER.warn("Cannot find events for this user: {}", exception);
    }
}
