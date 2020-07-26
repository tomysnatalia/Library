package com.crud.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor

public class ReaderDto {
    private Long id;
    private Long readerId;
    private String name;
    private String surname;
    private LocalDate dayOfCreatedAccount;

}
