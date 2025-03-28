package org.example.homeowork003.service;

import org.example.homeowork003.model.dto.Event;

import java.util.List;

public interface EventService {
    List<Event> getAllEvents(Integer size,Integer page);
}
