package org.example.homeowork003.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.homeowork003.exception.NotFoundException;
import org.example.homeowork003.model.dto.Event;
import org.example.homeowork003.model.dto.request.EventRequest;
import org.example.homeowork003.repository.AttendeeRepository;
import org.example.homeowork003.repository.EventRepository;
import org.example.homeowork003.repository.VenueRepository;
import org.example.homeowork003.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final VenueRepository venueRepository;
    private final AttendeeRepository attendeeRepository;

    @Override
    public List<Event> getAllEvents(Integer size, Integer page) {
        return eventRepository.getAllEvents(size, page);
    }

    @Override
    public Event addEvent(EventRequest eventRequest) {
        Integer venueId = eventRequest.getVenueId();
        if(venueId == null || venueRepository.getVenueById(venueId) == null) {
            throw new NotFoundException("Venue id " + venueId + " not found");
        }

        List<Integer> attendeeIds = eventRequest.getAttendeeId();
        for (Integer attendeeId : attendeeIds) {
            if (attendeeId == null || attendeeRepository.getAttendeeById(attendeeId) == null) {
                throw new NotFoundException("Attendee id " + attendeeId + " not found");
            }
        }

        Event event = eventRepository.addEvent(eventRequest);

        for (Integer attendeeId : attendeeIds) {
            eventRepository.addEventAndAttendeeToMiddleOfTable(event.getEventId(), attendeeId);
        }

        return getEventById(event.getEventId());
    }

    @Override
    public Event getEventById(Integer id) {
        Event event = eventRepository.getEventById(id);
        if (event == null) {
            throw new NotFoundException("Event " + id + " not found");
        }
        return event;
    }

    @Override
    public Event updateEventId(Integer id, EventRequest eventRequest) {
        Event event = eventRepository.getEventById(id);
        if (event == null) {
            throw new NotFoundException("Event id " + id + " not found");
        }

        if (eventRequest.getVenueId() == null || venueRepository.getVenueById(eventRequest.getVenueId()) == null) {
            throw new NotFoundException("Venue ID " + eventRequest.getVenueId() + " not found");
        }


        List<Integer> attendeeIds = eventRequest.getAttendeeId();
        for (Integer attendeeId : attendeeIds) {
            if (attendeeId == null || attendeeRepository.getAttendeeById(attendeeId) == null) {
                throw new NotFoundException("Attendee " + attendeeId + " not found");
            }
        }

        eventRepository.deleteEventById(id);
        eventRepository.updateEventId(id, eventRequest);

        for (Integer attendeeId : attendeeIds) {
            eventRepository.addEventAndAttendeeToMiddleOfTable(id, attendeeId);
        }
        return getEventById(event.getEventId());
    }

    @Override
    public Event deleteEventById(Integer id) {
        Event event = eventRepository.deleteEventById(id);
        if (event == null) {
            throw new NotFoundException("Event " + id + " not found");
        }
        return event;
    }
}
