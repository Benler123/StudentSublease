package com.example.subleasesite.Listing;

import com.example.subleasesite.Student.Student;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Builder
public class Listing {

    @Id
    @SequenceGenerator(name="listing_sequence", sequenceName = "listing_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "listing_sequence")
    private int Id;
    private String picture;
    private float price;
    @JsonFormat(pattern = "MM-dd-yyyy")
    private LocalDate startDate;
    @JsonFormat(pattern = "MM-dd-yyyy")
    private LocalDate endDate;
    private int bedCount;
    private int bathroomCount;
    private int roomsAvailable;
    private boolean hasWasherAndDrier;
    private String description;

    @Transient
    private long studentId;

    @ManyToOne
    private Student student;
}
