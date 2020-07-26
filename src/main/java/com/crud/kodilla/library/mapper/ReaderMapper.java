package com.crud.kodilla.library.mapper;

import com.crud.kodilla.library.domain.Reader;
import com.crud.kodilla.library.domain.ReaderDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReaderMapper {

    public Reader mapToReader(final ReaderDto readerDto) {
        return new Reader(
                readerDto.getId(),
                readerDto.getReaderId(),
                readerDto.getName(),
                readerDto.getSurname(),
                readerDto.getDayOfCreatedAccount());
    }

    public ReaderDto mapToReaderDto(final Reader reader) {
        return new ReaderDto(
                reader.getId(),
                reader.getReaderId(),
                reader.getName(),
                reader.getSurname(),
                reader.getDayOfCreatedAccount());
    }

    public List<ReaderDto> mapToReaderDtoList(final List<Reader> readerList){
        return readerList.stream()
                .map(reader -> new ReaderDto(reader.getId(),reader.getReaderId(), reader.getName(), reader.getSurname(), reader.getDayOfCreatedAccount()))
                .collect(Collectors.toList());
    }
}
