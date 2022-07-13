package com.equipobeta.friendzone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class EventController {

@DeleteMapping(value = "/posts/{id}")
    public String deleteEvent(@PathVariable Long id) {

        EventService.delete(user_event);

        if (EventService) {
            return "";
        }
    return null;
}
}

