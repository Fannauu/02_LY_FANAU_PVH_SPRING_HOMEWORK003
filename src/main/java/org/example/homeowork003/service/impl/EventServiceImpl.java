package org.example.homeowork003.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.homeowork003.model.dto.Event;
import org.example.homeowork003.repository.EventRepository;
import org.example.homeowork003.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;

    @Override
    public List<Event> getAllEvents(Integer size, Integer page) {
        return eventRepository.getAllEvents(size,page);
    }
}
