package org.example.homeowork003.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.example.homeowork003.model.dto.Venue;
import org.example.homeowork003.model.dto.request.VenueRequest;
import org.example.homeowork003.model.dto.respone.ApiResponse;
import org.example.homeowork003.service.VenueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/venues")
@RequiredArgsConstructor
public class VenueController {
    private final VenueService venueService;


    @GetMapping
    public ResponseEntity<ApiResponse<List<Venue>>> getAllVenues(@Positive @NotNull @RequestParam(required = false) Integer size, @Positive @NotNull @RequestParam(required = false)Integer page ){
        return ResponseEntity.status(HttpStatus.OK).body(
                ApiResponse.<List<Venue>>builder()
                        .success(true)
                        .message("Get All Students successfully")
                        .status(HttpStatus.OK)
                        .payload(venueService.getAllVenues(size,page))
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Venue>> addVenue(@Valid @RequestBody VenueRequest venueRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.<Venue>builder()
                        .success(true)
                        .message("Add Venue successfully")
                        .payload(venueService.addVenue(venueRequest))
                        .status(HttpStatus.CREATED)
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }

    @GetMapping("/{venue-id}")
    public ResponseEntity<ApiResponse<Venue>> getVenueById(@Valid @PathVariable("venue-id") Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(
                ApiResponse.<Venue>builder()
                        .success(true)
                        .message("Get Venue successfully")
                        .payload(venueService.getVenueById(id))
                        .status(HttpStatus.OK)
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }


    @PutMapping("/{venue-id}")
    public ResponseEntity<ApiResponse<Venue>> updateVenueById(@Valid @PathVariable("venue-id") Integer id,@Valid @RequestBody VenueRequest venueRequest){
        return ResponseEntity.status(HttpStatus.OK).body(
                ApiResponse.<Venue>builder()
                        .success(true)
                        .message("Update Venue by id successfully")
                        .payload(venueService.updateVenueById(id,venueRequest))
                        .status(HttpStatus.FOUND)
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }

    @DeleteMapping("/{venue-id}")
    public ResponseEntity<ApiResponse<Venue>> deleteVenueById(@Valid @PathVariable("venue-id") Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(
                ApiResponse.<Venue>builder()
                        .success(true)
                        .message("Delete Venue successfully")
                        .payload(venueService.deleteVenueById(id))
                        .status(HttpStatus.OK)
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }

}
