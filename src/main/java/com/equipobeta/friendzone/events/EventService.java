package com.equipobeta.friendzone.events;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j

public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAllEvents() {

        return eventRepository.findAll();
    }

    public Optional findById (Long id) {
        return eventRepository.findById(id);
    }

    public Event createEvent (Event event){

        return eventRepository.save(event);

    }
    public Event update (Event event){

        return eventRepository.save(event);

    }
    public void deleteById(Long id) {
        eventRepository.deleteById(id);
    }



}


