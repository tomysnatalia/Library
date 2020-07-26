package com.crud.kodilla.library.controller;

import com.crud.kodilla.library.domain.BookCopiesDto;
import com.crud.kodilla.library.domain.RentalsDto;
import com.crud.kodilla.library.mapper.RentalsMapper;

import com.crud.kodilla.library.service.RentalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RestController
@RequestMapping("/v2")
public class RentalsController {

    @Autowired
    private RentalsService rentalsService;

    @Autowired
    private RentalsMapper rentalsMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/rentals")
    public List<RentalsDto> getRentals() {
        return rentalsMapper.mapToRentalsDtoList(rentalsService.getAllRentals());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/rentalExample/{exampleId}")
    public RentalsDto  getRentalExample(@PathVariable Long exampleId) throws LibraryNotFoundException {
        return rentalsMapper.mapToRentalsDto(rentalsService.getRentalExample(exampleId).orElseThrow(LibraryNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/rentalReader/{readerId}")
    public RentalsDto getRentalReader(@PathVariable Long readerId) throws LibraryNotFoundException {
        return rentalsMapper.mapToRentalsDto(rentalsService.getRentalReader(readerId).orElseThrow(LibraryNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/rental", consumes = APPLICATION_JSON_VALUE)
    public void createRental(@RequestBody RentalsDto rentalsDto) {
        rentalsService.saveRentals(rentalsMapper.mapToRentals(rentalsDto));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/rental/{id}")
    public void deleteRental(@PathVariable Long id) {
            rentalsService.deleteRental(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/rentals")
    public RentalsDto updateRental (@RequestBody RentalsDto rentalsDto) {
        return rentalsMapper.mapToRentalsDto(rentalsService.saveRentals(rentalsMapper.mapToRentals(rentalsDto)));
    }
}
