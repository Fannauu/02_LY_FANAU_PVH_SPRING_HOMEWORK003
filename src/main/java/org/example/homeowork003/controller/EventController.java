package org.example.homeowork003.controller;

import lombok.RequiredArgsConstructor;
import org.example.homeowork003.model.dto.Event;
import org.example.homeowork003.model.dto.respone.ApiResponse;
import org.example.homeowork003.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping()
    public ResponseEntity<ApiResponse<List<Event>>> getAllEvents(@RequestParam(required = false) Integer size, @RequestParam(required = false) Integer page){
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
}
