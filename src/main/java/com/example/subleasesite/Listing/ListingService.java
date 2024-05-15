package com.example.subleasesite.Listing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListingService {
    public ListingRepository listingRepository;

    @Autowired
    public ListingService(ListingRepository listingRepository) {
        this.listingRepository = listingRepository;
    }

    public List<Listing> getListings() {
        return listingRepository.findAll();
    }

    public void addListing(Listing listing) {

    }
}
