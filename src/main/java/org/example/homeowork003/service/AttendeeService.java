package org.example.homeowork003.service;

import org.example.homeowork003.model.dto.Attendee;
import org.example.homeowork003.model.dto.request.AttendeeRequest;

import java.util.List;

public interface AttendeeService {
    List<Attendee> getAllAttendees(Integer size, Integer page);

    Attendee addAttendee(AttendeeRequest attendeeRequest);

    Attendee updateAttendeeById(Integer id, AttendeeRequest attendeeRequest);

    Attendee getAttendeeById(Integer id);

    Attendee deleteAttendeeById(Integer id);
}
