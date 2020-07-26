package com.crud.kodilla.library.mapper;

import com.crud.kodilla.library.domain.Rentals;
import com.crud.kodilla.library.domain.RentalsDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RentalsMapper {

    public Rentals mapToRentals (final RentalsDto rentalsDto) {
        return new Rentals(
                rentalsDto.getId(),
                rentalsDto.getExampleId(),
                rentalsDto.getReaderId(),
                rentalsDto.getRentalDay(),
                rentalsDto.getReturnDay());
    }

    public RentalsDto mapToRentalsDto(final Rentals rentals) {
        return new RentalsDto(
                rentals.getId(),
                rentals.getExampleId(),
                rentals.getReaderId(),
                rentals.getRentalDay(),
                rentals.getReturnDay());
    }

    public List<RentalsDto> mapToRentalsDtoList (List<Rentals> rentalsList) {
        return rentalsList.stream()
                .map(rentals -> new RentalsDto(rentals.getId(),rentals.getExampleId(), rentals.getReaderId(),rentals.getRentalDay(), rentals.getReturnDay()))
                .collect(Collectors.toList());
    }
}
