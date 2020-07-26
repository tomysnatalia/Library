package com.crud.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "bookCopies")
public class BookCopies {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "exapleId", unique = true)
    private Long exampleId;

    @Column(name = "titleId", unique = false)
    private Long titleId;

    @Column(name = "isLost")
    boolean isLost;

    @Column(name = "isBorrowed")
    boolean isBorrowed;

    @Column(name = "isDestroyed")
    boolean isDestroyed;


}
