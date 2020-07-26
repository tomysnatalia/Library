package com.crud.kodilla.library.repository;

import com.crud.kodilla.library.domain.Rentals;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RentalsRepository extends CrudRepository<Rentals, Long> {

    @Override
    List<Rentals> findAll();

    @Override
    Rentals save (Rentals rentals);
}
