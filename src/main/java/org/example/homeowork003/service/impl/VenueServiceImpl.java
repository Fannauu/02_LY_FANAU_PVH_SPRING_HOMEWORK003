package org.example.homeowork003.service.impl;

import org.example.homeowork003.exception.NotFoundException;
import org.example.homeowork003.model.dto.Venue;
import org.example.homeowork003.model.dto.request.VenueRequest;
import org.example.homeowork003.repository.VenueRepository;
import org.example.homeowork003.service.VenueService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueServiceImpl implements VenueService {
    private final VenueRepository venueRepository;

    public VenueServiceImpl(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    @Override
    public List<Venue> getAllVenues(Integer size, Integer page) {
        return venueRepository.getAllVenues(size, page);
    }

    @Override
    public Venue addVenue(VenueRequest venueRequest) {
        return venueRepository.addVenue(venueRequest);
    }

    @Override
    public Venue getVenueById(Integer id) {
        Venue venue = venueRepository.getVenueById(id);
        if (venue == null) {
            throw new NotFoundException("Venue id " + id + " not found");
        }
        return venue;
    }


    @Override
    public Venue updateVenueById(Integer id, VenueRequest venueRequest) {
        Venue venue = venueRepository.updateVenueById(id, venueRequest);
        if (venue == null) {
            throw new NotFoundException("Venue id " + id + " not found can't be updated");
        }
        return venue;
    }

    @Override
    public Venue deleteVenueById(Integer id) {
        Venue venue = venueRepository.deleteVenueById(id);
        if (venue == null) {
            throw new NotFoundException("Venue id " + id + " not found can't be deleted");
        }
        return venueRepository.deleteVenueById(id);
    }

}
