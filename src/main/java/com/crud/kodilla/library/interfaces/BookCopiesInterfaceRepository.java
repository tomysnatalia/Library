package com.crud.kodilla.library.interfaces;

import com.crud.kodilla.library.domain.BookCopies;

public interface BookCopiesInterfaceRepository {

   BookCopies findByTitleId(Long titleId);

   void deleteByExampleId(Long exampleId);
}
