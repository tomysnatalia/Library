package com.crud.kodilla.library.interfaces;

import com.crud.kodilla.library.domain.Reader;
import com.crud.kodilla.library.domain.Rentals;

import java.util.Optional;

public interface RentalsInterface {

    Optional<Rentals>findByReaderId(Long readerId);

    Optional<Rentals> findByExampleId(Long exampleId);
}
