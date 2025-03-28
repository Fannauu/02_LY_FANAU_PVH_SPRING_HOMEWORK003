package org.example.homeowork003.repository;


import org.apache.ibatis.annotations.*;
import org.example.homeowork003.model.dto.Attendee;
import org.example.homeowork003.model.dto.request.AttendeeRequest;

import java.util.List;

@Mapper
public interface AttendeeRepository {


    @Select("""
        SELECT * FROM attendees
    """)
    @Results(id="attendeeMapper", value = {
            @Result(property = "attendeeId",column = "attendee_id"),
            @Result(property = "attendeeName",column = "attendee_name"),
    })
    List<Attendee> getAllAttendees(Integer size, Integer page);



    @Select("""
        INSERT INTO attendees (attendee_name, email)
        VALUES (#{request.attendeeName},#{request.email})
        RETURNING *
    """)
    @ResultMap("attendeeMapper")
    Attendee addAttendee(@Param("request") AttendeeRequest attendeeRequest);



    @Select("""
        UPDATE attendees set attendee_name = #{request.attendeeName}, email = #{request.email}
        WHERE attendee_id = #{id}
        RETURNING *
    """)
    @ResultMap("attendeeMapper")
    Attendee updateAttendeeById(Integer id, @Param("request") AttendeeRequest attendeeRequest);



    @Select("""
        SELECT * FROM attendees WHERE  attendee_id = #{id}
    """)
    @ResultMap("attendeeMapper")
    Attendee getAttendeeById(Integer id);



    @Select(""" 
        DELETE from attendees WHERE attendee_id = #{id}
        RETURNING *
    """)
    @ResultMap("attendeeMapper")
    Attendee deleteAttendeeById(Integer id);
}
