package com.crud.kodilla.library.repository;

import com.crud.kodilla.library.domain.Book;
import com.crud.kodilla.library.interfaces.BookInterface;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Long>, BookInterface {

    @Override
    List<Book> findAll();

    @Override
    Book save (Book book);

    @Override
    void deleteById (Long id);

    @Override
    Optional<Book> findByTitle (String title);

    @Override
    Optional<Book> findByAuthor (String author);


}


