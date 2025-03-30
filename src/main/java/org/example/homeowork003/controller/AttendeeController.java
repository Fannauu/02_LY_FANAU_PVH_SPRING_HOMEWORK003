package org.example.homeowork003.controller;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.example.homeowork003.model.dto.Attendee;
import org.example.homeowork003.model.dto.request.AttendeeRequest;
import org.example.homeowork003.model.dto.respone.ApiResponse;
import org.example.homeowork003.service.AttendeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/attendees")
@RequiredArgsConstructor
public class AttendeeController {
    private final AttendeeService attendeeService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Attendee>>> getAllAttendees(@Positive @NotNull @RequestParam(required = false)Integer size, @Positive @NotNull @RequestParam(required = false)Integer page) {
        return ResponseEntity.status(HttpStatus.OK).body(
                ApiResponse.<List<Attendee>>builder()
                        .success(true)
                        .message("Get all attendees successfully")
                        .payload(attendeeService.getAllAttendees(size,page))
                        .status(HttpStatus.OK)
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Attendee>> addAttendee(@Valid @RequestBody AttendeeRequest attendeeRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.<Attendee>builder()
                        .success(true)
                        .message("Add attendee successfully")
                        .payload(attendeeService.addAttendee(attendeeRequest))
                        .status(HttpStatus.CREATED)
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }

    @PutMapping("/{attendee-id}")
    public ResponseEntity<ApiResponse<Attendee>> updateAttendeeById(@Valid @PathVariable("attendee-id")Integer id, @Valid @RequestBody AttendeeRequest attendeeRequest){
        return ResponseEntity.status(HttpStatus.OK).body(
                ApiResponse.<Attendee>builder()
                        .success(true)
                        .message("Update attendee successfully")
                        .payload(attendeeService.updateAttendeeById(id,attendeeRequest))
                        .status(HttpStatus.OK)
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }

    @GetMapping("/{attendee-id}")
    public ResponseEntity<ApiResponse<Attendee>> getAttendeeById(@Valid @PathVariable("attendee-id")Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(
                ApiResponse.<Attendee>builder()
                        .success(true)
                        .message("Get attendee successfully")
                        .payload(attendeeService.getAttendeeById(id))
                        .status(HttpStatus.FOUND)
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }


    @DeleteMapping("/{attendee-id}")
    public ResponseEntity<ApiResponse<Attendee>> deleteAttendeeById(@Valid @PathVariable("attendee-id")Integer id){

        ApiResponse response = ApiResponse.<Attendee>builder()
                .success(true)
                .message("Delete attendee successfully")
                .payload(attendeeService.deleteAttendeeById(id))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
