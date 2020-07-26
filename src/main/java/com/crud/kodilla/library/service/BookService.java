package com.crud.kodilla.library.service;

import com.crud.kodilla.library.domain.Book;
import com.crud.kodilla.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }


    public void saveBook (final Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(final Long id) {
        bookRepository.deleteById(id);
    }

    public Optional<Book> getTitle(final String title) {
        return bookRepository.findByTitle(title);
    }

    public Optional<Book> getAuthor(final String author) {
        return bookRepository.findByAuthor(author);
    }
}
