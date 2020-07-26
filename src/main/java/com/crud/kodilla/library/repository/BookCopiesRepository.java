package com.crud.kodilla.library.repository;

import com.crud.kodilla.library.domain.BookCopies;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookCopiesRepository extends CrudRepository<BookCopies, Long> , BookCopiesInterfaceRepository {

    @Override
    List<BookCopies> findAll();

    @Override
    BookCopies save (BookCopies bookCopies);

    @Override
    BookCopies findByTitleId(Long titleId);

    @Override
    void deleteByExampleId(Long exampleId);


}
