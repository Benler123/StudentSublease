package com.example.subleasesite.Listing;

import com.example.subleasesite.Student.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Listing {

    @Id
    private int Id;
    private String picture;
    private float price;
    private LocalDate startDate;
    private LocalDate endDate;
    private int bedCount;
    private int bathroomCount;
    private int roomsAvailable;
    private boolean hasWasherAndDrier;
    private String description;

    @ManyToOne
    private Student student;
}
