package com.crud.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "rentals")
public class Rentals {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "exampleId", unique = true)
    private Long exampleId;

    @Column(name = "readerId", unique = true)
    private Long readerId;

    @Column(name = "rentalDay")
    private LocalDate rentalDay;

    @Column(name = "returnDay")
    private LocalDate returnDay;
}
