package com.crud.kodilla.library.repository;

import com.crud.kodilla.library.domain.Book;
import com.crud.kodilla.library.domain.BookCopies;

import java.util.List;
import java.util.Optional;

public interface BookCopiesInterfaceRepository {

   BookCopies findByTitleId(Long titleId);

   void deleteByExampleId(Long exampleId);
}
