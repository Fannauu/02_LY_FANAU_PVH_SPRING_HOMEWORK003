package org.example.homeowork003.repository;

import org.apache.ibatis.annotations.*;
import org.example.homeowork003.model.dto.Venue;
import org.example.homeowork003.model.dto.request.VenueRequest;

import java.util.List;

@Mapper
public interface VenueRepository {
    @Select("""
        select * from venues
        offset #{size} * (#{page} -1)
        limit #{size}
    """)
    @Results(id = "venueMapper" , value = {
            @Result(property = "venueId",column = "venue_id"),
            @Result(property = "venueName",column = "venue_name"),
            @Result(property = "venueAddress",column = "location")
    })
    List<Venue> getAllVenues(Integer size , Integer page);


    @Select("""
        INSERT INTO venues (venue_name,location)
        VALUES(#{request.venueName},#{request.venueAddress})
        RETURNING *
    """)
    @ResultMap("venueMapper")
    Venue addVenue(@Param("request") VenueRequest venueRequest);



    @Select("""
        SELECT * FROM venues WHERE venue_id = #{id};
    """)
    @ResultMap("venueMapper")
    Venue getVenueById(Integer id);


    @Select("""
        UPDATE venues set venue_name = #{request.venueName},location = #{request.venueAddress}
        WHERE venue_id = #{id}
        RETURNING *
    """)
    @ResultMap("venueMapper")
    Venue updateVenueById(Integer id,@Param("request") VenueRequest venueRequest);


    @Select("""
        DELETE FROM venues WHERE venue_id = #{id}
        RETURNING *
    """)
    @ResultMap("venueMapper")
    Venue deleteVenueById(Integer id);



//    @Select("""
//        SELECT e.event_id, e.event_name, e.event_date FROM events e
//        INNER JOIN event_attendee ea ON e.event_id = ea.event_id
//        WHERE e.venue_id = #{id}
//    """)
//    @ResultMap("venueMapper")
//    public void getEventByVenueId(Integer id);
}
