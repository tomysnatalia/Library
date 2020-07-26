package com.crud.kodilla.library.controller;

import com.crud.kodilla.library.domain.BookCopiesDto;
import com.crud.kodilla.library.mapper.BookCopiesMapper;
import com.crud.kodilla.library.service.BookCopiesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@Transactional
@RestController
@RequestMapping("/v2")
public class BookCopiesController {

    @Autowired
    BookCopiesService bookCopiesService;

    @Autowired
    BookCopiesMapper bookCopiesMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/bookCopies")
    public List<BookCopiesDto> getBookCopies() {
        return bookCopiesMapper.mapToBookCopiesDtoList(bookCopiesService.getAllBookCopies());
    }


    @RequestMapping(method = RequestMethod.GET, value = "/bookCopies/{titleId}")
    public BookCopiesDto getBook(@PathVariable Long titleId) {
        return bookCopiesMapper.mapToBookCopiesDto(bookCopiesService.getBook(titleId));
    }


    @RequestMapping(method = RequestMethod.POST, value = "/bookCopy", consumes = APPLICATION_JSON_VALUE)
    public void createBook(@RequestBody BookCopiesDto bookCopiesDto) {
        bookCopiesService.saveBookCopy(bookCopiesMapper.mapToBookCopies(bookCopiesDto));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/bookCopies/{exampleId}")
    public void deleteBookCopies (@PathVariable Long exampleId) {
            bookCopiesService.deleteBookCopies(exampleId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/bookCopies")
    public BookCopiesDto updateBook(@RequestBody BookCopiesDto bookCopiesDto) {
        return bookCopiesMapper.mapToBookCopiesDto(bookCopiesService.saveBookCopy(bookCopiesMapper.mapToBookCopies(bookCopiesDto)));
    }

}
