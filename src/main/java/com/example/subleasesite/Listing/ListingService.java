package com.example.subleasesite.Listing;

import com.example.subleasesite.Student.Student;
import com.example.subleasesite.Student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListingService {
    private final ListingRepository listingRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public ListingService(ListingRepository listingRepository, StudentRepository studentRepository) {
        this.listingRepository = listingRepository;
        this.studentRepository = studentRepository;
    }

    public List<Listing> getListings() {
        return listingRepository.findAll();
    }

    public void addListing(Listing listing) {
        Optional<Student> student = studentRepository.findById(listing.getStudentId());

        if (!student.isPresent()) {
            throw new IllegalArgumentException("Student with id " + listing.getStudentId() + " does not exist");
        }
        listing.setStudent(student.get());
        listingRepository.save(listing);
    }
}
