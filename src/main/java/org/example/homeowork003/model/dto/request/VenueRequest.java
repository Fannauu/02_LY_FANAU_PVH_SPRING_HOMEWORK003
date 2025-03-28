package org.example.homeowork003.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenueRequest {
    @NotBlank(message = "Venue name can't be blank")
    private String venueName;
    @NotBlank(message = "Venue location can't be blank")
    @Size(min = 3, max = 10 , message = "Location must be start from 3 characters")
    private String venueAddress;
}
