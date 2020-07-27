package com.crud.kodilla.library.mapper;

import com.crud.kodilla.library.domain.BookCopies;
import com.crud.kodilla.library.domain.BookCopiesDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookCopiesMapper {
    public BookCopies mapToBookCopies (final BookCopiesDto bookCopiesDto) {
        return new BookCopies(
                bookCopiesDto.getId(),
                bookCopiesDto.getExampleId(),
                bookCopiesDto.getTitleId(),
                bookCopiesDto.getIsLost(),
                bookCopiesDto.getIsBorrowed(),
                bookCopiesDto.getIsDestroyed());
    }

    public BookCopiesDto mapToBookCopiesDto (final BookCopies bookCopies) {
        return new BookCopiesDto(
                bookCopies.getId(),
                bookCopies.getExampleId(),
                bookCopies.getTitleId(),
                bookCopies.getIsLost(),
                bookCopies.getIsBorrowed(),
                bookCopies.getIsDestroyed());
    }

    public List<BookCopiesDto> mapToBookCopiesDtoList (final List<BookCopies> bookCopiesList) {
        return bookCopiesList.stream()
                .map(copies -> new BookCopiesDto(copies.getId(), copies.getExampleId(), copies.getTitleId(), copies.getIsLost(), copies.getIsBorrowed(), copies.getIsDestroyed()))
                .collect(Collectors.toList());
    }
}
