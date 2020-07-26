package com.crud.kodilla.library.repository;

import com.crud.kodilla.library.domain.Rentals;
import com.crud.kodilla.library.interfaces.RentalsInterface;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RentalsRepository extends CrudRepository<Rentals, Long>, RentalsInterface {

    @Override
    List<Rentals> findAll();

    @Override
    Rentals save (Rentals rentals);

    @Override
    void deleteById (Long id);

    @Override
    Optional<Rentals> findByReaderId(Long readerId);

    @Override
    Optional<Rentals> findByExampleId(Long exampleId);
}
