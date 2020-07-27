package com.crud.kodilla.library.interfaces;

import com.crud.kodilla.library.domain.BookCopies;

import java.util.List;

public interface BookCopiesInterfaceRepository {

   List<BookCopies> findByTitleId(Long titleId);

   void deleteByExampleId(Long exampleId);
}
