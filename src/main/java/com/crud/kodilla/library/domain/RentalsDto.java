package com.crud.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor

public class RentalsDto {
    private Long id;
    private Long exampleId;
    private Long readerId;
    private LocalDate rentalDay;
    private LocalDate returnDay;
}
