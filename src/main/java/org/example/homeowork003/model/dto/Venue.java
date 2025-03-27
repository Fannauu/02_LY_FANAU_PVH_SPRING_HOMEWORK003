package org.example.homeowork003.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Venue {
    private int venueId;
    private String venueName;
    private String venueAddress;
}
