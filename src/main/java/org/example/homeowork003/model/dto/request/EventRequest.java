package org.example.homeowork003.model.dto.request;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventRequest {
    @NotBlank(message = "Event name can't be blank")
    @Size(min = 3, max = 50, message = "event name should be greater than 3 characters")
    private String eventName;

    @NotNull(message = "Event Data is required")
    @Future(message = "Event date must be in the future")
    private LocalDateTime eventDate;

    @NotNull(message = "Venue ID is required")
    @Min(value = 1, message = "Venue ID show be greater than 0")
    private Integer venueId;

    @NotEmpty(message = "At least one attendee ID is required")
    private List<Integer> attendeeId;
}
