package com.danielbonilla.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private LocalDate dateOfBirth;

    @JsonIgnore
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY,cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Grade> grades;
}
