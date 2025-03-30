package org.example.homeowork003.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.example.homeowork003.exception.NotFoundException;
import org.example.homeowork003.model.dto.Event;
import org.example.homeowork003.model.dto.request.EventRequest;
import org.example.homeowork003.model.dto.respone.ApiResponse;
import org.example.homeowork003.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Event>>> getAllEvents(@Positive @NotNull @RequestParam(required = false) Integer size,@Positive @NotNull @RequestParam(required = false) Integer page){
        return ResponseEntity.status(HttpStatus.OK).body(
                ApiResponse.<List<Event>>builder()
                        .success(true)
                        .message("Get all Events successfully")
                        .payload(eventService.getAllEvents(size, page))
                        .status(HttpStatus.OK)
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Event>> addEvent(@Valid @RequestBody EventRequest eventRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.<Event>builder()
                        .success(true)
                        .message("Add Event successfully")
                        .payload(eventService.addEvent(eventRequest))
                        .status(HttpStatus.CREATED)
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }


    @GetMapping("/{event-id}")
    public ResponseEntity<ApiResponse<Event>> getEventById(@Valid @PathVariable("event-id") Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(
                ApiResponse.<Event>builder()
                        .success(true)
                        .message("Get Event successfully")
                        .payload(eventService.getEventById(id))
                        .status(HttpStatus.OK)
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }

    @PutMapping("/{event-id}")
    public ResponseEntity<ApiResponse<Event>> updateEventId(@Valid @PathVariable("event-id") Integer id, @Valid @RequestBody EventRequest eventRequest){
        return ResponseEntity.status(HttpStatus.OK).body(
                ApiResponse.<Event>builder()
                        .success(true)
                        .message("Update Event successfully")
                        .payload(eventService.updateEventId(id,eventRequest))
                        .status(HttpStatus.OK)
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }

    @DeleteMapping("/{event-id}")
    public ResponseEntity<ApiResponse<Event>> deleteEventById(@Valid @PathVariable("event-id") Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(
                ApiResponse.<Event>builder()
                        .success(true)
                        .message("Delete Event successfully")
                        .payload(eventService.deleteEventById(id))
                        .status(HttpStatus.OK)
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }
}
