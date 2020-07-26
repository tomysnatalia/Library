package com.crud.kodilla.library.controller;

import com.crud.kodilla.library.domain.BookDto;
import com.crud.kodilla.library.mapper.BookMapper;
import com.crud.kodilla.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v2")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookMapper bookMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/books")
    public List<BookDto> getBooks() {
        return bookMapper.mapToBookDtoList(bookService.getAllBooks());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/bookTitle/{title}")
    public BookDto getTitle(@PathVariable String title) throws LibraryNotFoundException {
        return bookMapper.mapToBookDto(bookService.getTitle(title).orElseThrow(LibraryNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/bookAuthor/{author}")
    public BookDto getAuthor(@PathVariable String author) throws LibraryNotFoundException {
        return bookMapper.mapToBookDto(bookService.getAuthor(author).orElseThrow(LibraryNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/book", consumes = APPLICATION_JSON_VALUE)
    public void createBook(@RequestBody BookDto bookDto) {
        bookService.saveBook(bookMapper.mapToBook(bookDto));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/book/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/book")
    public BookDto updateBook(@RequestBody BookDto bookDto) {
        return new BookDto( 1L, 2425L, "Czysty Kod", "Robert C.Martin", 2014);
    }
}
