package org.example.homeowork003.service;

import jakarta.validation.Valid;
import org.example.homeowork003.model.dto.Event;
import org.example.homeowork003.model.dto.request.EventRequest;

import java.util.List;

public interface EventService {
    List<Event> getAllEvents(Integer size, Integer page);

    Event addEvent(EventRequest eventRequest);

    Event getEventById(Integer id);

    Event updateEventId(Integer id, EventRequest eventRequest);

    Event deleteEventById(Integer id);
}
