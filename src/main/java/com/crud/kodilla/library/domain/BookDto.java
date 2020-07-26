package com.crud.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class BookDto {
    private Long id;
    private Long titleId;
    private String title;
    private String author;
    private int yearOfPublishing;


}
