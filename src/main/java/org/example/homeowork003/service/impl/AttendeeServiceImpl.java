package org.example.homeowork003.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.homeowork003.exception.NotFoundException;
import org.example.homeowork003.model.dto.Attendee;
import org.example.homeowork003.model.dto.request.AttendeeRequest;
import org.example.homeowork003.repository.AttendeeRepository;
import org.example.homeowork003.service.AttendeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendeeServiceImpl implements AttendeeService {
    private final AttendeeRepository attendeeRepository;

    @Override
    public List<Attendee> getAllAttendees(Integer size, Integer page) {
        return attendeeRepository.getAllAttendees(size, page);
    }

    @Override
    public Attendee addAttendee(AttendeeRequest attendeeRequest) {
        return attendeeRepository.addAttendee(attendeeRequest);
    }

    @Override
    public Attendee getAttendeeById(Integer id) {
        Attendee attendee = attendeeRepository.getAttendeeById(id);
        if (attendee == null) {
            throw new NotFoundException("Attendee id " + id + " not found");
        }
        return attendee;
    }

    @Override
    public Attendee updateAttendeeById(Integer id, AttendeeRequest attendeeRequest) {
        Attendee attendee = attendeeRepository.updateAttendeeById(id, attendeeRequest);
        if (attendee == null) {
            throw new NotFoundException("Attendee id " + id + " not found");
        }
        return attendee;
    }

    @Override
    public Attendee deleteAttendeeById(Integer id) {
        Attendee attendee = attendeeRepository.deleteAttendeeById(id);
        if (attendee == null) {
            throw new NotFoundException("Attendee id" + id + " not found");
        }
        return attendee;
    }
}
