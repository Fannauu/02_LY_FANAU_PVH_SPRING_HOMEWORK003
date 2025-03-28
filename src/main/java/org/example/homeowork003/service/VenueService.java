package org.example.homeowork003.service;

import org.example.homeowork003.model.dto.Venue;
import org.example.homeowork003.model.dto.request.VenueRequest;
import org.springframework.stereotype.Service;

import java.util.List;

public interface VenueService {
    List<Venue> getAllVenues(Integer size, Integer page);

    Venue addVenue(VenueRequest venueRequest);

    Venue getVenueById(Integer id);

    Venue updateVenueById(Integer id, VenueRequest venueRequest);

    Venue deleteVenueById(Integer id);
}
