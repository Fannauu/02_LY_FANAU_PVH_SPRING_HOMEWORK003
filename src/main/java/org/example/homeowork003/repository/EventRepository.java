package org.example.homeowork003.repository;

import org.apache.ibatis.annotations.*;
import org.example.homeowork003.model.dto.Event;

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
            @Result(property = "venue", column = "venue_id",
                    one = @One(select = "org.example.homeowork003.repository.VenueRepository.getVenueById")
            )
    })
    List<Event> getAllEvents(Integer size, Integer page);
}
