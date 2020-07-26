package com.crud.kodilla.library.repository;

import com.crud.kodilla.library.domain.Reader;
import com.crud.kodilla.library.interfaces.ReaderInterface;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ReaderRepository extends CrudRepository<Reader, Long>, ReaderInterface {

    @Override
    List<Reader> findAll();

    @Override
    Reader save (Reader reader);

    @Override
    Optional<Reader> findByReaderId(Long readerId);

    @Override
    void deleteByReaderId(Long readerId);

}
