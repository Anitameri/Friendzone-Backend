package com.equipobeta.friendzone.events;

import com.equipobeta.friendzone.users.User;
import com.equipobeta.friendzone.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class EventController {

    private final UserService userService;
    private final EventService eventService;

    @Autowired
    EventService service;

    @Autowired
    UserService uservice;

    public EventController(UserService userService, EventService eventService) {
        this.userService = userService;
        this.eventService = eventService;
    }

    @GetMapping("/api/allevents")
    public List<Event> getall(){
        return service.getAllEvents();
    }

//    !!!!!!FORMA MIGUEL!!!!!!!!
//
//    @PostMapping("/api/createevent")
//    public Event addEvent(@RequestBody Event event) {
//        User authUser = userService.findById(1L);
//
//        event.setUser(authUser);
//
//        return eventService.createEvent(event);
//    }

//    !!!!!!!!!FORMA JESUS

    @PostMapping("/api/createevent")
    public Event event(@RequestBody EventDto p)
    {
        Event pp = new Event();
        pp.setName(p.getName());
        pp.setDescription(p.getDescription());
        pp.setBudget(p.getBudget());
        pp.setImage(p.getImage());
        pp.setEvent_date(p.getEvent_date());
        pp.setOwner(uservice.getUserById(p.getUser_id()).orElse(null));
        return service.create(pp);
    }




    @PutMapping("/api/update/")
    public String update(@RequestBody Event e){

//        service.getProductById(p.getId());
        service.update(e);

        return "redirect:/api/allevents";
    }

}
