package com.equipobeta.friendzone.events;

import com.equipobeta.friendzone.users.User;
import com.equipobeta.friendzone.users.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class EventController {



    private final UserService userService;
    private final EventService eventService;



    public EventController(UserService userService, EventService eventService) {
        this.userService = userService;
        this.eventService = eventService;
    }

     //listar todos los eventos
     
    @GetMapping("/api/allevents")
    public List<Event> findAll(){
        return eventService.getAllEvents();
    }


    //borrar un evento por id

    @DeleteMapping("/api/delete/{id}")
    public Long delete(@PathVariable("id") Long id) {
        Optional event = eventService.findById(id);
        eventService.deleteById(id);
        return id;
    }


    @PostMapping("/api/createevent")
    public Event addEvent(@RequestBody Event event) {
        User authUser = userService.findById(1L);

        event.setOwner(authUser);

        return eventService.createEvent(event);
    }

    @GetMapping("/api/oneevent/{id}")
    public Optional findEventById(@PathVariable Long id) {
        return eventService.findById(id);
    }

    @PutMapping("/api/update/")
    public String update(@RequestBody Event e){

//        service.getProductById(p.getId());
        eventService.update(e);


        return "redirect:/api/allevents";
    }

}


