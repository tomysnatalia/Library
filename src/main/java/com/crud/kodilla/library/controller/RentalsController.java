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

    @RequestMapping(method = RequestMethod.GET, value = "/rentalByExampleId/{exampleId}")
    public RentalsDto  getRentalsByExampleId (@PathVariable Long exampleId) throws LibraryNotFoundException {
        return rentalsMapper.mapToRentalsDto(rentalsService.getRentalsByExampleId(exampleId).orElseThrow(LibraryNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/rentalByReaderId/{readerId}")
    public RentalsDto getRentalsByReaderId (@PathVariable Long readerId) throws LibraryNotFoundException {
        return rentalsMapper.mapToRentalsDto(rentalsService.getRentalsByExampleId(readerId).orElseThrow(LibraryNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/rental", consumes = APPLICATION_JSON_VALUE)
    public void createRental(@RequestBody RentalsDto rentalsDto) {
        rentalsService.saveRentals(rentalsMapper.mapToRentals(rentalsDto));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/rental/{exampleId}")
    public void deleteRental(@PathVariable Long exampleId) throws LibraryNotFoundException{
        if(rentalsService.getRentalsByExampleId(exampleId).isPresent())
            rentalsService.deleteRental(exampleId);
        else
            throw new LibraryNotFoundException();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/rentals")
    public RentalsDto updateRental (@RequestBody RentalsDto rentalsDto) {
        return new RentalsDto(1L, 2425L, 890314L, LocalDate.of(2020,7,25), LocalDate.of(2020,8, 25));
    }
}
