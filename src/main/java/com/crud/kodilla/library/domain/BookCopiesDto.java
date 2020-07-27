package com.crud.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class BookCopiesDto {
    private Long id;
    private Long exampleId;
    private Long titleId;
    private String isLost;
    private String isBorrowed;
    private String isDestroyed;
}

