package org.example.homeowork003.repository;

import org.apache.ibatis.annotations.*;
import org.example.homeowork003.model.dto.Event;
import org.example.homeowork003.model.dto.request.EventRequest;

import java.util.List;

@Mapper
public interface EventRepository {
    @Select("""
                    SELECT * FROM events
                    offset #{size} * (#{page} -1)
                    limit #{size}
            """)
    @Results(id = "eventMapper", value = {
            @Result(property = "eventId", column = "event_id"),
            @Result(property = "eventName", column = "event_name"),
            @Result(property = "eventDate", column = "event_date"),
            @Result(property = "venueId", column = "venue_id",
                    one = @One(select = "org.example.homeowork003.repository.VenueRepository.getVenueById")
            ),
            @Result(property = "attendees", column = "event_id",
                    many = @Many(select = "org.example.homeowork003.repository.AttendeeRepository.getAttendeesByEventId")
            )
    })
    List<Event> getAllEvents(Integer size, Integer page);


    @Insert("""
        INSERT INTO event_attendee(event_id,attendee_id)
        VALUES (#{eventId},#{attendeeId})
    """)
    void addEventAndAttendeeToMiddleOfTable(Integer eventId, Integer attendeeId);


    @Select("""
        INSERT INTO events(event_name,event_date,venue_id)
        VALUES (#{request.eventName},#{request.eventDate},#{request.venueId})
        RETURNING *
    """)
    @ResultMap("eventMapper")
    Event addEvent(@Param("request") EventRequest eventRequest);


    @Select("""
        SELECT * FROM events WHERE event_id = #{id}
    """)
    @ResultMap("eventMapper")
    Event getEventById(Integer id);



    @Select("""
        UPDATE events set event_name = #{request.eventName},event_date = #{request.eventDate},venue_id = #{request.venueId}
        WHERE event_id = #{id}
    """)
    void updateEventId(Integer id,@Param("request") EventRequest eventRequest);

    @Select("""
        DELETE FROM event_attendee WHERE event_id = #{id}
    """)
    Event deleteEventById(Integer id);
}

