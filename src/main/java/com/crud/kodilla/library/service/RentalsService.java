package com.crud.kodilla.library.service;

import com.crud.kodilla.library.domain.Rentals;
import com.crud.kodilla.library.repository.RentalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentalsService {

    @Autowired
    private RentalsRepository rentalsRepository;

    public List<Rentals> getAllRentals(){
        return rentalsRepository.findAll();
    }


    public Optional <Rentals> getRentalExample(Long exampleId) {
        return rentalsRepository.findByExampleId(exampleId);
    }

    public Optional<Rentals> getRentalReader(Long readerId) {
        return rentalsRepository.findByReaderId(readerId);
    }

    public Rentals saveRentals (Rentals rentals) {
        return rentalsRepository.save(rentals);
    }

    public void deleteRental (final Long id) {
        rentalsRepository.deleteById(id);
    }
}
