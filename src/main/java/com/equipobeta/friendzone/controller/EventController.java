package com.equipobeta.friendzone.controller;

import com.equipobeta.friendzone.models.service.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class EventController {

@DeleteMapping(value = "event/{id}")
    public String deleteEvent(@PathVariable Long id) {

        EventService.delete(eventId);

//    buscar para poner una alerta //

        if (EventService) {
            return "Se ha borrado el evento";
        }
    return null;
}
}

