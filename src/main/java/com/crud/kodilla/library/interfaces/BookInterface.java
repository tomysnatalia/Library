package com.crud.kodilla.library.interfaces;

import com.crud.kodilla.library.domain.Book;

import java.util.Optional;

public interface BookInterface {

    Optional<Book> findByTitle (String title);

    Optional<Book> findByAuthor (String author);
}
