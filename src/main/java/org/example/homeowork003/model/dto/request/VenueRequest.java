package org.example.homeowork003.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenueRequest {
    private String venueName;
    private String venueAddress;
}
