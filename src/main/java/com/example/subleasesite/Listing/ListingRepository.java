package com.example.subleasesite.Listing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ListingRepository extends JpaRepository<Listing, Long> {

}
