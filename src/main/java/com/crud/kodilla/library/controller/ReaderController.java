package com.crud.kodilla.library.controller;

import com.crud.kodilla.library.domain.ReaderDto;
import com.crud.kodilla.library.mapper.ReaderMapper;
import com.crud.kodilla.library.repository.ReaderRepository;
import com.crud.kodilla.library.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@Transactional
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
    public ReaderDto getReader(@PathVariable Long readerId) throws LibraryNotFoundException  {
        return readerMapper.mapToReaderDto(readerService.getReader(readerId).orElseThrow(LibraryNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/reader", consumes = APPLICATION_JSON_VALUE)
    public void createReader(@RequestBody ReaderDto readerDto) {
        readerService.saveReader(readerMapper.mapToReader(readerDto));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/reader/{readerId}")
    public void deleteReader(@PathVariable Long readerId) {
            readerService.deleteReader(readerId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/reader")
    public ReaderDto updateReader(@RequestBody ReaderDto readerDto) {
        return readerMapper.mapToReaderDto(readerService.saveReader(readerMapper.mapToReader(readerDto)));
    }

}
