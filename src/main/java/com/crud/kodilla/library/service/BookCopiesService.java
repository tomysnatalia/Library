package com.crud.kodilla.library.service;

import com.crud.kodilla.library.domain.Book;
import com.crud.kodilla.library.domain.BookCopies;
import com.crud.kodilla.library.repository.BookCopiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookCopiesService {

    @Autowired
    private BookCopiesRepository bookCopiesRepository;

    public List<BookCopies> getAllBookCopies() {
        return bookCopiesRepository.findAll();
    }

    public BookCopies saveBookCopy(final BookCopies bookCopies) {
        return bookCopiesRepository.save(bookCopies);
    }

    public List<BookCopies> getBook(final Long titleId) {
        return bookCopiesRepository.findByTitleId(titleId);
    }

    public void deleteBookCopies (final Long exampleId) {
        bookCopiesRepository.deleteByExampleId(exampleId);
    }


}
