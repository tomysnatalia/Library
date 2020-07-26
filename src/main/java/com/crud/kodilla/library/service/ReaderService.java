package com.crud.kodilla.library.service;

import com.crud.kodilla.library.domain.BookCopies;
import com.crud.kodilla.library.domain.Reader;
import com.crud.kodilla.library.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReaderService {

    @Autowired
    private ReaderRepository readerRepository;

    public List<Reader> getAllReaders() {
        return readerRepository.findAll();
    }

    public Optional<Reader> getReader (final Long readerId) {
        return readerRepository.findByReaderId(readerId);
    }

    public Reader saveReader (final Reader reader) {
        return readerRepository.save(reader);
    }

    public void deleteReader (final Long readerId) {
        readerRepository.deleteByReaderId(readerId);
    }
}
