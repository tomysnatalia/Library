package com.crud.kodilla.library.controller;

import com.crud.kodilla.library.domain.ReaderDto;
import com.crud.kodilla.library.mapper.ReaderMapper;
import com.crud.kodilla.library.repository.ReaderRepository;
import com.crud.kodilla.library.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v2")
public class ReaderController {

    @Autowired
    private ReaderService readerService;

    @Autowired
    private ReaderMapper readerMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/readers")
    public List<ReaderDto> getReaders() {
        return readerMapper.mapToReaderDtoList(readerService.getAllReaders());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/reader/{readerId}")
    public ReaderDto getReaderByReaderId(@PathVariable Long readerId) throws LibraryNotFoundException  {
        return readerMapper.mapToReaderDto(readerService.getReaderByReaderId(readerId).orElseThrow(LibraryNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/reader", consumes = APPLICATION_JSON_VALUE)
    public void createReader(@RequestBody ReaderDto readerDto) {
        readerService.saveReader(readerMapper.mapToReader(readerDto));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/reader/{readerId}")
    public void deleteReader(@PathVariable Long readerId) throws LibraryNotFoundException {
        if(readerService.getReaderByReaderId(readerId).isPresent())
            readerService.deleteReader(readerId);
        else
            throw new LibraryNotFoundException();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/reader")
    public ReaderDto updateReader(@RequestBody ReaderDto readerDto) {
        return new ReaderDto(1L, 890314L, "John", "Morgan", LocalDate.of(2020,07,24));
    }

}
