package com.example.subleasesite.Student;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@NoArgsConstructor
@Getter @Setter
public class Student {
    @Id
    @SequenceGenerator(
        name="student_account_sequence",
        sequenceName = "student_account_sequence",
        allocationSize = 1
    )
    @GeneratedValue (
        strategy = GenerationType.SEQUENCE,
        generator = "student_account_sequence"
    )
    private Long id;
    private String name;
    private String email;

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

}
