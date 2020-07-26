package com.crud.kodilla.library.interfaces;

import com.crud.kodilla.library.domain.Reader;

import java.util.Optional;

public interface ReaderInterface {

    void deleteByReaderId(Long readerId);

    Optional<Reader> findByReaderId(Long readerId);
}
